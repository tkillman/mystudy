package com.mytest.pclass;

public class exception {

	public static void main(String[] args) {
		
		
		try{Thread.sleep(3000);	
			}
		catch(InterruptedException e){
			System.out.println("InterruptedException ���ܰ� �߻���,�˼��մϴ�!!");
			}
		finally{
			System.out.println("��������!");
			
				}
		/*	sleep : �����ð����� ������ �����.
	
		Thread.sleep (�и���)
	
	Thread.sleep(3000);
	
	*Thread & Process 
	*
		pid -- process id
				Thread
				Thread
				Thread*/
	// unhandled exception type InterruptedException		
	//�� �ٷ��------- ���ܻ�Ȳ -----------��������		
	
	/**����ó��
	
	* try/catch/finally
	* Throws
	
	try{���ܰ� �߻��� Ȯ���� ���� �ڵ�}
	catch(�������� ������){���ܰ� �߻����� �� ������ �ڵ�}
	finally{���ܰ� �߻����� �� ������ �ڵ�}
	*/
	
	/**Throws
	-���� 
	public static void testMethod() throws InterruptedException {
											��������
		
	}
			*/
		
	
	
	}

	
	
	
}
