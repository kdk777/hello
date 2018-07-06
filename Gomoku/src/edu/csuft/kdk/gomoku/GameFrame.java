package edu.csuft.kdk.gomoku;

import javax.swing.JFrame;

/**
 * 游戏窗口
 * 
 * @author Mockingbird
 *
 */

//Java图形用户界面可以在不同系统调用各自系统的底层，轻量级
public class GameFrame extends JFrame{
	/**
	 * 画板
	 */
	GamePanel gamePanel;
	private GameModel model;
	
	/**
	 * 构造方法：定义游戏窗口
	 */
	public GameFrame(GameModel model) {
		this.model = model;
		
		//标题
		setTitle("五子棋");
		//大小
		setSize(600 + 16, 600 + 37);
		setResizable(false);
		//位置
		setLocation(0, 0);
		setLocationRelativeTo(null);//相对于其他组件的位置；null默认放在中间
		//退出程序
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//创建GamePanel
		gamePanel = new GamePanel(model);
		add(gamePanel);
		
		//显示
		setVisible(true);
	}
	
}
