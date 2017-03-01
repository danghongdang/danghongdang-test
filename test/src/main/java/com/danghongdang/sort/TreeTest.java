package com.danghongdang.sort;

/**
 * Created by danghongdang on 17-2-27.
 */
public class TreeTest {

	private static int[] a = {9,1,3,2,5,7,4,8,0,6};

	private static void createTree(int[] a) {
		System.out.println("create a tree");
		for (int i : a) {
			System.out.println(i);
		}
	}
}

class Node<Integer> {
	int value;
	Node<Integer> leftChild;
	Node<Integer> rightChild;
	Node(int v) {
		this.value = v;
	}
}

