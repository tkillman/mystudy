package day1219;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class TestServer {
	Vector vector = new Vector<>();

	
	public void go() {

		try {

			ServerSocket serverSocket = new ServerSocket(5432);
			System.out.println("서버 실행");

			while (true) {

				Socket ClientSocket = serverSocket.accept();
				System.out.println("클라이언트 누구누구가 접속하셨습니다. 클라이언트 주소 :" + ClientSocket.getInetAddress());
				ServerThread st = new ServerThread(ClientSocket, this);
				addThread(st);
				st.start();

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	} // go 메소드 종료

	public void addThread(ServerThread st) {
		
		vector.add(st);
	
	} //addThread 메소드 종료
	
	public void deleteThread(ServerThread st){
		vector.remove(st);
	} // deleteThread 메소드 종료
	
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

	} // 메인 메소드 종료

}
