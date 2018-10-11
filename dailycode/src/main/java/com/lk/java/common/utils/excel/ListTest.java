package com.lk.java.common.utils.excel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ListTest {
	private static CountDownLatch cdl = new CountDownLatch(10);
	private static List<String> list = new ArrayList<>();
	public static void main(String[] args) throws InterruptedException {
		ListTest lt = new ListTest();
		for (int i = 0; i < 10; i++) {
			new Thread(lt.new ArrayListDemo()).start();
			cdl.countDown();
		}
		Thread.sleep(5000);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public class ArrayListDemo implements Runnable{
		@Override
		public void run() {
			try {
				cdl.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list.add(Thread.currentThread().getName());
		}
	}
}
