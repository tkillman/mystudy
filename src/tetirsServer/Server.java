package tetirsServer;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Server {
	String checkId;
	
	public static void main(String[] args) {

		try {

			Connection connection;
			PreparedStatement pstmt;

			// 서버용 소켓 생성
			ServerSocket serverSocket = new ServerSocket();
			InetSocketAddress serverAdd = new InetSocketAddress("192.168.20.26", 8686);
			serverSocket.bind(serverAdd);

			// 클라이언트의 접속을 기다림
			Socket clientSocket = serverSocket.accept();

			// 주고받을 통로 설정
			OutputStream sender = clientSocket.getOutputStream();
			InputStream receiver = clientSocket.getInputStream();

			InputStreamReader isr=new InputStreamReader(receiver);
			BufferedReader br= new BufferedReader(isr);
			String recvMsg = br.readLine();
			
			

			// 클라이언트가 보낸 아이디를 checkId에 받음
			String checkId = new String(recvMsg);
			System.out.println(checkId);

			
			
			
			
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String uid = "hr";
			String upw = "hr";

			connection = DriverManager.getConnection(url, uid, upw);

			String sql ="select * from tbl_members where id = ? ";
			
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, checkId);

			int c = pstmt.executeUpdate();
			
			System.out.println(c);
			
			if (c == 1) {
				
				System.out.println("회원이 접속함");

				String sendMsg = "loginOk";

				sender.write(sendMsg.getBytes());

			} else if (c==0) {
				
				System.out.println("회원이 아닙니다.");

				String sendMsg = "loginNot";

				sender.write(sendMsg.getBytes());

			}
		}

		catch (Exception e) {
			// TODO: handle exception
		}

	}

}
