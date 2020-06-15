package gupaoedu.vip.pattern.bridge.message;

/**
 * 抽象实现 统一消息发送行为   维度二
 */
public interface IMessage {
    //发送消息的内容和接收人
    void send(String message,String toUser);
}
