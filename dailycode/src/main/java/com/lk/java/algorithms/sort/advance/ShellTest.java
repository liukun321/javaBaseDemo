package com.lk.java.algorithms.sort.advance;

public class ShellTest {
	
	public static void sort(Comparable[] arr) {
		int length = arr.length;
		
		int h = 1;
		while (h < length / 3) {
			h = h * 3 + 1;
		}
		
		while(h > 0) {
			//步长为h的插入排序
			for(int i = 1; i < length; i++) {
				Comparable e = arr[i];
				int j = i;
				for(; j > 0 && e.compareTo(arr[j - h]) > 0; j = j - h) 
					arr[j] = arr[j - h];
				arr[j] =  e;
			}
			h /=3;
		}
		
	}
}
