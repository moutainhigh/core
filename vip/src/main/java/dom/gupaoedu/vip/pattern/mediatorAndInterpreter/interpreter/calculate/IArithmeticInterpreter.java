package dom.gupaoedu.vip.pattern.mediatorAndInterpreter.interpreter.calculate;

// 定义抽象表达式角色，交由具体子类进行具体解析
public interface IArithmeticInterpreter {
    int interpret();
}