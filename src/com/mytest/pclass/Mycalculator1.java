package com.mytest.pclass;

import java.util.ArrayList;
import java.util.Stack;

public class Mycalculator1 {

	
	public static void main(String[] args) {
		
		System.out.println(cal("3+5*7"));
	}
	
	public static String cal(String content){
		
		char[] operationCode = {'+','-','*','/'};
		ArrayList<String> postFix = new ArrayList<String>();
		Stack<Character> opStack = new Stack<Character>();
		Stack<String> calStack = new Stack<String>();
		
		int index =0; 
		for(int i=0;i<content.length();i++){
			for(int j=0;j<operationCode.length;j++){
				if(content.charAt(i) == operationCode[j]){
					postFix.add(content.substring(index, i).trim());
					index = i+1;
					
				if(opStack.isEmpty()){
					opStack.push(content.charAt(i));
					
					
					
				}else{
					if(order(opStack.peek())<order(content.charAt(i))){
						opStack.push(content.charAt(i));
						
						
						
					} else{
						postFix.add(opStack.peek().toString());
						opStack.pop();
						opStack.push(content.charAt(i));
					}
				} 	
		
					
				}
			}
		}
		
		postFix.add(content.substring(index,content.length()).trim());
		
		if(!opStack.isEmpty()){
		for(int i=0;i<opStack.size();){
			postFix.add(opStack.peek().toString());
			opStack.pop();
		}
		}
		
	////////////////////////////////////////////////////////////////
		//계산 시작 로직
		
		for(int i=0;i<postFix.size();i++){
			calStack.push(postFix.get(i));
			
			for(int j=0;j<operationCode.length;j++){
				if(postFix.get(i).charAt(0) == operationCode[j]){
					calStack.pop();
					
					String s2, s1;
					s2= calStack.pop();
					s1= calStack.pop();
					
					int re;
					String result;
					
					switch (operationCode[j]) {
					
					case '+':
						
						re	=Integer.parseInt(s2)+Integer.parseInt(s1);
						result = String.valueOf(re);
						calStack.push(result);
						
						break;
						
						
					case '-':
						re	=Integer.parseInt(s2)-Integer.parseInt(s1);
						result = String.valueOf(re);
						calStack.push(result);
						
						break;
					case '*':
						re	=Integer.parseInt(s2)*Integer.parseInt(s1);
						result = String.valueOf(re);
						calStack.push(result);
						
						break;
					case '/':
						re	=Integer.parseInt(s2)/Integer.parseInt(s1);
						result = String.valueOf(re);
						calStack.push(result);
						
						break;
					}
					
				} 
					
					
				
				
			}
			
			
			
			
			
		}
		
		
		return calStack.peek();
				
		}
		
		
	
	
	public static int order(char op){
		switch (op) {
		case '+':
		case '-':
			return 1;
		
		case '*':
		case '/':
			return 2;
			
		default:
			return -1;
		}
		
		
		
		
	}
	
	
	
}
