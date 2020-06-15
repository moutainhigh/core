package gupaoedu.vip.pattern.bridge.message;

/**
 * 桥接模式代码使用
 */
public class Test {
    public static void main(String[] args) {
        IMessage message = new SmsMessage();
        AbastractMessage abastractMessage = new NomalMessage(message);
        // 这里也建立了联系，只不过NomalMessage没有修正，调用NomalMessage中的sendMessage方法，然后就直接调用SmsMessage中的方法
        abastractMessage.sendMessage("加班申请", "王总");

        message = new EmailMessage();
        abastractMessage = new UrgencyMessage(message); // 内部已经使用了桥接建立了联系
        // 调用UrgencyMessage中sendMessage方法，然后在方法内部里面再调用EmailMessage中的方法，方法内部处理自己的修正，这样就联系起来了
        abastractMessage.sendMessage("加班申请", "王总");
    }

}
