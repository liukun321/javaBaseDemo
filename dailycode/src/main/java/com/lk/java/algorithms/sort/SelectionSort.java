package com.lk.java.algorithms.sort;

import com.lk.java.test.SortTestHelper;

/**
 * 选择排序算法
 * 
 * @author liukun
 *
 */
public class SelectionSort {

	private SelectionSort() {
	}

	public static void sort(Integer[] arr) {
		int len = arr.length;
		// 从第i个元素到len个元素中找出最小值的坐标
		for (int i = 0; i < len; i++) {
			int minindex = i;
			for (int j = i + 1; j < len; j++) {
				if (arr[minindex] > arr[j])
					minindex = j;
			}
			// 将第i个元素与最小元素进行位置互换
			swap(arr, i, minindex);
		}
	}

	private static void swap(Integer[] arr, int i, int minindex) {
		int temp = arr[i];
		arr[i] = arr[minindex];
		arr[minindex] = temp;
	}

	public static void main(String[] args) {
		Integer[] arr = SortTestHelper.generateRandomArray(1000, 1, 100000);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + " ");
		}
		System.out.println("-------------------------");
		long start = System.currentTimeMillis();
		if (null != arr) {
			sort(arr);
			// 打印排序后的数据
		}
		System.out.println();
		System.out.println(System.currentTimeMillis() - start);
		System.out.println("-------------------------");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + " ");
		}
	}
}
