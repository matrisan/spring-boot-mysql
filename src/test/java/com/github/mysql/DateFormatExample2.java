package com.github.mysql;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author 石少东
 * @date 2020-08-24 22:50
 * @since 1.0
 */


public class DateFormatExample2 {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

    private static int clientTotal = 5000;

    private static int threadTotal = 200;

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(threadTotal);
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                semaphore.release();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
    }

    private static void update() throws ParseException {
        simpleDateFormat.parse("20200101");
    }

}
