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

	} // ServerThread ������ ����

	@Override
	public void run() {

		try {
			service();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(UserIp + "�� ������ �����ϼ̽��ϴ�.");
		} finally {

			ts.deleteThread(this);

		}

	} // run �޼ҵ� ����

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

					System.out.println("Ŭ���̾�Ʈ�� ������ �����߽��ϴ�. Ŭ���̾�Ʈ �ּ� : " + UserIp);
					break;
				}

				ts.broadCasting("[" + UserIp + "]" + "say :" + str);
				pw.println(str);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}// service �޼ҵ� ����

	public void sendMessage(String message) {
		pw.println(message);
	}

}
