package com.danghongdang.mock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class TesMock {

    public static void main(String args[]) {
        MockArrayList<Integer> arrayList = new MockArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.remove(3);
        for (int i=0; i<arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

        LinkedList<Integer> a = new LinkedList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        MockLinkedList<Integer> linkedList = new MockLinkedList<>(a);
        linkedList.remove(3);
        linkedList.add(4);
        System.out.print(linkedList);
    }

}
