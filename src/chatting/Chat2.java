package chatting;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Chat2 extends Thread{



	private Socket connSock;

	public Chat2(Socket connSock) {
		this.connSock = connSock;
	}

	public void run() {
		try{
			
			OutputStream sender = connSock.getOutputStream();
			Scanner sc= new Scanner(System.in);
			String sendMsg = sc.nextLine(); // Ŭ���̾�Ʈ�� ���� ȯ�� �޽���
			sender.write(sendMsg.getBytes()); // Ŭ���̾�Ʈ�� ȯ�� �޽��� �����ϱ�
			System.out.println("send data: " + sendMsg); // Ŭ���̾�Ʈ�� ���� ������ ȭ�鿡 ����ϱ�

			InputStream receiver = connSock.getInputStream();
			byte[] recvBuf = new byte[100]; // Ŭ���̾�Ʈ�κ��� ���ŵ� �����͸� ���� ����(����)
			receiver.read(recvBuf); // InputStream ��ü�� byte[] �������� ��ȯ
			String recvMsg = new String(recvBuf); // byte�迭�� String���� ��ȯ�ϴ� �۾�
			System.out.println("receive data: " + recvMsg); // ������ ������ ȭ�鿡 ����ϱ�
		
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}


	



}
