package soket.test3;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

	
	public static void main(String[] args) {
		
		try {
			
			Socket clientSocket = new Socket();
			InetSocketAddress ClientWantAdd = new InetSocketAddress("127.0.0.1", 3636);
			clientSocket.connect(ClientWantAdd);
			
			
			OutputStream sender = clientSocket.getOutputStream();
			InputStream receiver = clientSocket.getInputStream();
			
			
			String senMsg = "i am cli";
			sender.write(senMsg.getBytes());
			
			
			byte[] recBuf = new byte[200];
			receiver.read(recBuf);
			
			String recMsg = new String(recBuf);
			
			
			System.out.println(recMsg);
			
			
			
			
		} catch (Exception e) {
		
			e.printStackTrace();
			
		}
		
		
		
		
		
		
	}
	
	
}
