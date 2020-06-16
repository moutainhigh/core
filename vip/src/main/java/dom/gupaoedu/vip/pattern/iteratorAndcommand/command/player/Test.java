package dom.gupaoedu.vip.pattern.iteratorAndcommand.command.player;


import dom.gupaoedu.vip.pattern.iteratorAndcommand.command.player.actions.PlayAction;
import dom.gupaoedu.vip.pattern.iteratorAndcommand.command.player.actions.PauseAction;
import dom.gupaoedu.vip.pattern.iteratorAndcommand.command.player.actions.SpeedAction;
import dom.gupaoedu.vip.pattern.iteratorAndcommand.command.player.actions.StopAction;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {

        // 请求接受者
        GPlayer player = new GPlayer();

        // 请求者发起请求
        Controller controller = new Controller();
        controller.execute(new PlayAction(player)); // 具体命令角色去执行  正常播放
        controller.execute(new StopAction(player)); // 具体命令角色去执行 暂停播放

        System.out.println("=================命令宏====================");
        // 使用命令宏，执行多条命令
        controller.addAction(new PauseAction(player));
        controller.addAction(new PlayAction(player));
        controller.addAction(new StopAction(player));
        controller.addAction(new SpeedAction(player));
        controller.executes();
    }
}
