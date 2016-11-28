package chatting;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class User2 {
	// TODO Auto-generated method stub
	public static void main(String[] args) {
		try {
			Socket connSock = new Socket();//고객용 소켓 생성
			InetSocketAddress connAddr = new InetSocketAddress("127.0.0.1", 1819);//서비스할 IP주소와 포트번호를 결정
			connSock.connect(connAddr);//위의 주소로 연결한다.
			
			
			
			
			while (true) {
				connSock.connect(connAddr);
				Chat2 chat2= new Chat2(connSock);
				chat2.start();
				
			      	
			}
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		

	}

	}
	

