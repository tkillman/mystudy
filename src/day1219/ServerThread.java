package day1219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import com.mytest.pclass.Throws;

public class ServerThread extends Thread {
	Socket ClientSocket;
	TestServer ts;
	String UserIp;
	PrintWriter pw;

	public ServerThread(Socket ClientSocket, TestServer ts) {

		this.ClientSocket = ClientSocket;
		this.ts = ts;
		UserIp = ClientSocket.getInetAddress().toString();

	} // ServerThread 생성자 실행

	@Override
	public void run() {

		try {
			service();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(UserIp + "님 접속을 종료하셨습니다.");
		} finally {

			ts.deleteThread(this);

		}

	} // run 메소드 종료

	public void service() throws IOException {

		try {
			InputStream is = ClientSocket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			OutputStream os = ClientSocket.getOutputStream();
			pw = new PrintWriter(os, true);

			String str = null;

			while (true) {

				str = br.readLine();

				if (str == null) {

					System.out.println("클라이언트가 접속을 종료했습니다. 클라이언트 주소 : " + UserIp);
					break;
				}

				ts.broadCasting("[" + UserIp + "]" + "say :" + str);
				pw.println(str);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}// service 메소드 종료

	public void sendMessage(String message) {
		pw.println(message);
	}

}
