package com.sxh.boot2.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author SXH
 * @description 测试配置 @ConfigurationProperties
 * @date 2021/1/11 0:14
 */
//@Component  // 也可以不用使用@Component,改为使用
@ConfigurationProperties(prefix = "test.configuration.properties.car")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private String name;
    private Integer price;
}
