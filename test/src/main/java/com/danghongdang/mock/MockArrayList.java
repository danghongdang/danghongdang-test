package com.danghongdang.mock;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;

public class MockArrayList<T> implements java.io.Serializable {

    private Object[] elementData;

    private static final Object[] EMPTY_LIST = {};

    private static final Object[] INIT_LIST = {};

    private int size;

    public MockArrayList() {
        elementData = INIT_LIST;
    }

    public MockArrayList(int size) {
        if (size <= 0) {
            System.out.print(1111);
            throw new RuntimeException("init fail, make sure capacity is bigger than zero");
        }
        this.elementData = new Object[size];
    }

    public MockArrayList(Collection<? extends T> c) {
        if ((size = c.size()) <= 0) {
            throw new RuntimeException("init fail, make sure capacity is bigger than zero");
        } else {
            this.elementData = c.toArray();
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(T e) {
        grow();
        elementData[size++] = e;
        return true;
    }

    public boolean remove(Object o) {
        if (o == null) {
            return true;
        } else {
            for (int i = 0; i < elementData.length; i ++) {
                if (o.equals(elementData[i])) {
                    System.arraycopy(elementData, i + 1, elementData, i, elementData.length - i - 1);
                    elementData[--size] = null; // gc
                    return true;
                }
            }
            return false;
        }
    }

    public T get(int index) {
        return (T) elementData[index];
    }

    private void grow() {
        elementData = Arrays.copyOf(elementData, size+1);
    }

    private void writeObject(ObjectOutputStream op) throws IOException {
        op.defaultWriteObject();

        op.writeInt(size);

        for (int i = 0; i < elementData.length; i ++) {
            op.writeObject(elementData[i]);
        }
    }

}
