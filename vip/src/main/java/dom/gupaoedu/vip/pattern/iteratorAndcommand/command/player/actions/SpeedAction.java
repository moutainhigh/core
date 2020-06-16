package dom.gupaoedu.vip.pattern.iteratorAndcommand.command.player.actions;


import dom.gupaoedu.vip.pattern.iteratorAndcommand.command.player.GPlayer;
import dom.gupaoedu.vip.pattern.iteratorAndcommand.command.player.IAction;

/**
 * Created by Tom.
 */
public class SpeedAction implements IAction {
    private GPlayer gplayer;

    public SpeedAction(GPlayer gplayer) {
        this.gplayer = gplayer;
    }

    public void execute() {
        gplayer.speed();
    }
}
