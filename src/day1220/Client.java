package day1220;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {

		try {

			Socket s = new Socket("127.0.0.1", 5432);
			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);

			InputStream istemp = System.in;
			InputStreamReader isrtemp = new InputStreamReader(istemp);
			BufferedReader br = new BufferedReader(isrtemp);
			String str = br.readLine();

			osw.write(str);
			osw.flush();

			InputStream is = s.getInputStream();

			//시간을 잡아먹는 코드
			byte[] recBuf = new byte[50];
			int size = is.read(recBuf);
			String recMsg = new String(recBuf, 0, size);
			System.out.println(recMsg);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
