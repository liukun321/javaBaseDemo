package com.lk.java.algorithms.sort;

import com.lk.java.test.SortTestHelper;

/**
 * 冒泡排序
 * @author liukun
 *
 */
public class BubbleSort {
	// 我们的算法类不允许产生任何实例
	private BubbleSort() {
	}
	public static void sort(Comparable[] arr) {
		int n = arr.length;
		boolean swapped = false;

		do {
			swapped = false;
			for (int i = 1; i < n; i++)
				if (arr[i - 1].compareTo(arr[i]) > 0) {
					swap(arr, i - 1, i);
					swapped = true;
				}
			// 优化, 每一趟Bubble Sort都将最大的元素放在了最后的位置
			// 所以下一次排序, 最后的元素可以不再考虑
			n--;
		} while (swapped);
		
		/*int temp = n;
		for(int i = 0; i < n; n++) {
			for(int j = 1; j < temp; j++) 
				if (arr[j - 1].compareTo(arr[j]) > 0) {
					swap(arr, j - 1, j);
				}
			temp --;
		}*/
		
	}
	private static void swap(Object[] arr, int i, int j) {
		Object t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	public static void main(String[] args) {
		//超过5w的数据用冒泡法排序将非常慢
		Integer[] arr = SortTestHelper.generateRandomArray(10000, 1, 1000000);
//		SortTestHelper.testSort("com.lk.java.algorithms.sort.BubbleSort", arr);
		SortTestHelper.testSort("com.lk.java.algorithms.sort.BubbleSort2", arr);
//		System.out.println(arr.length);
//		SortTestHelper.printArray(arr);
//		BubbleSort.sort(arr);
//		SortTestHelper.printArray(arr);
	}
}
