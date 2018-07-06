package edu.csuft.kdk.gomoku;

import javax.swing.JFrame;

/**
 * ��Ϸ����
 * 
 * @author Mockingbird
 *
 */

//Javaͼ���û���������ڲ�ͬϵͳ���ø���ϵͳ�ĵײ㣬������
public class GameFrame extends JFrame{
	/**
	 * ����
	 */
	GamePanel gamePanel;
	private GameModel model;
	
	/**
	 * ���췽����������Ϸ����
	 */
	public GameFrame(GameModel model) {
		this.model = model;
		
		//����
		setTitle("������");
		//��С
		setSize(600 + 16, 600 + 37);
		setResizable(false);
		//λ��
		setLocation(0, 0);
		setLocationRelativeTo(null);//��������������λ�ã�nullĬ�Ϸ����м�
		//�˳�����
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//����GamePanel
		gamePanel = new GamePanel(model);
		add(gamePanel);
		
		//��ʾ
		setVisible(true);
	}
	
}
