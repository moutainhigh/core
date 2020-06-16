package dom.gupaoedu.vip.pattern.interpreter.calculate;

/**
 * 创建非终结者表达式  乘法运算表达式
 */
public class MultiInterpreter extends Interpreter {

    public MultiInterpreter(IArithmeticInterpreter left, IArithmeticInterpreter right){
        super(left,right);
    }

    public int interpret() {
        return this.left.interpret() * this.right.interpret();
    }

}
