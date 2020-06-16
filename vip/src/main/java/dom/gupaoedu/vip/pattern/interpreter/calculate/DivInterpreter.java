package dom.gupaoedu.vip.pattern.interpreter.calculate;

/**
 * 创建非终结者表达式 除法运算表达式
 */
public class DivInterpreter extends Interpreter {

    public DivInterpreter(IArithmeticInterpreter left, IArithmeticInterpreter right){
        super(left,right);
    }

    public int interpret() {
        return this.left.interpret() / this.right.interpret();
    }

}
