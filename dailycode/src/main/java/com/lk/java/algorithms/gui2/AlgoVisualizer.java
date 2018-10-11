package com.lk.java.algorithms.gui2;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

public class AlgoVisualizer {

    // TODO: 创建自己的数据
	private Circle circle;
    private LinkedList<Point> points;
    private int insideCircle = 0;
    private int N;
    private AlgoFrame frame;    // 视图

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N) throws Exception{

        // 初始化数据
        // TODO: 绘制正方形和圆
    	if(sceneWidth != sceneHeight) {
    		throw new Exception("窗口不是正方形");
    	}
    	this.N = N;
    	circle = new Circle(sceneWidth/2, sceneWidth/2, sceneWidth/2);
    	points = new LinkedList<>();
        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
            // TODO: 根据情况决定是否加入键盘鼠标事件监听器
//            frame.addKeyListener(new AlgoKeyListener());
//            frame.addMouseListener(new AlgoMouseListener());
            new Thread(() -> {
                run();
            }).start();
        });
    }

    // 动画逻辑
    private void run(){
        // TODO: 编写自己的动画逻辑
    	for (int i = 0; i < N; i++) {
    		frame.render(circle, points);
    		AlgoVisHelper.pause(20);
    		if(!points.isEmpty() && i%100 == 0) {
    			int circleArea = insideCircle;
    			int squareArea = points.size();
    			double pi = 4*(double)circleArea/squareArea;
    			System.out.println(pi);
    		}
			int x = (int) (Math.random() * frame.getCanvasWidth());
			int y = (int) (Math.random() * frame.getCanvasHeight());
			Point p = new Point();
			p.setLocation(x, y);
			points.add(p);
			if(circle.contain(p))
				insideCircle ++;
		}
    	System.out.println(points.size());
    }

    // TODO: 根据情况决定是否实现键盘鼠标等交互事件监听器类
//    private class AlgoKeyListener extends KeyAdapter{ }
//    private class AlgoMouseListener extends MouseAdapter{ }

    public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 800;
        int N = 30000;
        // TODO: 根据需要设置其他参数，初始化visualizer
        try {
			AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight, N);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
