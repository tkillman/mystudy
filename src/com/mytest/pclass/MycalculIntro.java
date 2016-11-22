package com.mytest.pclass;

import java.util.ArrayList;
import java.util.Stack;
/*
public class korea {

	public static void main(String[] args) {
		
*//*		cal("10+3*10");
*/	/*	
	}*/
	
/*	public static String cal(String content){
		
		char[] operationCode = {'+','-','*','/'};
		ArrayList<String> postFix= new ArrayList<String>();
		Stack<Character> opStack = new Stack<Character>();
		
		
		int index = 0;
		
		
		for(int i=0;i< content.length();i++){
			for(int j=0;j<operationCode.length;j++){
				if(	content.charAt(i) == operationCode[j]	){
					postFix.add(content.substring(index, i))
					
*/	/*				opStack이 비어있으면 부호를 opStack에 넣는다.
					
					opStack의 순서에 따라 넣고 우선순위가 높은 연산부호가 
					먼저 들어가 있으면 
					부호를 꺼내고 
					삭제한 뒤 
					opStack에 우선순위가 낮은 부호를 넣는다.
					
					index 값을 i+1; 로 설정한다.
					
					
					
				}
				
			}
				
			
		}
		
		마지막 값을 postFix에 집어넣는다.;
		
		opStack이 빌때까지 postFix에 순서대로 집어넣는다.;
		
	---------------------------------------------------
	계산을 시작하는 코드	
		
		for( i를 높이면서){
				calstack에 넣는다.
			
			for(j를 높이면서 ){
				if(	calstack값이 연산기호이면	){
					calstack 의 부호를 한번 버린다.
				
				숫자형 변수 두개를 설정해서
				calstack의 값을 pop시켜서 넣어준다.
					
					
					계산을 해주고
					calstack에 집어넣는다.
					
					
				}
				
				
			}
		}
		
		calstack.peek 마지막 값을 return 해준다.	
		
		
		
	}
	
}
*/