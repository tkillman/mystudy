package day1219;

import java.io.FileOutputStream;
import java.io.InputStream;

public class Ch20Ex03 {
	
	
	public static void main(String[] args) {
		
		try {
			InputStream myin= System.in;
			FileOutputStream fos = new FileOutputStream("C://java_workspace//ch20//test.dat");
			int data = 0;
			
			while((data = myin.read())!= -1 ){
				fos.write(data);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
	}

}
