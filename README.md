<h2>实例介绍</h2>
本实例准备使用一个springcloud的方式创建一个简单应用。</br>
采用：</br>
1、服务注册：eureka；</br>
2、服务消费者（客户端负载均衡）：使用feign；</br>
3、断路器——Netflix Hystrix；</br>
4、服务网关——Netflix Zuul；</br>
5、分布式配置——Spring Cloud Config；</br>
端口设置：</br>
eureka  服务端：8761  </br>
eureka  消费端设置：8762～8769</br>
feign+hystrix 客户端负载均衡断路器：8770～8772</br>
zuul    服务网关：8773～8775</br>
config-server： 8776   </br>
config-client:8777</br>
model 介绍：</br>
config-server 作为分布式配置。目前来讲还没有完全明白用法；</br>
eureka-server  服务注册，将服务注册到eureka中</br>
eureka-user-provider 服务消费者。</br>
eureka-goods-provider 服务消费者。</br>
feign-server 实现客户端负载均衡。并且实现断路器功能。</br>
zuul-server 实现路由功能；</br>
demo 实现一些其spring boot和其他组件的整合</br>



实践中要实现的内容：</br>
1：使用mysql+mybatis数据实现用户注册。登陆。用户信息修改；</br>
2：实现session共享。</br>
3：实现商品录入和查询。页面使用freemarker实现。</br>
4：负载均衡。路由。</br>
5：实现服务间互相消费</br>
6：实现统一异常处理。</br>
7：实现配置服务器的使用。</br>
8：实现消息总线。</br>


参考文献
<a href="https://github.com/dyc87112/SpringBoot-Learning"> 程序猿DD-翟永超 的github</a>
<a href="https://github.com/forezp">方志朋的 github</a>
<a href="http://graphql.cn/learn/">graphql 中文文档</a>
<a href="https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/">Spring Boot Reference Guide</a>
<a href="http://www.baeldung.com/spring-graphql">Getting Started with GraphQL and Spring Boot</a>