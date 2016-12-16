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
			ServerSocket servSock = new ServerSocket();//서버용 소켓 생성
			InetSocketAddress servAddr = new InetSocketAddress("127.0.0.1", 1818);//서비스할 IP주소와 포트번호를 결정
			servSock.bind(servAddr); //소켓에 위에서 결정한 주소(IP,Port)를 등록한다.
			
			Socket cliSock1 = servSock.accept();//서버소켓으로 찾아온 고객을 고객 전용 소켓으로 연결시켜줌
			
			OutputStream sender = cliSock1.getOutputStream(); // 서버소켓을 찾아온 사람에게 보낼 stream
			String sendMsg = "Welcome!!"; // 클라이언트로 보낼 환영 메시지
			
			sender.write(sendMsg.getBytes()); // 클라이언트로 환영 메시지 전송하기 byte형식
			System.out.println("send data: " + sendMsg); //클라이언트로 보낸 데이터 화면에 출력하기

			
			InputStream receiver = cliSock1.getInputStream();
			
			InputStreamReader isr=new InputStreamReader(receiver);     //클라이언트로부터 수신된 데이터를 담을 공간(변수)
			
			BufferedReader br= new BufferedReader(isr);
			
			String recvMsg = br.readLine();
			System.out.println(recvMsg);
		} catch (IOException e) {
			// TODO: handle exception
		}
		
	}

}
