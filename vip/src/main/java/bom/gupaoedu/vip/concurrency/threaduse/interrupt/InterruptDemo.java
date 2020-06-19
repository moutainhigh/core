package bom.gupaoedu.vip.concurrency.threaduse.interrupt;

/**
 * 线程的终止2
 *
 * 使用   Thread.currentThread().isInterrupted()  来让线程友好中断  默认为false
 * thread.interrupt() 来告诉发出终止信号
 *
 * while()   Thread.sleep()  Thread.json()  wait()  都可以去终止线程
 * create-date: 2020/5/16-21:41
 */
public class InterruptDemo implements Runnable {

    private int i = 1;

    @Override
    public void run() {
//        Thread.currentThread().isInterrupted()=false; 默认为false
        // while(true) 这样线程无法结束 当无法结束的时候，用友好中断 如下：
//      表示一个中断的标记  interrupted=fasle  这样就可以去终止这个线程 thread.interrupt() 来告诉要终止
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Test:" + i++);
        }
        //
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new InterruptDemo());
        thread.start();
        thread.interrupt(); //设置 interrupted=true;  设置完就会结束 告诉线程友好结束
        System.out.println("结束");
    }
}
