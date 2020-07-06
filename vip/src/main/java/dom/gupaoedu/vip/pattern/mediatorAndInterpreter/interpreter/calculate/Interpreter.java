package dom.gupaoedu.vip.pattern.mediatorAndInterpreter.interpreter.calculate;

// 创建终结者表达式角色
public abstract class Interpreter implements IArithmeticInterpreter {

    protected IArithmeticInterpreter left;
    protected IArithmeticInterpreter right;

    public Interpreter(IArithmeticInterpreter left, IArithmeticInterpreter right) {
        this.left = left;
        this.right = right;
    }
}