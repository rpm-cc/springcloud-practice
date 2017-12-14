本实例准备使用一个springcloud的方式创建一个简单应用。
采用：
1、服务注册：eureka；
2、服务消费者（客户端负载均衡）：使用feign；
3、断路器——Netflix Hystrix；
4、服务网关——Netflix Zuul；
5、分布式配置——Spring Cloud Config；
端口设置：
eureka  服务端：8761  
eureka  消费端设置：8762～8769
feign+hystrix 客户端负载均衡断路器：8770～8772
zuul    服务网关：8773～8775
config-server： 8776   
config-client:8777
model 介绍：
config-server 作为分布式配置。目前来讲还没有完全明白用法；
eureka-server  服务注册，将服务注册到eureka中
eureka-user-provider 服务消费者。
eureka-goods-provider 服务消费者。
feign-server 实现客户端负载均衡。并且实现断路器功能。
zuul-server 实现路由功能；




实践中要实现的内容：
1：使用mysql+mybatis数据实现用户注册。登陆。用户信息修改；
2：实现session共享。
3：实现商品录入和查询。页面使用freemarker实现。
4：负载均衡。路由。
5：实现服务间互相消费
6：实现统一异常处理。
7：实现配置服务器的使用。
8：实现消息总线。