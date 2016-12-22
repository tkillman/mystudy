package day1220;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {

		try {

			ServerSocket ss = new ServerSocket(5432);

			Socket s;
			s = ss.accept();
			System.out.println(s);

			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();

			byte[] recBuf = new byte[50];
			int size = is.read(recBuf);
			String recMsg = new String(recBuf, 0, size);

			System.out.println(recMsg);

			OutputStreamWriter osw = new OutputStreamWriter(os);

			
			// 시간을 잡아먹는 코드
			InputStream istemp = System.in;
			InputStreamReader isrtemp = new InputStreamReader(istemp);
			BufferedReader br = new BufferedReader(isrtemp);
			String str = br.readLine();
			System.out.println("서버가 클라이언트에게 보내는 메세지 :" + str);

			
			osw.write(str);
			osw.flush();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
