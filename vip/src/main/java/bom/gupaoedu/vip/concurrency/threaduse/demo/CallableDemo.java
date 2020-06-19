package bom.gupaoedu.vip.concurrency.threaduse.demo;

import java.util.concurrent.*;

/**
 * 带有返回值的线程使用
 * create-date: 2020/5/16-20:32
 */
public class CallableDemo implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("come in");
        Thread.sleep(5000);
        return "SUCCESS";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        CallableDemo callableDemo = new CallableDemo();
        Future<String> future = executorService.submit(callableDemo);
        System.out.println(future.get()); //阻塞，直到拿得到返回结果
    }
}
