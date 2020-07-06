

http://localhost:8080/orders

Feign： http通信，伪RPC，和Ribbon结合使用。如果用OpenFeign离不开Ribbon。
声明式的伪RPC,实现了远程通信的机制，提供了一种面相接口的代理的封装，默认继承Ribbon来完成负载均衡。

在Feign里面是基于注接口的方式完成请求，好处是，使得请求可以模板化，可以通过接口描述去完成服务提供者，可以屏蔽底层很多复杂的逻辑。

FeignClientCongiguration配置类
