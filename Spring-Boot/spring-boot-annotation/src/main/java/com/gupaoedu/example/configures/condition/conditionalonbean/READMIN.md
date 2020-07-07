

```angular2

/**
 * @author Spencer Gibb
 * @author Julien Roy
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(Feign.class)
@EnableConfigurationProperties({ FeignClientProperties.class,
      FeignHttpClientProperties.class })
@Import(DefaultGzipDecoderConfiguration.class)
public class FeignAutoConfiguration {

   @Autowired(required = false)
   private List<FeignClientSpecification> configurations = new ArrayList<>();

   @Bean
   public HasFeatures feignFeature() {
      return HasFeatures.namedFeature("Feign", Feign.class);
   }

   @Bean
   public FeignContext feignContext() {
      FeignContext context = new FeignContext();
      context.setConfigurations(this.configurations);
      return context;
   }

   @Configuration(proxyBeanMethods = false)
   @ConditionalOnClass(name = "feign.hystrix.HystrixFeign")
   protected static class HystrixFeignTargeterConfiguration {

      @Bean
      @ConditionalOnMissingBean
      public Targeter feignTargeter() {
         return new HystrixTargeter();
      }

   }

   @Configuration(proxyBeanMethods = false)
   @ConditionalOnMissingClass("feign.hystrix.HystrixFeign")
   protected static class DefaultFeignTargeterConfiguration {

      @Bean
      @ConditionalOnMissingBean
      public Targeter feignTargeter() {
         return new DefaultTargeter();
      }

   }

   // the following configuration is for alternate feign clients if
   // ribbon is not on the class path.
   // see corresponding configurations in FeignRibbonClientAutoConfiguration
   // for load balanced ribbon clients.
   @Configuration(proxyBeanMethods = false)
   @ConditionalOnClass(ApacheHttpClient.class)
   @ConditionalOnMissingClass("com.netflix.loadbalancer.ILoadBalancer")
   @ConditionalOnMissingBean(CloseableHttpClient.class)
   @ConditionalOnProperty(value = "feign.httpclient.enabled", matchIfMissing = true)
   protected static class HttpClientFeignConfiguration {

      private final Timer connectionManagerTimer = new Timer(
            "FeignApacheHttpClientConfiguration.connectionManagerTimer", true);

      @Autowired(required = false)
      private RegistryBuilder registryBuilder;

      private CloseableHttpClient httpClient;

      @Bean
      @ConditionalOnMissingBean(HttpClientConnectionManager.class)
      public HttpClientConnectionManager connectionManager(
            ApacheHttpClientConnectionManagerFactory connectionManagerFactory,
            FeignHttpClientProperties httpClientProperties) {
         final HttpClientConnectionManager connectionManager = connectionManagerFactory
               .newConnectionManager(httpClientProperties.isDisableSslValidation(),
                     httpClientProperties.getMaxConnections(),
                     httpClientProperties.getMaxConnectionsPerRoute(),
                     httpClientProperties.getTimeToLive(),
                     httpClientProperties.getTimeToLiveUnit(),
                     this.registryBuilder);
         this.connectionManagerTimer.schedule(new TimerTask() {
            @Override
            public void run() {
               connectionManager.closeExpiredConnections();
            }
         }, 30000, httpClientProperties.getConnectionTimerRepeat());
         return connectionManager;
      }

      @Bean
      public CloseableHttpClient httpClient(ApacheHttpClientFactory httpClientFactory,
            HttpClientConnectionManager httpClientConnectionManager,
            FeignHttpClientProperties httpClientProperties) {
         RequestConfig defaultRequestConfig = RequestConfig.custom()
               .setConnectTimeout(httpClientProperties.getConnectionTimeout())
               .setRedirectsEnabled(httpClientProperties.isFollowRedirects())
               .build();
         this.httpClient = httpClientFactory.createBuilder()
               .setConnectionManager(httpClientConnectionManager)
               .setDefaultRequestConfig(defaultRequestConfig).build();
         return this.httpClient;
      }

      @Bean
      @ConditionalOnMissingBean(Client.class)
      public Client feignClient(HttpClient httpClient) {
         return new ApacheHttpClient(httpClient);
      }

      @PreDestroy
      public void destroy() throws Exception {
         this.connectionManagerTimer.cancel();
         if (this.httpClient != null) {
            this.httpClient.close();
         }
      }

   }

   @Configuration(proxyBeanMethods = false)
   @ConditionalOnClass(OkHttpClient.class)
   @ConditionalOnMissingClass("com.netflix.loadbalancer.ILoadBalancer")
   @ConditionalOnMissingBean(okhttp3.OkHttpClient.class)
   @ConditionalOnProperty("feign.okhttp.enabled")
   protected static class OkHttpFeignConfiguration {

      private okhttp3.OkHttpClient okHttpClient;

      @Bean
      @ConditionalOnMissingBean(ConnectionPool.class)
      public ConnectionPool httpClientConnectionPool(
            FeignHttpClientProperties httpClientProperties,
            OkHttpClientConnectionPoolFactory connectionPoolFactory) {
         Integer maxTotalConnections = httpClientProperties.getMaxConnections();
         Long timeToLive = httpClientProperties.getTimeToLive();
         TimeUnit ttlUnit = httpClientProperties.getTimeToLiveUnit();
         return connectionPoolFactory.create(maxTotalConnections, timeToLive, ttlUnit);
      }

      @Bean
      public okhttp3.OkHttpClient client(OkHttpClientFactory httpClientFactory,
            ConnectionPool connectionPool,
            FeignHttpClientProperties httpClientProperties) {
         Boolean followRedirects = httpClientProperties.isFollowRedirects();
         Integer connectTimeout = httpClientProperties.getConnectionTimeout();
         Boolean disableSslValidation = httpClientProperties.isDisableSslValidation();
         this.okHttpClient = httpClientFactory.createBuilder(disableSslValidation)
               .connectTimeout(connectTimeout, TimeUnit.MILLISECONDS)
               .followRedirects(followRedirects).connectionPool(connectionPool)
               .build();
         return this.okHttpClient;
      }

      @PreDestroy
      public void destroy() {
         if (this.okHttpClient != null) {
            this.okHttpClient.dispatcher().executorService().shutdown();
            this.okHttpClient.connectionPool().evictAll();
         }
      }

      @Bean
      @ConditionalOnMissingBean(Client.class)
      public Client feignClient(okhttp3.OkHttpClient client) {
         return new OkHttpClient(client);
      }

   }

}
```