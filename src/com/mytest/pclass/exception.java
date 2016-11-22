package com.mytest.pclass;

public class exception {

	public static void main(String[] args) {
		
		
		try{Thread.sleep(3000);	
			}
		catch(InterruptedException e){
			System.out.println("InterruptedException 예외가 발생함,죄송합니다!!");
			}
		finally{
			System.out.println("정상실행됨!");
			
				}
		/*	sleep : 일정시간동안 진행을 멈춘다.
	
		Thread.sleep (밀리초)
	
	Thread.sleep(3000);
	
	*Thread & Process 
	*
		pid -- process id
				Thread
				Thread
				Thread*/
	// unhandled exception type InterruptedException		
	//못 다루는------- 예외상황 -----------예외종류		
	
	/**예외처리
	
	* try/catch/finally
	* Throws
	
	try{예외가 발생할 확률이 높은 코드}
	catch(예외종류 변수명){예외가 발생했을 때 실행할 코드}
	finally{예외가 발생했을 때 실행할 코드}
	*/
	
	/**Throws
	-형식 
	public static void testMethod() throws InterruptedException {
											예외종류
		
	}
			*/
		
	
	
	}

	
	
	
}
