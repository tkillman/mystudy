package com.donggytu.java;
import java.util.Random;
import java.util.Scanner;
public class sessor {
	
	
	public static void main(String agrs[]){
	Scanner sc = new Scanner(System.in);
	Random r = new Random(); //랜덤 method
	int na, com;
	System.out.print("무엇을 내겠습니까?\n1.가위 \n2.바위 \n3.보 \n1~3의 값을 입력하세요.->");
	na = sc.nextInt();
	com = r.nextInt(3); //3가지 수 중에 하나를 랜덤으로 선택해서 컴퓨터의 의사를 결정.
	//컴퓨터 가위바위보 부분
	if (com == 1){
	System.out.println("컴퓨터는 가위를 냈습니다.");
	}
	else if (com == 2){
	System.out.println("컴퓨터는 바위를 냈습니다");
	}
	else {
	System.out.println("컴퓨터는 보를 냈습니다");
	}
	
	int result = (na - com + 3) % 3; // 0. 보자기 1.가위 2.바위 
	switch (result){
	case 0 : System.out.print("비겼습니다ㅡㅡ");
	break;
	case 1 : System.out.print("당신이 이겼습니다^^");
	break;
	case 2 : System.out.print("당신이 졌습니다ㅠㅠ");
	break;
	}
	 
	sc.close();
	System.out.println(com);
	}
	 
	
	  

	}
	
