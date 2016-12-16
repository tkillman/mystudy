package soket.buffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket servSock = new ServerSocket();//������ ���� ����
			InetSocketAddress servAddr = new InetSocketAddress("127.0.0.1", 1818);//������ IP�ּҿ� ��Ʈ��ȣ�� ����
			servSock.bind(servAddr); //���Ͽ� ������ ������ �ּ�(IP,Port)�� ����Ѵ�.
			
			Socket cliSock1 = servSock.accept();//������������ ã�ƿ� ���� �� ���� �������� ���������
			
			OutputStream sender = cliSock1.getOutputStream(); // ���������� ã�ƿ� ������� ���� stream
			String sendMsg = "Welcome!!"; // Ŭ���̾�Ʈ�� ���� ȯ�� �޽���
			
			sender.write(sendMsg.getBytes()); // Ŭ���̾�Ʈ�� ȯ�� �޽��� �����ϱ� byte����
			System.out.println("send data: " + sendMsg); //Ŭ���̾�Ʈ�� ���� ������ ȭ�鿡 ����ϱ�

			
			InputStream receiver = cliSock1.getInputStream();
			
			InputStreamReader isr=new InputStreamReader(receiver);     //Ŭ���̾�Ʈ�κ��� ���ŵ� �����͸� ���� ����(����)
			
			BufferedReader br= new BufferedReader(isr);
			
			String recvMsg = br.readLine();
			System.out.println(recvMsg);
		} catch (IOException e) {
			// TODO: handle exception
		}
		
	}

}
