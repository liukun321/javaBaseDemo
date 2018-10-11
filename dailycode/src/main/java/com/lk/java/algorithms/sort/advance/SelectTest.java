package com.lk.java.algorithms.sort.advance;

public class SelectTest {
	
	public static void sort(Comparable[] arr) {
		//双路查询最大和最小值
		int left = 0,right = arr.length - 1;
		while(left < right) {
			int minindex = left;
			int maxindex = right;
			
			//判断minindex的值要小于maxindex
			if(arr[minindex].compareTo(arr[maxindex]) > 0) {
				swap(arr, minindex, maxindex);
			}
			
			for(int i = left + 1; i < right; i++) {
				if(arr[i].compareTo(arr[minindex]) < 0) {
					minindex = i;
				}
				if(arr[i].compareTo(arr[maxindex]) > 0) {
					maxindex = i;
				}
			}
			swap(arr, left, minindex);
			swap(arr, right, maxindex);
			left++;
			right--;
		}
	}
	
	private static void swap(Object[] arr, int i, int j) {
		Object temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
