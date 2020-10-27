package com.github.mysql;

/**
 * @author 石少东
 * @date 2020-09-15 21:19
 * @since 1.0
 */


public class Test01 {

    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        long sum = 0L;
//        Long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println((System.currentTimeMillis() - before)/1000);
    }

}
