package com.donggytu.java;
import java.util.Random;
import java.util.Scanner;
public class sessor {
	
	
	public static void main(String agrs[]){
	Scanner sc = new Scanner(System.in);
	Random r = new Random(); //���� method
	int na, com;
	System.out.print("������ ���ڽ��ϱ�?\n1.���� \n2.���� \n3.�� \n1~3�� ���� �Է��ϼ���.->");
	na = sc.nextInt();
	com = r.nextInt(3); //3���� �� �߿� �ϳ��� �������� �����ؼ� ��ǻ���� �ǻ縦 ����.
	//��ǻ�� ���������� �κ�
	if (com == 1){
	System.out.println("��ǻ�ʹ� ������ �½��ϴ�.");
	}
	else if (com == 2){
	System.out.println("��ǻ�ʹ� ������ �½��ϴ�");
	}
	else {
	System.out.println("��ǻ�ʹ� ���� �½��ϴ�");
	}
	
	int result = (na - com + 3) % 3; // 0. ���ڱ� 1.���� 2.���� 
	switch (result){
	case 0 : System.out.print("�����ϴ٤Ѥ�");
	break;
	case 1 : System.out.print("����� �̰���ϴ�^^");
	break;
	case 2 : System.out.print("����� �����ϴ٤Ф�");
	break;
	}
	 
	sc.close();
	System.out.println(com);
	}
	 
	
	  

	}
	
