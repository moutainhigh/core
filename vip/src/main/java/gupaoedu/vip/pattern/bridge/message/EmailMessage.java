package gupaoedu.vip.pattern.bridge.message;

/**
 * 抽象实现的 具体实现  邮件发送
 */
public class EmailMessage implements IMessage {
    public void send(String message, String toUser) {
        System.out.println("使用邮件消息发送" + message + "给" + toUser);
    }
}
