package soket.test;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	
	
	public static void main(String[] args) {
		
		
		try {
			ServerSocket serverSocket = new ServerSocket();
			InetSocketAddress serverAddress = new InetSocketAddress("127.0.0.1", 3434);
			serverSocket.bind(serverAddress);
			
			
			Socket clientSocket = serverSocket.accept();
				
			String sendMsg = "hello";
			
			OutputStream sender=clientSocket.getOutputStream();
			sender.write(sendMsg.getBytes());
			
			
			
			
			InputStream receiver = clientSocket.getInputStream();
			byte [] receiverBuffer = new byte[200];
			
			receiver.read(receiverBuffer);
			
			String receiverMsg = new String(receiverBuffer);
			System.out.println(receiverMsg);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
