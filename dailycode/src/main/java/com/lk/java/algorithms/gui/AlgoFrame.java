package com.lk.java.algorithms.gui;

import java.awt.*;

import javax.swing.*;

public class AlgoFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8284634380746416584L;
	//画布的宽度
	private int canvasWidth;
	//画布的高度
	private int canvasHeight;
	public AlgoFrame(String title, int canvasWidth, int canvasHeight) {
		super.setTitle(title);
		this.canvasHeight = canvasHeight;
		this.canvasWidth = canvasWidth;
		
		AlgoCanvas canvas = new AlgoCanvas();
		//设置画布的大小  TODO 交由AlgoCanvas类自身设置
//		canvas.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
		
		//设置窗口的内容面板
		this.setContentPane(canvas);
		//自动调整窗口的大小
		pack();
		
		this.setSize(canvasWidth, canvasHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
	public int getCanvasWidth() {
		return canvasWidth;
	}
	public int getCanvasHeight() {
		return canvasHeight;
	}
	
	private Circle[] circles;
	public void render(Circle[] cirlces) {
		this.circles = cirlces;
		repaint();//刷新画布
	}
	
	private class AlgoCanvas extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 4679949946575615111L;
		
		
		public AlgoCanvas() {
			super(true);//开启双缓存
		}
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			//画一个圆或者椭圆
//			g.drawOval(50, 50, 300, 300);
			Graphics2D g2d = (Graphics2D)g;
			
			//抗锯齿
			RenderingHints hints = new RenderingHints(
					RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.addRenderingHints(hints);
			
			//设置线条的宽度
			/*int strokeWith = 5;
			AlgoVisHelper.setStrokeWidth(g2d, strokeWith);
			//设置颜色
			AlgoVisHelper.setColor(g2d, Color.RED);
			AlgoVisHelper.strokeCircle(g2d, canvasWidth/2, canvasHeight/2, 200);
			AlgoVisHelper.setColor(g2d, Color.BLUE);
			AlgoVisHelper.fillCircle(g2d, canvasWidth/2, canvasHeight/2, 200);*/
			
			AlgoVisHelper.setStrokeWidth(g2d, 1);
			AlgoVisHelper.setColor(g2d, Color.RED);
			for (Circle circle : circles) {
				if(circle.isfilled) {
					AlgoVisHelper.fillCircle(g2d, circle.x, circle.y, circle.getR());
				}else {
					AlgoVisHelper.strokeCircle(g2d, circle.x, circle.y, circle.getR());
				}
			}
		}
		/**
		 * 重写画布的大小
		 */
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(canvasWidth, canvasHeight);
		}
	}
}
