package soket.multi;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class chat extends Thread {

	private Socket connSock;

	public chat(Socket connSock) {
		this.connSock = connSock;
	}

	public void run() {
		try{
			OutputStream sender = connSock.getOutputStream();
			String sendMsg = "Welcome!!"; // 클라이언트로 보낼 환영 메시지
			sender.write(sendMsg.getBytes()); // 클라이언트로 환영 메시지 전송하기
			System.out.println("send data: " + sendMsg); // 클라이언트로 보낸 데이터 화면에 출력하기

			InputStream receiver = connSock.getInputStream();
			byte[] recvBuf = new byte[100]; // 클라이언트로부터 수신된 데이터를 담을 공간(변수)
			receiver.read(recvBuf); // InputStream 객체를 byte[] 형식으로 변환
			String recvMsg = new String(recvBuf); // byte배열을 String으로 변환하는 작업
			System.out.println("receive data: " + recvMsg); // 수신한 데이터 화면에 출력하기
		
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

}
