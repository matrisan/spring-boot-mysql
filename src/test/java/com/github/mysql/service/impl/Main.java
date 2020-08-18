package com.github.mysql.service.impl;

import java.util.HashSet;
import java.util.Set;

public class Main {

    private static int count = 0;
    private static final Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        PrintNum pNum = new PrintNum();
        pNum.printNumbers();
        System.out.println(count);
    }

    static class PrintNum {
        public void printNumbers() {
            int result;
            for (int i = 203; i <= 987; i++) {
                for (int j = 987; j >= 203; j--) {
                    result = i + j;
                    if (result > 1000) {
                        if (isTrue(result, i, j)) {
                            int a = Math.min(i, j);
                            int b = Math.max(i, j);
                            String temp = a + "" + b;
                            if (!set.contains(temp)) {
                                count = count + 1;
                                set.add(temp);
                            }
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        public boolean isTrue(int result, int i, int j) {
            String[] strings = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
            String s = result + "" + i + "" + j;
            for (String str : strings) {
                if (!s.contains(str)) {
                    return false;
                }
            }
            return true;
        }
    }
}

