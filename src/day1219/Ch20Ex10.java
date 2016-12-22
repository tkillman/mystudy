package day1219;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;

public class Ch20Ex10 {

	
	public static void main(String[] args) {
		try {
			String name;
			String id;
			String pw;
			String gender;
			String age;
			
			
			File file = new File("C://java_workspace//ch20//mem.dat");
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			
			OutputStream myos = System.out;
			
			name =(String) ois.readObject();
			id = (String)ois.readObject();
			pw = (String)ois.readObject();
			gender =(String)ois.readObject();
			age =(String)ois.readObject();
			
			System.out.println(name +id+pw+gender+age);
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
}
