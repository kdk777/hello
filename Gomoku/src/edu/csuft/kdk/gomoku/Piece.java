package edu.csuft.kdk.gomoku;

import java.awt.Color;
import java.awt.Graphics2D;

public class Piece {
	/**
	 * x,y ����
	 */
	int x, y;

	/**
	 * ���Ӵ�С��ֱ��
	 */
	int size;

	/**
	 * ������ɫ
	 */
	boolean isBlack = true;

	/**
	 * ��������
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
	 * ����
	 * 
	 * @param g
	 */
	//�����ŵ��ĸ����У���������˼��
	public void paint(Graphics2D g) {
		//���û��ʵ���ɫ
		g.setColor(isBlack?Color.black:Color.white); //��Ԫ�����
		
		//��Բ
		g.fillOval(x-size/2, y-size/2, size, size);
	}

}
