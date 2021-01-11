package com.sxh.boot2.demo;

import ch.qos.logback.core.db.DBHelper;
import com.sxh.boot2.demo.config.MyConfig;
import com.sxh.boot2.demo.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        // 1.返回IOC 容器
        ConfigurableApplicationContext context =
                SpringApplication.run(DemoApplication.class, args);
        // 2.查看容器中的组件
        System.out.println("--------------->Test ConfigurableApplicationContext' getBeanDefinitionNames()");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        int beanDefinitionCount = context.getBeanDefinitionCount();
        System.out.println("beanDefinitionCount:" + beanDefinitionCount);
        Arrays.stream(beanDefinitionNames).forEach(con -> System.out.println(con));

        // 3.测试@Bean 和@Configuration
        System.out.println("--------------->Test @Bean and @Configuration");
        MyConfig bean = context.getBean(MyConfig.class);
        // com.sxh.boot2.demo.Config.MyConfig$$EnhancerBySpringCGLIB$$b850cd85@58faa93b
        // CGLIB 代理实现
        System.out.println(bean);

        User user1 = bean.user();
        User user2 = bean.user();
        System.out.println(user1 == user2);
        System.out.println(bean.pet());

        // 4.测试@Import
        System.out.println("--------------->Test @Import");
        String[] beanNamesForType = context.getBeanNamesForType(User.class);
        Arrays.stream(beanNamesForType).forEach(System.out::println);
        DBHelper dbHelper = context.getBean(DBHelper.class);
        System.out.println(dbHelper);

        // 5.测试@Conditional 以及其子类 如@ConditionalOnBean
        System.out.println("--------------->Test @Conditional");
//        boolean haveUser = context.containsBean("user");
//        System.out.println(haveUser);

        // 6.测试@ImportResource 导入配置文件到容器
        // 未加该注解前，是拿不到配置文件的实例的，加了之后可以拿到配置文件指定实例
        System.out.println("--------------->Test @ImportResource");
        boolean importResourceUser = context.containsBean("importResourceUser");
        System.out.println(importResourceUser);
    }
}
