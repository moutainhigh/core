package bom.gupaoedu.vip.concurrency.threaduse.demo;

import java.util.concurrent.TimeUnit;

/**
 * 线程的使用 及 锁阻塞的状态: TIMED_WAITING(带超时时间)、WAITING(不带超时时间)、BLOCKED 锁阻塞的情况下Synchronizeed才会出现
 * jps 、 jstack  <pid>
 * create-date: 2020/5/16-21:11
 */
public class Demo {

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                try {
                    System.out.println(Thread.currentThread().getName() + " sleep");
                    TimeUnit.SECONDS.sleep(7);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "STATUS_01").start();  //阻塞状态   TIMED_WAITING(带超时时间)

        new Thread(() -> {
            while (true) {
                synchronized (Demo.class) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " wait ");
                        Demo.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "STATUS_02").start(); //阻塞状态    WAITING(不带超时时间)


        // 两个线程去抢占锁，其中一个线程抢到锁之后会不断的持有，不会释放
        new Thread(new BlockedDemo(), "BLOCKED-DEMO-01").start();   // BLOCKED  锁阻塞的情况下Synchronizeed才会出现
        new Thread(new BlockedDemo(), "BLOCKED-DEMO-02").start();

    }

    static class BlockedDemo extends Thread {
        @Override
        public void run() {
            synchronized (BlockedDemo.class) {// 类锁
                while (true) {
                    try {
                        System.out.println(Thread.currentThread().getName());
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
