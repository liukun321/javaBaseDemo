package com.lk.java.algorithms.gui1;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class AlgoVisualizer {

    // TODO: 创建自己的数据
    private int[] money;        // 数据
    private AlgoFrame frame;    // 视图

    public AlgoVisualizer(int sceneWidth, int sceneHeight){

        // 初始化数据
    	money = new int[100];
    	for (int i = 0; i < money.length; i++) {
    		money[i] = 100;
		}
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

        while(true) {
        	Arrays.sort(money);//排序后进行再进行渲染
        	frame.render(money);
        	AlgoVisHelper.pause(10);
        	for(int k = 0; k < 50; k++) {//加快变化速度
        		for (int i = 0; i < money.length; i++) {
//        			if(money[i] > 0) {
        				//从100个人中随机选择一个人 接收第i个人的一元钱
        				int j = (int) (Math.random()*money.length);
        				money[i] -= 1;
        				money[j] += 1;
//        			}
        	}
				
			}
        }
    }

    // TODO: 根据情况决定是否实现键盘鼠标等交互事件监听器类
//    private class AlgoKeyListener extends KeyAdapter{ }
//    private class AlgoMouseListener extends MouseAdapter{ }

    public static void main(String[] args) {

        int sceneWidth = 600;
        int sceneHeight = 600;

        // TODO: 根据需要设置其他参数，初始化visualizer
        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight);
    }
}
