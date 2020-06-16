package dom.gupaoedu.vip.pattern.bridge.message;

/**
 * 抽象实现的 具体实现  短信消息发送
 */
public class SmsMessage implements IMessage {
    public void send(String message, String toUser) {
        System.out.println("使用短信消息发送" + message + "给" + toUser);
    }
}
