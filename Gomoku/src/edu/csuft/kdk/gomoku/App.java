package edu.csuft.kdk.gomoku;
/**
 * ��������
 * 
 * @author Mockingbird
 *
 */
public class App {
	public static void main(String[] args) {
		//��Ϸ�߼���ģ��
		GameModel model = new GameModel();
		
		//��Ϸ���ڣ����桢��ͼ
		//���ڿ��Ը���Ϊ web����"��׿"����ҵ���߼�����
		new GameFrame(model);
	}
}
