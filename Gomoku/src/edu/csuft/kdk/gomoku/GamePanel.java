package edu.csuft.kdk.gomoku;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * 面板(画布)
 * 
 * @author Mockingbird
 *
 */
public class GamePanel extends JPanel {
	
	/**
	 * 内部类：鼠标事件的监听
	 * 
	 * @author Mockingbird
	 *
	 */
	class Listener extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			
			//获得鼠标点击的位置，并放置一个棋子
			
			//这里需要控制棋子的位置：区间；自己修正
			
			Piece piece = new Piece(e.getX(), e.getY());
			piece.isBlack=pieceList.size()%2==0?true:false;
			
			pieceList.add(piece);
			
			
			//模型的更新
			model.update(piece);
			
			
			//画布的重绘
			repaint();//全部清空，再画
			//局部重绘  for 脏区域
//			repaint(x, y, width, height);
			//或者使用<双缓冲>的机制(使用两块画布)，在内存中准备好了另外的新图。如动态图形。
			//<双缓冲>可以去除<残影>
			
			
			
		}
		
	}
	

	/**
	 * 棋盘背景
	 */
	Image bg;
	
//	/**
//	 * 棋子
//	 */
//	Piece piece;
	
	
	/**
	 * 列表：存储所有棋子
	 */
	ArrayList<Piece> pieceList = new ArrayList();
	
	
	

	private GameModel model;
	

	/**
	 * GamePanel 构造方法
	 */
	public GamePanel(GameModel model) {
		this.model=model;
		try {
			bg = ImageIO.read(new File("res/map.bmp"));

		} catch (IOException e) {
			e.printStackTrace();
		}
			
		//测试
//		piece = new Piece(320,320);
		
		
		//注册(鼠标)事件监听器
		//1.适配器；2.抽象类必须被"强迫"继承
		addMouseListener(new Listener());
	}

	/**
	 * 绘制
	 */
	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);

		// Graphics2D有更多的参数可以设置
		Graphics2D g = (Graphics2D) graphics;
		// 设置渲染参数：抗锯齿
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // 键值对

		// System.out.println(getWidth());
		// System.out.println(getHeight());
		// g.drawLine(0, 0, 600, 600);

		// 绘制棋盘
		g.drawImage(bg, 0, 0, getWidth(), getWidth(), null);

		g.setColor(Color.yellow);
		g.drawLine(20, 20, 580, 20);
		g.drawLine(20, 60, 580, 60);
		g.drawLine(20, 100, 580, 100);
		g.drawLine(20, 140, 580, 140);
		g.drawLine(20, 180, 580, 180);
		g.drawLine(20, 220, 580, 220);
		g.drawLine(20, 260, 580, 260);
		g.drawLine(20, 300, 580, 300);
		g.drawLine(20, 340, 580, 340);
		g.drawLine(20, 380, 580, 380);
		g.drawLine(20, 420, 580, 420);
		g.drawLine(20, 460, 580, 460);
		g.drawLine(20, 500, 580, 500);
		g.drawLine(20, 540, 580, 540);
		g.drawLine(20, 580, 580, 580);

		g.drawLine(20, 20, 20, 580);
		g.drawLine(60, 20, 60, 580);
		g.drawLine(100, 20, 100, 580);
		g.drawLine(140, 20, 140, 580);
		g.drawLine(180, 20, 180, 580);
		g.drawLine(220, 20, 220, 580);
		g.drawLine(260, 20, 260, 580);
		g.drawLine(300, 20, 300, 580);
		g.drawLine(340, 20, 340, 580);
		g.drawLine(380, 20, 380, 580);
		g.drawLine(420, 20, 420, 580);
		g.drawLine(460, 20, 460, 580);
		g.drawLine(500, 20, 500, 580);
		g.drawLine(540, 20, 540, 580);
		g.drawLine(580, 20, 580, 580);

		// 绘制棋子
//		g.setColor(Color.black);
//		g.fillOval(0, 80, 40, 40);
//		g.fillOval(80, 80, 40, 40);
//		g.setColor(Color.white);
//		g.fillOval(80, 200, 40, 40);
//		g.fillOval(40, 80, 40, 40);
		
		//piece.paint(g);
		
		for (Piece piece:pieceList) {
			piece.paint(g);
		}
	}
}
