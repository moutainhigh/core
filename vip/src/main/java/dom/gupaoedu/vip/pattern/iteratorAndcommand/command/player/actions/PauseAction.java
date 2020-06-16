package dom.gupaoedu.vip.pattern.iteratorAndcommand.command.player.actions;


import dom.gupaoedu.vip.pattern.iteratorAndcommand.command.player.GPlayer;
import dom.gupaoedu.vip.pattern.iteratorAndcommand.command.player.IAction;

/**
 * 具体命令角色 暂停播放  内部维护一个接受者，在execute()方法中调用接受者的相关方法
 */
public class PauseAction implements IAction {
    // 直接创建接收者，不暴露给客户端
    private GPlayer gplayer;

    public PauseAction(GPlayer gplayer) {
        this.gplayer = gplayer;
    }

    public void execute() {
        gplayer.pause();
    }
}
