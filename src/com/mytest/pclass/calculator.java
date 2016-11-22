package com.mytest.pclass;

import java.util.Scanner;

public class calculator {

	public static void main(String[] args) {
			
		
			
		while(true){
		Scanner sc= new Scanner(System.in);
		String input=sc.nextLine();
			
			
		if(input.contains("+")){
			String[] what=input.split("\\+");
			int result =Integer.parseInt(what[0]) +Integer.parseInt(what[1]);
			System.out.println(result);
			
		} else if (input.contains("*")){
			String[] what=input.split("\\*");
			int result =Integer.parseInt(what[0]) *Integer.parseInt(what[1]);
			System.out.println(result);
			
		} else if (input.contains("-")){
			String[] what=input.split("\\-");
			int result =Integer.parseInt(what[0]) -Integer.parseInt(what[1]);
			System.out.println(result);
			
		} else if(input.contains("/")){
			String[] what=input.split("\\/");
			double result =(double)Integer.parseInt(what[0]) /(double)Integer.parseInt(what[1]);
			System.out.println(result);
			
		} else{
			System.out.println("입력 오류");
			break;
				}
		
			}
		
		}
		
		
	}


