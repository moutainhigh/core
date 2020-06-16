package dom.gupaoedu.vip.pattern.iteratorAndcommand.command.player;

import java.util.ArrayList;
import java.util.List;

/**
 * 请求者：
 */
public class Controller {
    // 需要支持命令宏 保存所有命令
    private List<IAction> actions = new ArrayList<IAction>();

    public void addAction(IAction action){
        actions.add(action);
    }

    // 执行单个命令
    public void execute(IAction action){
        action.execute();
    }

    // 执行所有命令
    public void executes(){
        for (IAction action:actions) {
            action.execute();
        }
        actions.clear();
    }
}
