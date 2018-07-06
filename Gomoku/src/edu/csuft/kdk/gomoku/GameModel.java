package edu.csuft.kdk.gomoku;

public class GameModel {
	/**
	 * 15*15的棋盘, 15*15的二维数组
	 */
	int[][] data = new int[15][15];
	
	/**
	 * 显示数据模型
	 */
	public void show() {
		System.out.println("----------------------------------------");
		for (int[] row : data) {
			for (int e : row) {
				System.out.print(e+"\t");
			}
			System.out.println();
		}
	}
	

	/**
	 * 落子后，更新模型
	 * 
	 * @param piece
	 */
	public void update(Piece piece) {
		int j = piece.x/40;
		int i = piece.y/40;
		data[i][j]=piece.isBlack?1:2; //黑色赋值1，白色赋值2
		//内层遍历j
		
		show();
	}
}
