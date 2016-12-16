package soket.test2;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
	
	
	
	public static void main(String[] args) {
		try {
			Socket clientSocket = new Socket();
			InetSocketAddress clientWantAdd = new InetSocketAddress("127.0.0.1", 3535);
			
			clientSocket.connect(clientWantAdd);
			
			OutputStream sender = clientSocket.getOutputStream();
			InputStream receiver = clientSocket.getInputStream();
			
			
			String senMsg = "i am dong gyu";
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
