package dom.gupaoedu.vip.pattern.mediatorAndInterpreter.interpreter.calculate;

// 创建非终结者表达式  减法运算表达式
public class SubInterpreter extends Interpreter {
    public SubInterpreter(IArithmeticInterpreter left, IArithmeticInterpreter right) {
        super(left, right);
    }

    public int interpret() {
        return this.left.interpret() - this.right.interpret();
    }
}