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
			ServerSocket servSock = new ServerSocket();//������ ���� ����
			InetSocketAddress servAddr = new InetSocketAddress("127.0.0.1", 1819);//������ IP�ּҿ� ��Ʈ��ȣ�� ����
			servSock.bind(servAddr); //���Ͽ� ������ ������ �ּ�(IP,Port)�� ����Ѵ�.
			
			
			Socket cliSock;
			
			while (true) {
				cliSock = servSock.accept();//������������ ã�ƿ� ���� �� ���� �������� ���������
				Chat1 chat1 = new Chat1(cliSock);
				chat1.start();
			      	
			}
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		
	
	}

}
