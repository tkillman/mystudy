package soket.multi;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Ser {
	
	OutputStream os;
	OutputStreamWriter osw;

	public static void main(String[] args) {

		try {
			ServerSocket ss = new ServerSocket(5432);

			while (true) {
				Socket s = ss.accept();
				ServerThread st = new ServerThread(s);
				st.start();
			
			
				
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
