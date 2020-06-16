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

        GPlayer player = new GPlayer();
        Controller controller = new Controller();
        controller.execute(new PlayAction(player));

        controller.addAction(new PauseAction(player));
        controller.addAction(new PlayAction(player));
        controller.addAction(new StopAction(player));
        controller.addAction(new SpeedAction(player));
        controller.executes();
    }
}
