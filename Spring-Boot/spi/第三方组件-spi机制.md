# SPI机制
Service provider interface
满足以下条件
-	需要在classpath目录下创建一个META-INF/services
-	在该目录下创建一个扩展点的全路径名
-	文件中填写这个扩展点的实现
-	文件编码格式UTF-8
-	ServiceLoader去进行加载
------	
- 对于官方组件,是基于condition条件来决定对于类是否要自动装配,对于第三方组件,是采用spi机制来实现扩展