package com.gupaoedu.example.injections.qualifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @Qualifier ע�����ã��������д��ڶ����ͬ������Beanʱ����Qualifierע����к�ѡ��ָ��Ҫע�����ȷ���Ǹ�����
 * ��������ϻ򷽷��ϼ���@Qualifier ע�⣬Ҳû��ָ��ע��ȷ����Bean���ͻ�����м���@Qualifierע���bean��ע�������
 **/
@Component
public class CusComponent {
    private static final Logger LOGGEER = LoggerFactory.getLogger(CusComponent.class);

    /**
     * �Զ�װ��ʱ����ע�Ϳ������ֶλ������������ѡbean���޶�������Ҳ��������ע�������Զ���ע�ͣ���Щע�������������޶�����
     * spring Ĭ���ǵ����ģ�����һ�����ʹ���ʱ�����ﲻ��Qualifierע�ⲻ�ᱨ��
     */
    // ������TestClass����������������ﲻ��Ҫ����bean�����ƣ�spring�Ͳ��޷��жϣ�����Ҫע���������е���һ�����ͻᱨ��
    // ����������Qualifierע��ѡ��Ҫ���ص��Ǹ�bean  ֤���������д��ڶ����ͬ������Beanʱ����Qualifierע����к�ѡ��ָ��Ҫע�����ȷ���Ǹ�����
//    @Qualifier("testClass1")
    @Qualifier("testClass2")
    @Autowired
    private TestClass testClass;


    public void testQualifier() {
        LOGGEER.info(testClass.toString());
    }

}
