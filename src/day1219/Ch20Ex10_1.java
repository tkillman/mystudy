package day1219;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;

public class Ch20Ex10_1 {
	
	
	public static void main(String[] args) {
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			
			File file = new File("C://java_workspace//ch20//mem5.dat");
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			
			System.out.println("�����͸� �Է��ϼ���");
			System.out.println("�̸� ?");
			String name = br.readLine();
			
			System.out.println("���̵�?");
			String id = br.readLine();
			
			System.out.println("�ּ�?");
			String add = br.readLine();
			
			oos.writeObject(name);
			oos.writeObject(id);
			oos.writeObject(add);
			oos.close();
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
