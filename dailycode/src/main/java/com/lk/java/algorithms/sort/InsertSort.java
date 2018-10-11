package com.lk.java.algorithms.sort;
/**
 * 几乎有序的数组排序，插入排序比选择排序更优
 * @author liukun
 *
 */
public class InsertSort {
	
	private InsertSort() {}
	
	public static void sort(Comparable[] arr) {
		int len = arr.length;
		for (int i = 1; i < len; i++) {
			// 写法2
//			for(int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0; j--) {
//				swap(arr, i, j - 1);
//			}
			
			// 写法3
            Comparable e = arr[i];
            int j = i;
            for( ; j > 0 && arr[j-1].compareTo(e) > 0 ; j--)
                arr[j] = arr[j-1];
           //程序到这里 时j时在for循环中的的j-1
            arr[j] = e;
			
		}
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
