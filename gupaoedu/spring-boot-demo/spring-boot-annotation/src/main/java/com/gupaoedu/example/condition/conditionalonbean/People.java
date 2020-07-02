package com.gupaoedu.example.condition.conditionalonbean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description:
 * @Titile: IntelliJ IDEA
 * @Author: fengleima  2020/7/2 12:24
 * @Version:1.0
 */
@Data  // 生成 get、set 方法
@NoArgsConstructor  // 生成没有参数的构造方法
@AllArgsConstructor // 生成带有参数的构造方法
public class People {
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     *  城市信息
     */
    private City city;
}
