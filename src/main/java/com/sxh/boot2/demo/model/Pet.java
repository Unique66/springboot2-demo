package com.sxh.boot2.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author SXH
 * @description User's Pet
 * @date 2021/1/10 23:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    private String nickName;
    private Integer age;
}
