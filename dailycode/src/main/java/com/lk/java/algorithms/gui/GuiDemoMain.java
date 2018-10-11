package com.lk.java.algorithms.gui;

import java.awt.*;

import javax.swing.*;

public class GuiDemoMain {
	public static void main(String[] args) {
		//将窗口的创建放在一个时间分发的线程中
		EventQueue.invokeLater(() -> {
//			JFrame frame = new JFrame("Welcome");
//			//设置窗口的大小
//			frame.setSize(500, 500);
//			//点击x时关闭窗口，而不是后台运行
//			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			//设置窗口的大小不可修改
//			frame.setResizable(false);
//			//设置窗口可见
//			frame.setVisible(true);
			int sceneWidth = 800;
			int sceneHeight = 800;
			
			int N = 10;
			AlgoVisualizer algo = new AlgoVisualizer(sceneWidth, sceneHeight, N);
			/*Circle[] circles = new Circle[N];
			int R = 50;
			for(int i=0; i< 10; i++) {
				int x = (int) (Math.random()*(sceneWidth-2*R)) + R;
				int y = (int) (Math.random()*(sceneHeight-2*R)) + R;
				
				int vx = (int) (Math.random()*11) - 5;
				int vy = (int) (Math.random()*11) - 5;
				circles[i] = new Circle(x, y, R, vx, vy);
			}
			AlgoFrame frame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
			new Thread(() -> {
				while(true) {
					frame.render(circles);
					AlgoVisHelper.pause(20);
					for (Circle circle : circles) {
						circle.move(0, 0, sceneWidth, sceneHeight);
					}
				}
			}).start();*/
		});
	}
}
