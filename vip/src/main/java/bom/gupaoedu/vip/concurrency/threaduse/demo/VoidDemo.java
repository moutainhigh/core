package bom.gupaoedu.vip.concurrency.threaduse.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 没有返回值的线程使用
 *
 * @Titile: IntelliJ IDEA
 * @Author: fengleima  2020/6/19 13:36
 */
public class VoidDemo {

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    // 异步
    public static void main(String[] args) {
        // 如果请求数很大就会创建N个线程，线程太多，就会出现线程切换非常频繁，就会占用CPU资源，性能就会下降很厉害
        // 所以这里采用线程池
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("16607691862");
            }
        });
    }
}
