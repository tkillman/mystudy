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

			// ������ ���� ����
			ServerSocket serverSocket = new ServerSocket();
			InetSocketAddress serverAdd = new InetSocketAddress("192.168.20.26", 8686);
			serverSocket.bind(serverAdd);

			// Ŭ���̾�Ʈ�� ������ ��ٸ�
			Socket clientSocket = serverSocket.accept();

			// �ְ���� ��� ����
			OutputStream sender = clientSocket.getOutputStream();
			InputStream receiver = clientSocket.getInputStream();

			InputStreamReader isr=new InputStreamReader(receiver);
			BufferedReader br= new BufferedReader(isr);
			String recvMsg = br.readLine();
			
			

			// Ŭ���̾�Ʈ�� ���� ���̵� checkId�� ����
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
				
				System.out.println("ȸ���� ������");

				String sendMsg = "loginOk";

				sender.write(sendMsg.getBytes());

			} else if (c==0) {
				
				System.out.println("ȸ���� �ƴմϴ�.");

				String sendMsg = "loginNot";

				sender.write(sendMsg.getBytes());

			}
		}

		catch (Exception e) {
			// TODO: handle exception
		}

	}

}
