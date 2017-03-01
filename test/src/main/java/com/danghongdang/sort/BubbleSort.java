package com.danghongdang.sort;

/**
 * 冒泡排序：没啥说的
 * Created by danghongdang on 17-2-18.
 */
public class BubbleSort {

	private static void bubbleSort(int[] a) {
		for (int j=0; j<a.length; j++) {
			for (int i=0; i<a.length-1; i++) {
				int tmp;
				if (a[i] > a[i+1]) {
					tmp = a[i];
					a[i] = a[i+1];
					a[i+1] = tmp;
				}
			}
		}
	}

	public static void main(String args[]) {
		int[] a = {8,6,5,2,4,3,1,9,7};
		bubbleSort(a);
		for (int t : a) {
			System.out.println(t);
		}
	}
}
