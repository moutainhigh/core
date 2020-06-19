package bom.gupaoedu.vip.concurrency.threaduse.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * 线程的终止3
 *
 * 线程友好终止 线程的的复位
 * 如果有人触发终止信号 就会抛出InterruptedException异常，就可以在异常里面做出响应是否要终止
 * create-date: 2020/5/16-21:47
 */
public class InterruptDemo02 implements Runnable {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) { //默认false
            try {
                TimeUnit.SECONDS.sleep(200);
                // 如果你想中断这个线程 必须 抛出InterruptedException异常
            } catch (InterruptedException e) { // 触发了线程的复位 -> false
                e.printStackTrace();
                //可以不做处理，不处理就会触发了线程的复位 -> false 一般都会处理，不处理的话响应中断发出信号就没有意义

                //这里做出处理， 继续中断 ->
                Thread.currentThread().interrupt(); //再次中断
                //抛出异常。。
            }
        }
        System.out.println("processor End");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new InterruptDemo02());
        t1.start();
        Thread.sleep(1000);
        t1.interrupt(); //有作用 true   上面报错了说明响应了，
        //Thread.interrupted() ;//主动复位  复位就是变为false
    }
}
