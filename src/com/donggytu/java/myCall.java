package com.donggytu.java;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class myCall {

	
	public static void main(String[] args) {
		
		System.out.println(cal("3+7*2"));
		
	}
	
	public static String cal(String content){
		
		char[] operationCode = {'+','-','*','/'};// �����ȣ ����
 		ArrayList<String> postFix = new ArrayList<String>();// ���������� ǥ��
		Stack<Character> opStack = new Stack<Character>();// �����ȣ ������� �ֱ�
		Stack<String> calStack = new Stack<String>(); // ����� �ϴ� stack
		
		int index=0;
		for (int i = 0; i < content.length(); i++) {
			
			for (int j = 0; j < operationCode.length; j++) {
				if(content.charAt(i)==operationCode[j]){ //�����ȣ�� ������ i�� j
					postFix.add(content.substring(index, i).trim()); //
					index = i+1;
				
			
				if(opStack.isEmpty()){ //opStack�� ����� ������
					
					opStack.push(content.charAt(i));
				} 
					
				else if (order(opStack.peek())<order(content.charAt(i))){ //�켱������ ������
							opStack.push(content.charAt(i)); // �״�� ����ִ´�.
						
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
		
	////// ����� �����ϴ� calstack
		
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
		
		
		
		
		
		
	
	
	} // Ŭ������ ��
	
	
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
