package day1219;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class TestServer {
	Vector vector = new Vector<>();

	
	public void go() {

		try {

			ServerSocket serverSocket = new ServerSocket(5432);
			System.out.println("���� ����");

			while (true) {

				Socket ClientSocket = serverSocket.accept();
				System.out.println("Ŭ���̾�Ʈ ���������� �����ϼ̽��ϴ�. Ŭ���̾�Ʈ �ּ� :" + ClientSocket.getInetAddress());
				ServerThread st = new ServerThread(ClientSocket, this);
				addThread(st);
				st.start();

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	} // go �޼ҵ� ����

	public void addThread(ServerThread st) {
		
		vector.add(st);
	
	} //addThread �޼ҵ� ����
	
	public void deleteThread(ServerThread st){
		vector.remove(st);
	} // deleteThread �޼ҵ� ����
	
	public void broadCasting(String message){
		for(int i=0;i<vector.size();i++){
			
			ServerThread st =(ServerThread)vector.get(i);
			st.sendMessage(message);
			
			
		}
	}
	
	

	public static void main(String[] args) {

		TestServer ts = new TestServer();

		try {
			
			ts.go();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}

	} // ���� �޼ҵ� ����

}
