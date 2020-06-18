package dom.gupaoedu.vip.pattern.observer.guava;

/**
 * Created by Tom.
 */
public class Pojo extends Parpojo {

    public Pojo(String name, String message) {
        super(name, message);
    }

    @Override
    public String toString() {
        return "Pojo{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
