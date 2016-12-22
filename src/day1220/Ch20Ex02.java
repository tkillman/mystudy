package day1220;

import java.io.InputStream;
import java.io.OutputStream;

public class Ch20Ex02 {

	public static void main(String[] args) {

		int data = 0;

		InputStream is = System.in;
		OutputStream os = System.out;

		try {
			System.out.println("문자를 입력해보세요");
			while ((data = is.read()) != -1) {

				os.write(data);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
