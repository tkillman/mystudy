package soket.test2;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	
	
	public static void main(String[] args) {
		
		try {
			
			ServerSocket serSocket = new ServerSocket();
			InetSocketAddress serAdress = new InetSocketAddress("127.0.0.1", 3535); 
			serSocket.bind(serAdress);
			
			
			Socket clientSocket = serSocket.accept();
			
			OutputStream sender = clientSocket.getOutputStream();
			InputStream receiver = clientSocket.getInputStream();
			
			
			
			
			String sendMsg = "hello";
			sender.write(sendMsg.getBytes());
			
			
			
			byte[] recBuf = new byte[200]; 
			receiver.read(recBuf);
			
			String recMsg = new String(recBuf);
			
			System.out.println(recMsg);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
		
	}
	
	
}
