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
			
			System.out.println("�����͸� �Է��ϼ���");
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			File file = new File("C://java_workspace//ch20//mem.dat");
			FileWriter fw = new FileWriter(file,true);
				
			System.out.println("�̸�? ");
			
			name = br.readLine();
			System.out.println("���̵�?");
			id = br.readLine();
			System.out.println("�н����� ?");
			pw = br.readLine();
			System.out.println("����?");
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
