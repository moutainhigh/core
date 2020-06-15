package gupaoedu.vip.pattern.bridge.message;

/**
 * 抽象角色：该类持有一个对实现角色的引用,抽象角色中的方法需要实现角色来实现。
 * 抽象角色一般为抽象类(构造函数规定子类要传入一个实现对象);
 * 维度一    用组合的方式建立连接
 */
public abstract class AbastractMessage {
    // 持有一个对实现角色的引用
    private IMessage message;

    // 传入一个实现对象
    public AbastractMessage(IMessage message) {
        this.message = message;
    }

    void sendMessage(String message, String toUser) {
        // 调用具体实现角色中的方法
        this.message.send(message, toUser);
    }
}
