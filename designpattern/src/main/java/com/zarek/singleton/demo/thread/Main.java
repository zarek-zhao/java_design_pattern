package com.zarek.singleton.demo.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
public class Main {
    public static void main(String[] args) throws InterruptedException
    {


        ThreadPoolExecutor instance = ThreadPoolService.getInstance();

        instance.execute(new Task());

        Thread.sleep(1000);
        int count = 0;
        do {
            instance.execute(() -> {
                System.out.println(1234);
                System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
            });
            count++;

        } while (count != 30);
//        instance.shutdown();
    }
}


class Task implements Runnable {

    @Override
    public void run()
    {
        System.out.println(1234);
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
    }
}

class ThreadPoolService {
    private static final int DEFAULT_CORE_SIZE = 10;
    private static final int MAX_QUEUE_SIZE = 15;
    private volatile static ThreadPoolExecutor executor;

    private ThreadPoolService()
    {
    }



    /**
     * 获取单例的线程池对象
     *
     * @return ThreadPoolExecutor
     */
    public static ThreadPoolExecutor getInstance()
    {
        if (executor == null) {
            synchronized (ThreadPoolService.class) {
                if (executor == null) {
                    executor = new ThreadPoolExecutor(DEFAULT_CORE_SIZE,
                            MAX_QUEUE_SIZE,
                            Integer.MAX_VALUE,
                            TimeUnit.MILLISECONDS,
                            new LinkedBlockingDeque<>(Integer.MAX_VALUE),
                            new ThreadFactoryBuilder().setNameFormat("projectName-zdal-pool-%d").build()
                    );
                }
            }
        }
        return executor;
    }

}
