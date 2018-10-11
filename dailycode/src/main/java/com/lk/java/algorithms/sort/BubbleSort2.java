package com.lk.java.algorithms.sort;

import com.lk.java.test.SortTestHelper;

/**
 * 冒泡排序优化
 * @author liukun
 *
 */
public class BubbleSort2 {
	// 我们的算法类不允许产生任何实例
	private BubbleSort2() {
	}
	public static void sort(Comparable[] arr) {
		int n = arr.length;
		int newn; // 使用newn进行优化

		do {
			newn = 0;
			for (int i = 1; i < n; i++)
				if (arr[i - 1].compareTo(arr[i]) > 0) {
					swap(arr, i - 1, i);
					// 记录最后一次的交换位置,在此之后的元素在下一轮扫描中均不考虑
					newn = i;
				}
			n = newn;
		} while (newn > 0);
		
		/*for(int i = 0; i < n; n++) {
			for(int j = n - 1; j > 0; j--) {
//				System.out.println(j);
				if (arr[j - 1].compareTo(arr[j]) > 0) {
					swap(arr, j - 1, j);
//					temp = j;
				}
			}
		}*/
	}

	private static void swap(Object[] arr, int i, int j) {
		Object t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	
	public static void main(String[] args) {
		Integer[] arr = SortTestHelper.generateRandomArray(700, 1, 10000);
		System.out.println(arr.length);
		SortTestHelper.printArray(arr);
		BubbleSort2.sort(arr);
		SortTestHelper.printArray(arr);
	}
}
