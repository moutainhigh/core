package dom.gupaoedu.vip.pattern.interpreter.calculate;
// 创建非终结者表达式 数字表达式
public class NumInterpreter implements IArithmeticInterpreter {
    private int value;

    public NumInterpreter(int value) {
        this.value = value;
    }


    public int interpret() {
        return this.value;
    }
}