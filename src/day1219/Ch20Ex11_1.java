package day1219;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Ch20Ex11_1 {
	
	public static void main(String[] args) {
		
		member m = new member("±è´ç±Ô", "ddong", "1234", 34, true);
		
		try {
			File file = new File("C://java_workspace//ch20//mem6.dat");
			FileOutputStream fos = new FileOutputStream(file,true);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(m);
			oos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
	}

}
