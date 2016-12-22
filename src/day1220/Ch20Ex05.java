package day1220;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ch20Ex05 {

	
	public static void main(String[] args) {
		String name;
		String id;
		String pw;
		
		try {

			File file = new File("C://java_workspace//mem9.dat");
			FileOutputStream fos= new FileOutputStream(file,true);
			
			InputStream is = System.in;
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			System.out.println("이름?");
			
			
			name = br.readLine();
			System.out.println("아이디?");
			
			id = br.readLine();
			
			System.out.println("패스워드?");
			
			pw = br.readLine();
			
			fos.write(name.getBytes());
			fos.write(id.getBytes());
			fos.write(pw.getBytes());
			
			fos.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
