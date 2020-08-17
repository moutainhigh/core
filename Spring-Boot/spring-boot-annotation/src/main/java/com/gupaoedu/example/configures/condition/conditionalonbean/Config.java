package com.gupaoedu.example.configures.condition.conditionalonbean;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ConditionalOnBeanע��������� �����д���ĳ��Beanʱ, ����е�ǰBean��װ��(ʵ����)��
 *
 * @Author: fengleima  2020/7/2 12:33
 */
@Configuration
public class Config {

    // Bean ������Ϊcity
    @Bean
    public City city() {
        City city = new City();
        System.out.println("ǧ����");
        city.setCityName("ǧ����");
        return city;
    }

    /**
     * �������ConditionalOnBeanע�⣬�ʹ������city���ڲ�ʵ����people
     * ��һ������ ��OK�ģ����ô���city��Bean,Ȼ�������� city���������city1(),�����򱨴�
     * ˵��@ConditionalOnBeanע���������  �����д���ĳ��Beanʱ,����е�ǰBean��װ��(ʵ����)��
     */
    @Bean
    @ConditionalOnBean(name = "city")
    public People people(City city) { // ����City�Ѿ�װ�ص������ˣ�������Զ�ע��  ����public People people(city())
        //�������cityʵ��û�гɹ�ע�� ����ͻᱨ��ָ��
        city.setCityCode(301701);
        city.getCityCode();
        new People();
        return new People("СС", 3, city);
    }
}
