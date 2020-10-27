package com.github.mysql;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 石少东
 * @date 2020-10-11 18:25
 * @since 1.0
 */


public class ListSetTest {

    private final int size = 9000000;

    private final Set<Integer> set = new HashSet<>(size);

    private final List<Integer> list = new ArrayList<>(size);

    @Before
    public void before() {
        for (int i = 0; i < size; i++) {
            set.add(i);
            list.add(i);
        }
    }

    @Test
    public void start() {
        long time1 = System.currentTimeMillis();
        set.forEach(Object::hashCode);
        long time2 = System.currentTimeMillis();
        list.forEach(Object::hashCode);
        long time3 = System.currentTimeMillis();

        System.out.println((time2 - time1) + "  " + (time3 - time2));
    }

}
