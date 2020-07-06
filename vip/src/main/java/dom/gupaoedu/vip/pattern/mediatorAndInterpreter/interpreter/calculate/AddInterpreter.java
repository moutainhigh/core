package dom.gupaoedu.vip.pattern.mediatorAndInterpreter.interpreter.calculate;

// 创建非终结者表达式 加法运算表达式
public class AddInterpreter extends Interpreter {

    public AddInterpreter(IArithmeticInterpreter left, IArithmeticInterpreter right) {
        super(left, right);
    }

    public int interpret() {
        return this.left.interpret() + this.right.interpret();
    }
}