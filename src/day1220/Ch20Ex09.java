package day1220;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Ch20Ex09 {

	public static void main(String[] args) {
		
		member m = new member("±èµ¿±Ô","tk","1234",34,true);
		
		try {
			File file = new File("C://java_workspace//mem8.dat");
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			
			oos.writeObject(m);
			oos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
	}
	
}
