package dom.gupaoedu.vip.pattern.observer.guava;

/**
 * Created by Tom.
 */
public class Vo extends Parpojo {

    public Vo(String name, String message) {
        super(name, message);
    }

    @Override
    public String toString() {
        return "Vo{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
