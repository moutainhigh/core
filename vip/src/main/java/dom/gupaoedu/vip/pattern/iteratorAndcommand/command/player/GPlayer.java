package dom.gupaoedu.vip.pattern.iteratorAndcommand.command.player;

/**
 * 请求接受者  负责具体实施或执行一个请求
 */
public class GPlayer {
    public void play(){
        System.out.println("正常播放");
    }

    public void speed(){
        System.out.println("拖动进度条");
    }

    public void stop(){
        System.out.println("停止播放");
    }

    public void pause(){
        System.out.println("暂停播放");
    }
}
