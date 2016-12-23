package day1219;

import java.io.FileInputStream;
import java.io.OutputStream;

public class Ch20Ex04 {
	
	public static void main(String[] args) {
		
		try {
			FileInputStream fis = new FileInputStream("C://java_workspace//ch20//test.dat");
			OutputStream os = System.out;
			int data=0;
			while((data = fis.read())!=-1){
				os.write(data);
			}
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
	}
	

}
