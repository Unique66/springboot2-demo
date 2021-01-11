package com.sxh.boot2.demo.config;

import ch.qos.logback.core.db.DBHelper;
import com.sxh.boot2.demo.model.Car;
import com.sxh.boot2.demo.model.Pet;
import com.sxh.boot2.demo.model.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author SXH
 * @description 自定义配置
 * @date 2021/1/10 23:05
 *
 * 1.配置类里面使用@Bean 标注在方法上给容器注册组件，默认是单例的
 * 2.配置类本身也是组件
 * 3.ProxyBeanMethods：代理bean 的方法
 *      Full(ProxyBeanMethods = true)
 *      Lite(ProxyBeanMethods = false)
 */
@EnableConfigurationProperties(value = Car.class)
// ImportResource 导入指定配置文件到容器中
@ImportResource("classpath:beans.xml")
// @Import 给容器中自动创建出指定类型的组件，组件名为全类名
@Import({User.class, DBHelper.class})
// @Configuration 告诉SpringBoot 这是一个配置类，与xml 配置文件一样
@Configuration(proxyBeanMethods = true)
public class MyConfig {
//    @ConditionalOnBean(name = "pet")
    @Bean
    public User user() {
        User user = new User("peter", 12);
        user.setPet(pet());
        return user;
    }

    @Bean(value = "getPet")
    public Pet pet() {
        return new Pet("L", 2);
    }
}
