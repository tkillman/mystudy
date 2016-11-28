package chatting;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import soket.multi.chat;

public class User1 {
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		try {
			ServerSocket servSock = new ServerSocket();//서버용 소켓 생성
			InetSocketAddress servAddr = new InetSocketAddress("127.0.0.1", 1819);//서비스할 IP주소와 포트번호를 결정
			servSock.bind(servAddr); //소켓에 위에서 결정한 주소(IP,Port)를 등록한다.
			
			
			Socket cliSock;
			
			while (true) {
				cliSock = servSock.accept();//서버소켓으로 찾아온 고객을 고객 전용 소켓으로 연결시켜줌
				Chat1 chat1 = new Chat1(cliSock);
				chat1.start();
			      	
			}
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		
	
	}

}
