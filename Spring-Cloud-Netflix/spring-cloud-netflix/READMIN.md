
# Spring-Cloud-Config

ע�����ĵ�ַ
- http://localhost:9090

�������ĵ�ַ
���� http://localhost:9091/user-service.properties


���г���֮����������� kafka,��kafka��Ҫzookeeper,���Ա�������zookeeper + kafka


�������� config �˿ں���9091


## ��������
- ��һ�������� kafka + zookeeper
- �ڶ���������spring-cloud-eureka-server-9090������spring-cloud-config-server-9091��
    ����eureka֮�󱨴���ʾCannot execute request on any known server������������
    ��ΪeurekaӦ������֮��Ĭ��ע��8761�˿ڣ������ʱ��û��8761�˿����Ծͻᱨ��
- �ڶ���������ע�����ĵ�ַ http://localhost:9090
- �ڶ��������� http://localhost:9091/user-service.properties ��ʱ��ȡ�������Ǵ�git�ϻ�ȡ��

![�Զ���ʾ��ͼ](spring-cloud-config-server-9091/src/main/resources/png/1.png)

˵���ɹ�

�� �������Ϣ��Դ��git
![�Զ���ʾ��ͼ](spring-cloud-config-server-9091/src/main/resources/png/2.png)

Ȼ����git����������ã�Ȼ��ˢ�µ�ַspring-cloud-config-server-9091/src/main/resources/png/1.png 
���ܿ����ղ��޸ĵ���Ϣ��˵������������ȡ������������

����������config��Ŀ�г���������־��
![�Զ���ʾ��ͼ](spring-cloud-config-server-9091/src/main/resources/png/3.jpg)

����  http://localhost:8082/config
![�Զ���ʾ��ͼ](spring-cloud-config-server-9091/src/main/resources/png/4.png)

�ɹ�˵�����������Ķ�ȡ���Գɹ�

```
@RefreshScope
@RestController
public class ConfigController {

    //Environement ȥ���ָ��������.
    @Value("${hello}")
    private String txt;

    @GetMapping("/config")
    public String config(){
        return txt;
    }

}

```


http://localhost:9091/order-service.properties