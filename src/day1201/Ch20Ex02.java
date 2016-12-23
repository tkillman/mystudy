package day1201;

import java.io.InputStream;
import java.io.OutputStream;

public class Ch20Ex02 {

	public static void main(String[] args) {

		InputStream myln = System.in;
		OutputStream myout = System.out;

		int data = 0;
		System.out.println("데이터를 입력하세요");
		try {
			while ((data = myln.read()) != -1) {
			myout.write(data);	
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
