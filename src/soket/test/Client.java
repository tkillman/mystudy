package soket.test;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
	
	
	
	public static void main(String[] args) {
		
		
		try {
			Socket clientSocket = new Socket();
			InetSocketAddress clientWantAddress = new InetSocketAddress("127.0.0.1", 3434);
			clientSocket.connect(clientWantAddress);
			
			OutputStream sender = clientSocket.getOutputStream();
			
			
			String sendMsg = "i am a client";
			sender.write(sendMsg.getBytes());
			
			
			
			InputStream receiver =clientSocket.getInputStream();
			
			
			byte[] recMsgBuf = new byte[200];
			
			receiver.read(recMsgBuf);
			
			String recMsg = new String(recMsgBuf);
			System.out.println(recMsg);
			
			
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
	}

}
