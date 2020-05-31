package gupaoedu.vip.pattern.chain.general;

public class ConcreteHandlerA extends Handler {

    public void handleRequest(String request) {
        // A请求处理请求
        if ("requestA".equals(request)) {
            System.out.println(this.getClass().getSimpleName() + "deal with request: " + request);
            return;
        }
        // 处理不了让下一个来处理
        if (this.nextHandler != null) {
            this.nextHandler.handleRequest(request);
        }
    }
}