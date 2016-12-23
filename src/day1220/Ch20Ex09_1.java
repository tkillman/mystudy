package day1220;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Ch20Ex09_1 {
	
	public static void main(String[] args) {
		member m;
		
		try {
			File file = new File("C://java_workspace//mem8.dat");
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			
			m = (member) ois.readObject();
			ois.close();
			
			
			System.out.println("데이터 불러오기");
			System.out.println(m);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
	}

}
