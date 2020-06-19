package bom.gupaoedu.vip.concurrency.threaduse.interrupt;

/**
 * 线程的终止4
 * 不用jvm的中断
 * create-date: 2020/5/16-22:12
 */
public class InterruptDemo03 implements Runnable {
    static volatile boolean interrupt = false;

    @Override
    public void run() {
        while (!interrupt) {
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.class.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ;
    }

    public static void main(String[] args) {
        interrupt = true;
    }
}
