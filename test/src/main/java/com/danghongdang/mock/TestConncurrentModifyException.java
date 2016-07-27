package com.danghongdang.mock;

import java.util.*;

/**
 * Created by danghongdang on 16-7-7.
 */
public class TestConncurrentModifyException {

    public static void main(String args[]) {
        Map<Integer, Integer> a = new HashMap<Integer, Integer>();
        a.put(1, 1);
        a.put(2, 2);
        a.put(3, 3);

        for (Map.Entry<Integer, Integer> e : a.entrySet()) {
            a.remove(e.getKey());
        }

        List<Integer> b = new ArrayList<Integer>();
        b.add(1);
        b.add(2);
        b.add(3);

        for (int b1 : b) {
            b.remove(new Integer(b1));
        }
    }

}
