package day1219;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Ch20Ex11_2 {
	
	public static void main(String[] args) {
		
		
		try {
			File file = new File("C://java_workspace//ch20//mem6.dat");
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			member m;
			m= (member)ois.readObject();
			ois.close();
			
			System.out.print(m);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
