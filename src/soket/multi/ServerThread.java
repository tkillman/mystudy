package soket.multi;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerThread extends Thread {
	Socket s;
	InputStream is;
	BufferedReader br;
	InputStreamReader isr;

	public ServerThread(Socket s) {
		this.s = s;

	}

	@Override
	public void run() {

		try {

			is = s.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);

			while (true) {
				String recMsg = br.readLine();

				if (recMsg == null) {
					break;
				}

				System.out.println(recMsg);
				s.close();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
