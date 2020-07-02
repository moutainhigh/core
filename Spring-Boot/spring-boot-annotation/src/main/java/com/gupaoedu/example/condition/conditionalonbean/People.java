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
@Data  // ���� get��set ����
@NoArgsConstructor  // ����û�в����Ĺ��췽��
@AllArgsConstructor // ���ɴ��в����Ĺ��췽��
public class People {
    /**
     * ����
     */
    private String name;
    /**
     * ����
     */
    private Integer age;
    /**
     *  ������Ϣ
     */
    private City city;
}
