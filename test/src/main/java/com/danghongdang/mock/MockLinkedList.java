package com.danghongdang.mock;

import java.util.Collection;
import java.util.Iterator;

public class MockLinkedList<T> {

    transient private Node<T> first;

    transient private Node<T> last;

    private class Node<T> {
        Node<T> prev;
        T item;
        Node<T> next;

        Node(Node<T> prev, T item, Node<T> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    public MockLinkedList() {

    }

    public MockLinkedList(Collection<T> c) {
        Iterator<T> i = c.iterator();
        Node<T> node = new Node<>(null, i.next(), null);
        first = node;
        while (i.hasNext()) {
            node.next = new Node<>(node, i.next(), null);
            node = node.next;
        }
        last = node;
    }

    public boolean add(T t) {
        if (t == null) {
            return false;
        }

        Node<T> node = new Node<>(last, t, null);
        last = node;
        return true;
    }

    public boolean remove(T t) {
        if (t == null) {
            return false;
        }

        Node<T> node = first;
        if (node.item.equals(t)) {
            first = first.next;
            first.prev = null;
            return true;
        }

        while (node.next != null) {
            node = node.next;
            if (node.item.equals(t)) {
                node.prev.next = node.next;
                node = node.next;
            }
        }

        return true;
    }

}
