package day1219;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;

public class Ch20Ex09 {

	public static void main(String[] args) {
		String name;
		String id;
		String pw;
		String gender;
		String age;

		try {
			File file = new File("C://java_workspace//ch20//mem.dat");

			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);

			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			System.out.println("�����͸� �Է��ϼ���");

			System.out.println("�̸�?");
			name = br.readLine();
			System.out.println("���̵�?");
			id = br.readLine();
			System.out.println("�н�����?");
			pw = br.readLine();
			System.out.println("����?");
			gender = br.readLine();
			System.out.println("����?");
			age = br.readLine();

			oos.writeObject(name);
			oos.writeObject(id);
			oos.writeObject(pw);
			oos.writeObject(gender);
			oos.writeObject(age);
			oos.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
