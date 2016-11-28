package soket.multi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			// conSock 소켓 객체 생성
			Socket conSock = new Socket();
			
			//conAddr 소켓 주소 생성
			InetSocketAddress conAddr = new InetSocketAddress("127.0.0.1", 1818);
			
			//conSock 객체에 주소값을 더해줌.
			conSock.connect(conAddr);
			
			//소켓에서 나갈 값을 sender로 받음
			OutputStream sender = conSock.getOutputStream();
			
			//소켓으로 들어온 값을 reciever 로 받음
			InputStream reciever = conSock.getInputStream();

			
			
			// recvBuf 객체 생성(byte)
			byte[] recvBuf = new byte[100];
			int bytesCnt = reciever.read(recvBuf);
			
			String recvMsg = new String(recvBuf, 0, bytesCnt, "UTF-8");
			System.out.println("receive message from " + conSock.getRemoteSocketAddress() + ": " + recvMsg + "\n");

			String sendBuf = "Nice to meet you!!";
			sender.write(sendBuf.getBytes());
			System.out.println("send Message to " + conSock.getRemoteSocketAddress() + ": " + sendBuf + "\n");

			/*
			 * BufferedReader in = new BufferedReader(new
			 * InputStreamReader(socket.getInputStream())); PrintWriter out =
			 * new PrintWriter(socket.getOutputStream(),true);
			 */
		} catch (Throwable e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}