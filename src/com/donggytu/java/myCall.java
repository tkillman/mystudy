package com.donggytu.java;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class myCall {

	
	public static void main(String[] args) {
		
		System.out.println(cal("3+7*2"));
		
	}
	
	public static String cal(String content){
		
		char[] operationCode = {'+','-','*','/'};// 연산기호 정의
 		ArrayList<String> postFix = new ArrayList<String>();// 후위연산자 표시
		Stack<Character> opStack = new Stack<Character>();// 연산기호 순서대로 넣기
		Stack<String> calStack = new Stack<String>(); // 계산을 하는 stack
		
		int index=0;
		for (int i = 0; i < content.length(); i++) {
			
			for (int j = 0; j < operationCode.length; j++) {
				if(content.charAt(i)==operationCode[j]){ //연산부호를 만나는 i와 j
					postFix.add(content.substring(index, i).trim()); //
					index = i+1;
				
			
				if(opStack.isEmpty()){ //opStack이 비워져 있으면
					
					opStack.push(content.charAt(i));
				} 
					
				else if (order(opStack.peek())<order(content.charAt(i))){ //우선순위가 높으면
							opStack.push(content.charAt(i)); // 그대로 집어넣는다.
						
					}  else { 
							postFix.add(opStack.peek().toString());
							opStack.pop();
							opStack.push(content.charAt(i));
					
					}
					}
					
					
				}
				
			
			}
		
		postFix.add(content.substring(index,content.length()).trim());	
		
		if(!opStack.isEmpty()){
			
			for(int i=0;i<opStack.size();){
			postFix.add(opStack.peek().toString().trim());
			opStack.pop();
			
			}
		}
		
	////// 계산을 시작하는 calstack
		
		for(int i=0; i<postFix.size();i++){
			calStack.push(postFix.get(i));
			
			for(int j=0; j<operationCode.length; j++){
				if( postFix.get(i).charAt(0) == operationCode[j]){
					calStack.pop();
					
					int s2, s1;
					String rs;
					
					s2 = Integer.parseInt(calStack.pop());
					s1 = Integer.parseInt(calStack.pop());
					
					switch (operationCode[j]) {
					case '+':
						rs = String.valueOf(s2+s1);
						calStack.push(rs);
						break;
						
					case '-':
						rs = String.valueOf(s2-s1);
						calStack.push(rs);
						break;
					case '*':
						rs = String.valueOf(s2*s1);
						calStack.push(rs);
						break;
					case '/':
						rs = String.valueOf(s2/s1);
						calStack.push(rs);
						break;
					
					}
					
					
					
				}
				
				
			}
			
			
			
			
		}
		
		return calStack.peek();
		
		
		
		
		
		
	
	
	} // 클래스의 끝
	
	
	public static int order(char op){
		switch (op) {
		case '+':
		case '-':	
			return 1;
		case '/':
		case '*':
			return 2;
		
		default:
			return -1;
		}
		
	}
	
}
