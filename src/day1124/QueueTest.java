package day1124;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	
	
	public static void main(String[] args) {
		
		Queue<String> q1 = new LinkedList<String>();
		
		q1.offer("ù°");
		q1.offer("��°");
		q1.offer("��°");
		
		System.out.println(q1);
		System.out.println(q1.poll());
		System.out.println(q1);
		System.out.println(q1.poll());
		System.out.println(q1);
		
		
		
		
	}
	
	
	
	

}
