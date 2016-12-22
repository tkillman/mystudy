package day1219;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Ch20Ex10_2 {
	
	public static void main(String[] args) {
		
		try {
			File file = new File("C://java_workspace//ch20//mem5.dat"); 
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			String name =(String) ois.readObject();
			String id =(String)ois.readObject();
			String add =(String)ois.readObject();
			
			
			System.out.println(name +"\r"+id +"\r"+add);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
	}

}
