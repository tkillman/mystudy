package day1220;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class Ch20Ex03 {
	
	public static void main(String[] args) {
		
		int data =0;
		try {
			File file = new File("C://java_workspace//mem7.dat");
			FileOutputStream fos = new FileOutputStream(file,true);
			InputStream is = System.in;
			
			
			System.out.println("문자를 입력 후 엔터를 누르세요.");
			
			while((data=is.read())!=-1){
				fos.write(data);
			
			}
			
			fos.close();
			
		} catch (Exception e) {
		
			e.printStackTrace();
			
		}
		
	}

}
