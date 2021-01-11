package com.sxh.boot2.demo.controller;

import com.sxh.boot2.demo.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SXH
 * @description HelloController
 * @date 2021/1/11 0:17
 */
@RestController
public class HelloController {
    @Autowired
    private Car car;

    @GetMapping("/car")
    public Car getCar() {
        return car;
    }
}
