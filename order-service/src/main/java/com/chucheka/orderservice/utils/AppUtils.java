package com.chucheka.orderservice.utils;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

public class AppUtils {

    public static String generateUniqueCode() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 6).toUpperCase();
    }

    private static void randomlyRunLong() {
        Random rand = new Random();
        int randomNum = rand.nextInt(3) + 1;
        if (randomNum == 3) sleep();
    }

    private static void sleep() {
        try {
            Thread.sleep(5000);
            throw new TimeoutException();
        } catch (InterruptedException | TimeoutException e) {
            e.getMessage();
//            log.error(">>>>>>>>>>>>>>>>>>>>>{}",e.getMessage());
        }
    }
}
