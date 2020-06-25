#批量扫描

Spring的动态Bean的装载 两种方式
- ImportSelector: 使用  ImportSelector 实现批量扫描
- ImportBeanDefinitionRegistrar

去xml化是通过 @Configuration及其配合@Bean 来实现的

```
@Override
	public String[] selectImports(AnnotationMetadata annotationMetadata) {
		if (!isEnabled(annotationMetadata)) {
			return NO_IMPORTS;
		}
		AutoConfigurationMetadata autoConfigurationMetadata = AutoConfigurationMetadataLoader
				.loadMetadata(this.beanClassLoader);
		AutoConfigurationEntry autoConfigurationEntry = getAutoConfigurationEntry(autoConfigurationMetadata,
				annotationMetadata);
		return StringUtils.toStringArray(autoConfigurationEntry.getConfigurations());
	}
```

##自动装配
提前写好配置类，配置类要被Spring Boot扫描到的前提是，要在resources下的META-INF目录下去创建spring.factories文件，把
需要自动装配的类写到文件中value处，Spring Boot在启动的时候基于自动装配的机制，会扫描到spring.factories文件中配置的
所有的类，扫描到之后会进行装载，最后再项目的应用中就能拿到装载的bean。

##Spring Boot自动装配
条件控制

对于官方组件,是基于condition条件来决定对于类是否要自动装配,对于第三方组件,是采用spi机制来实现扩展
- 官方包spring-boot-starter-xxx
- 第三方包xxx-spring-boot-starter
              例如：mybatis-spring-boot-starter   dubbo-spring-boot-starter