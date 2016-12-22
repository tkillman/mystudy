package day1220;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

public class Ch20Ex07 {
	
	public static void main(String[] args) {
		int data =0;
		try {
			
			File file = new File("C://java_workspace//mem9.dat");
			FileInputStream fis = new FileInputStream(file);
			
			
			OutputStream os = System.out;
			
			
			while((data =fis.read())!=-1){
				os.write((char)data);
				os.flush();
				
			}
			fis.close();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}

}
