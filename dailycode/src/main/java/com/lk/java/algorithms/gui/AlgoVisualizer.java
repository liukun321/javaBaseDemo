package com.lk.java.algorithms.gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 算法可视化
 * @author liukun
 *
 */
public class AlgoVisualizer {
	
	private Circle[] circles;
	private AlgoFrame frame;
	//
	private boolean isAnimated = true;
	public AlgoVisualizer(int sceneWidth, int sceneHeight, int N) {
		//初始化数据
		circles = new Circle[N];
		int R = 50;
		for(int i=0; i< 10; i++) {
			int x = (int) (Math.random()*(sceneWidth-2*R)) + R;
			int y = (int) (Math.random()*(sceneHeight-2*R)) + R;
			
			int vx = (int) (Math.random()*11) - 5;
			int vy = (int) (Math.random()*11) - 5;
			circles[i] = new Circle(x, y, R, vx, vy);
		}
		//初始化Frame
		frame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
		frame.addKeyListener(new AlgoKeyListener());
		frame.addMouseListener(new AlgoMouseListener());
		new Thread(() -> {
			run();
		}).start();
	}
	
	private void run() {
		while(true) {
			frame.render(circles);
			AlgoVisHelper.pause(20);
			if(isAnimated) {//是否移动
				for (Circle circle : circles) {
					circle.move(0, 0, frame.getCanvasWidth(), frame.getCanvasHeight());
				}
			}
		}
	}
	
	private class AlgoMouseListener extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e) {
			e.translatePoint(0, -(frame.getBounds().height - frame.getCanvasHeight()));
			System.out.println(e.getPoint());
			for (Circle circle : circles) {
				if(circle.contain(e.getPoint())) {
					circle.isfilled = !circle.isfilled;
				}
			}
		}
	}
	
	private class AlgoKeyListener extends KeyAdapter{

		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyChar() == ' ')
				isAnimated = !isAnimated;
		}
	}
	
	public static void main(String[] args) {
		int sceneWidth = 800;
		int sceneHeight = 800;
		
		int N = 10;
		AlgoVisualizer algo = new AlgoVisualizer(sceneWidth, sceneHeight, N);
	}
}
