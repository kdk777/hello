package edu.csuft.kdk.gomoku;

import java.awt.Color;
import java.awt.Graphics2D;

public class Piece {
	/**
	 * x,y 坐标
	 */
	int x, y;

	/**
	 * 棋子大小：直径
	 */
	int size;

	/**
	 * 棋子颜色
	 */
	boolean isBlack = true;

	/**
	 * 创建棋子
	 * 
	 * @param x
	 * @param y
	 */
	public Piece(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		size=40;
	}

	
	/**
	 * 绘制
	 * 
	 * @param g
	 */
	//方法放到哪个类中，面向对象的思想
	public void paint(Graphics2D g) {
		//设置画笔的颜色
		g.setColor(isBlack?Color.black:Color.white); //三元运算符
		
		//画圆
		g.fillOval(x-size/2, y-size/2, size, size);
	}

}
