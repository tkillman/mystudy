package chatting;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class User2 {
	// TODO Auto-generated method stub
	public static void main(String[] args) {
		try {
			Socket connSock = new Socket();//���� ���� ����
			InetSocketAddress connAddr = new InetSocketAddress("127.0.0.1", 1819);//������ IP�ּҿ� ��Ʈ��ȣ�� ����
			connSock.connect(connAddr);//���� �ּҷ� �����Ѵ�.
			
			
			
			
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
	

