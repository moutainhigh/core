package bom.gupaoedu.vip.concurrency.reentrantlock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 */
public class ReentrantReadWriteLockDemo {

    static Map<String,Object> cacheMap=new HashMap<>();
    static ReentrantReadWriteLock rwl=new ReentrantReadWriteLock();
    static Lock read=rwl.readLock(); // 读锁
    static Lock write=rwl.writeLock(); //写锁

    public static Object get(String key){
        read.lock(); //读锁 ThreadA 阻塞
        try{
            return cacheMap.get(key);
        }finally {
            read.unlock(); //释放读锁
        }
    }
    public static Object write(String key,Object value){
        write.lock(); //Other Thread 获得了写锁，上面的读锁要阻塞
        try{
            return cacheMap.put(key,value);
        }finally {
            write.unlock();
        }
    }

}
