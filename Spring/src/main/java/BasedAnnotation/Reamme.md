####Bean的初始化和销毁
    Java配置方式：使用@Bean的initMethod和destroyMethod(相当于xml配置的init-method和destory-method)
    注解方式：利用JSR-250的@PostConstruct和@PreDestroy

#####@Bean
    大部分开发中都需要引入第三方jar包，往往并没有这些包的源码，这时不能使用@Component注解。
    这种情况下Spring提供了@Bean注解，它可以注解在方法上，并将方法返回的对象作为Spring的Bean注入

#####@Import注解是引入带有@Configuration的java类。

#####@ImportResource是引入spring配置文件.xml
