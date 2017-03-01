package com.danghongdang.sort;

/**
 * 快速排序：
 * 1.两端分别开始遍历，跟第一个比较，左边查找到比第一个小的a，右边查找到比第一个大的b，然后a,b交换位置，直到左边的坐标和右边的坐标相同。
 * 2.分别遍历两个分开的数组
 * 3.重复1，2
 * Created by danghongdang on 17-2-18.
 */
public class FastSort {

	static int partition(int []array,int lo,int hi){
		//  固定的切分方式
		int key = array[lo];
		while (lo < hi) {
			while(array[hi] >= key
					&& hi > lo){ // 从后半部分向前扫描
				hi--;
			}
			array[lo] = array[hi];
			while(array[lo] <= key
					&& hi > lo){ // 从前半部分向后扫描
				lo++;
			}
			array[hi] = array[lo];
		}
		array[hi] = key;
		return hi;
	}

	static void sort(int[] array,int lo ,int hi){
		if(lo >= hi){
			return ;
		}
		int index = partition(array, lo, hi);
		sort(array, lo, index-1);
		sort(array, index+1, hi);
	}

	public static void main(String args[]) {
		int[] a = {9,1,3,2,5,7,4,8,0,6};
		sort(a, 0, 9);
		for (int t : a) {
			System.out.println(t);
		}
	}
}
