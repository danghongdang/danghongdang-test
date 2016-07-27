package com.danghongdang.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by danghongdang on 16-7-8.
 */
public class TestConsumer {

    public static void main(String args[]) {
        Consumer<Integer> a = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                if (integer.intValue() == 1) {
                    System.out.println("i accept a num of 1");
                }
            }
        };

        List<Consumer<Integer>> aList = new ArrayList<>();

    }

}
