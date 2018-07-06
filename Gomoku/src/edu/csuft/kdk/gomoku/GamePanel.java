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
 * ���(����)
 * 
 * @author Mockingbird
 *
 */
public class GamePanel extends JPanel {
	
	/**
	 * �ڲ��ࣺ����¼��ļ���
	 * 
	 * @author Mockingbird
	 *
	 */
	class Listener extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			
			//����������λ�ã�������һ������
			
			//������Ҫ�������ӵ�λ�ã����䣻�Լ�����
			
			Piece piece = new Piece(e.getX(), e.getY());
			piece.isBlack=pieceList.size()%2==0?true:false;
			
			pieceList.add(piece);
			
			
			//ģ�͵ĸ���
			model.update(piece);
			
			
			//�������ػ�
			repaint();//ȫ����գ��ٻ�
			//�ֲ��ػ�  for ������
//			repaint(x, y, width, height);
			//����ʹ��<˫����>�Ļ���(ʹ�����黭��)�����ڴ���׼�������������ͼ���綯̬ͼ�Ρ�
			//<˫����>����ȥ��<��Ӱ>
			
			
			
		}
		
	}
	

	/**
	 * ���̱���
	 */
	Image bg;
	
//	/**
//	 * ����
//	 */
//	Piece piece;
	
	
	/**
	 * �б��洢��������
	 */
	ArrayList<Piece> pieceList = new ArrayList();
	
	
	

	private GameModel model;
	

	/**
	 * GamePanel ���췽��
	 */
	public GamePanel(GameModel model) {
		this.model=model;
		try {
			bg = ImageIO.read(new File("res/map.bmp"));

		} catch (IOException e) {
			e.printStackTrace();
		}
			
		//����
//		piece = new Piece(320,320);
		
		
		//ע��(���)�¼�������
		//1.��������2.��������뱻"ǿ��"�̳�
		addMouseListener(new Listener());
	}

	/**
	 * ����
	 */
	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);

		// Graphics2D�и���Ĳ�����������
		Graphics2D g = (Graphics2D) graphics;
		// ������Ⱦ�����������
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // ��ֵ��

		// System.out.println(getWidth());
		// System.out.println(getHeight());
		// g.drawLine(0, 0, 600, 600);

		// ��������
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

		// ��������
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
