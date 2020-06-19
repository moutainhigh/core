package bom.gupaoedu.vip.concurrency.threaduse.interrupt;

/**
 * 线程的终止1
 *
 * create-date: 2020/5/16-20:28
 */
public class StopDemo extends Thread {
    @Override
    public void run() {
        //线程会执行的指令
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Come in");
    }

    public static void main(String[] args) {
        StopDemo testDemo = new StopDemo();
        testDemo.start();
        testDemo.stop(); //不建议 强制终止这个线程。 不完整，有可能线程运行一半的时候程序终止了

        //发送终止通知
    }
}
