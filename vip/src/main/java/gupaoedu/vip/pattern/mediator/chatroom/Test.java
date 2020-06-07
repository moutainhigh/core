package gupaoedu.vip.pattern.mediator.chatroom;

/**
 * 代码使用
 */
public class Test {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();// 中介者

        User tom = new User("Tom",chatRoom);
        User jerry = new User("Jerry",chatRoom);

        tom.sendMessage("Hi! I am Tom.");
        jerry.sendMessage("Hello! My name is Jerry.");
    }
}
