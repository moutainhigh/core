package bom.gupaoedu.vip.concurrency.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock代码使用
 */
public class AtomicDemo {

    private static int count = 0;

    //重入锁(如何实现的？) 允许重入(在获得锁还没释放锁的情况下，去访问一个方法，可以同时获得同一把锁)
    static Lock lock = new ReentrantLock(true);

    // 互斥锁:避免多线程同时访问的的时候，线程并发问题
    public static void inc() {
        lock.lock(); //获得锁(互斥锁) ThreadA 获得了锁
        try {
            //退出线程 中断的过程往下传递.  true
            // sleep/ join/ wait
            //while()
            // ...
            Thread.sleep(1);
            count++;
            decr();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();//释放锁 ThreadA释放锁  state=1-1=0
        }
    }

    public static void decr() {
        lock.lock(); //state=2   //ThreadA再次来抢占锁 : 不需要再次抢占锁，而是只增加重入的次数
        // 如果不允许重入的话，会发生死锁
        try {
            count--;
        } finally {
            lock.unlock(); //state=1
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> AtomicDemo.inc());
        t1.start();


        Thread t2 = new Thread(() -> AtomicDemo.inc());
        t2.start();
        t2.interrupt(); //中断线程。

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> AtomicDemo.inc()).start();
        }
        Thread.sleep(4000);
        System.out.println("result:" + count);
    }
}
