package dom.gupaoedu.vip.pattern.delegateAndBridge.bridge.message;

/**
 * 紧急消息发送  修正抽象：对Abstraction抽象角色的方法进行完善和扩展
 */
public class UrgencyMessage extends AbastractMessage {
    // 传入一个实现对象，先把实现对象存到桥梁中去
    public UrgencyMessage(IMessage message) {
        super(message);
    }

    void sendMessage(String message, String toUser){
        message = "【加急】" + message;
        // 调用桥梁上具体实现角色中的方法，这样就相等于自己跟桥梁上对象中的法建立了联系
        super.sendMessage(message,toUser);
    }

    public Object watch(String messageId){
        return null;
    }
}
