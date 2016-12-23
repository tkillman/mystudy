package multiChatting;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {

	public void go() {

		try {
			ServerSocket ss = new ServerSocket();
			InetSocketAddress sa = new InetSocketAddress("127.0.0.1", 5321);
			ss.bind(sa);

			while (true) {
				Socket s = ss.accept();
				ServerThread st = new ServerThread(s, this);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		TestServer ts = new TestServer();

		try {

			ts.go();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
