package soket.test3;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	
	public static void main(String[] args) {
		
		
		try {
			
			ServerSocket serverSocket = new ServerSocket();
			InetSocketAddress serverAddr = new InetSocketAddress("127.0.0.1", 3535);
			serverSocket.bind(serverAddr);
			
			
			Socket clientSoket = serverSocket.accept();
			
			OutputStream sender = clientSoket.getOutputStream();
			InputStream receiver = clientSoket.getInputStream();
			
			
			
						
			byte[] recBuf = new byte[200];
			receiver.read(recBuf);
			String recMsg = new String(recBuf);
			
			//��ݹ��� �ڷ�� ��� �����ؼ� ������� ����
			
			Thread.sleep(2000);
			String senMsg = "i am server";		
			sender.write(senMsg.getBytes());
			
			
			
			System.out.println(recMsg);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	
	
}
