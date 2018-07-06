package edu.csuft.kdk.gomoku;
/**
 * 程序的起点
 * 
 * @author Mockingbird
 *
 */
public class App {
	public static void main(String[] args) {
		//游戏逻辑：模型
		GameModel model = new GameModel();
		
		//游戏窗口：界面、视图
		//窗口可以更改为 web或者"安卓"，而业务逻辑不变
		new GameFrame(model);
	}
}
