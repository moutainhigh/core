package com.gupaoedu.example.injections.qualifier.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @Titile: IntelliJ IDEA
 * @Author: fengleima  2020/7/3 13:21
 * @Version:1.0
 */
@Component
public class NumComponent {

    // ʹ��@Qualifier ע�⣬����û��ָ��ע��ȷ����Bean���ͻ�����м���@Qualifierע���bean��ע�������
    @Qualifier
    @Autowired
    List<NumBean> testClassList = Collections.emptyList();

    public Object test() {
        return testClassList;
    }
}
