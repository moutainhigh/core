package dom.gupaoedu.vip.pattern.iteratorAndcommand.command.player.actions;


import dom.gupaoedu.vip.pattern.iteratorAndcommand.command.player.GPlayer;
import dom.gupaoedu.vip.pattern.iteratorAndcommand.command.player.IAction;

/**
 * 具体命令角色 拖动进度条   内部维护一个接受者，在execute()方法中调用接受者的相关方法
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
