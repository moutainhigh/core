package dom.gupaoedu.vip.pattern.mediatorAndInterpreter.mediator.chatroom;

/**
 * 中介者
 */
public class ChatRoom {

    public void showMsg(User user,String msg){
        System.out.println("[" + user.getName() + "] : " + msg);
    }
}
