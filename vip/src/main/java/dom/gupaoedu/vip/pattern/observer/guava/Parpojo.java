package dom.gupaoedu.vip.pattern.observer.guava;

import lombok.Data;

/**
 * @Description:
 * @Titile: IntelliJ IDEA
 * @Author: fengleima  2020/6/18 17:36
 * @Version:1.0
 */
@Data
public class Parpojo {

    protected String name;
    protected String message;

    public Parpojo(String name, String message) {
        this.name = name;
        this.message = message;
    }
}
