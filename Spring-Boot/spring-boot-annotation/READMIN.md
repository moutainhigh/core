

- @ConditionalOnBean：   容器中存在某个Bean时,则进行当前Bean的装载(实例化)。
- @ConditionalOnMissingBean:  容器中不存在某个Bean时,则进行当前Bean的装载。
- @ConditionalOnClass： classpath下存在指定的类时，则进行当前Bean的装载。
- @ConditionalOnMissingClass: classpath下不存在指定的类时，则进行当前Bean的装载。
- @ConditionalOnProperty: 系统中指定的对应的属性是否有对应的值。
- @ConditionalOnResource: 要加载的Bean依赖指定资源是否存在于classpath中。