package gupaoedu.vip.pattern.iteratorAndcommand.command.player.actions;


import gupaoedu.vip.pattern.iteratorAndcommand.command.player.GPlayer;
import gupaoedu.vip.pattern.iteratorAndcommand.command.player.IAction;

/**
 * Created by Tom.
 */
public class StopAction implements IAction {
    private GPlayer gplayer;

    public StopAction(GPlayer gplayer) {
        this.gplayer = gplayer;
    }

    public void execute() {
        gplayer.stop();
    }
}
