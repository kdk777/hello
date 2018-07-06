package edu.csuft.kdk.gomoku;

public class GameModel {
	/**
	 * 15*15������, 15*15�Ķ�ά����
	 */
	int[][] data = new int[15][15];
	
	/**
	 * ��ʾ����ģ��
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
	 * ���Ӻ󣬸���ģ��
	 * 
	 * @param piece
	 */
	public void update(Piece piece) {
		int j = piece.x/40;
		int i = piece.y/40;
		data[i][j]=piece.isBlack?1:2; //��ɫ��ֵ1����ɫ��ֵ2
		//�ڲ����j
		
		show();
	}
}
