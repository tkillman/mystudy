package day1219;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Ch20Ex06 {
	
	public static void main(String[] args) {
		
		String name;
		String id;
		String pw;
		String age;
		
		
		
		try {
			
			System.out.println("데이터를 입력하세요");
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			File file = new File("C://java_workspace//ch20//mem.dat");
			FileWriter fw = new FileWriter(file,true);
				
			System.out.println("이름? ");
			
			name = br.readLine();
			System.out.println("아이디?");
			id = br.readLine();
			System.out.println("패스워드 ?");
			pw = br.readLine();
			System.out.println("나이?");
			age = br.readLine();
			
			fw.write(name);fw.write("\r\n");
			fw.write(id);fw.write("\r\n");
			fw.write(pw);fw.write("\r\n");
			fw.write(age);fw.write("\r\n");
			fw.close();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
	}

}
