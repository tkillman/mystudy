package day1124;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	
	
	public static void main(String[] args) {
		
		Queue<String> q1 = new LinkedList<String>();
		
		q1.offer("첫째");
		q1.offer("둘째");
		q1.offer("셋째");
		
		System.out.println(q1);
		System.out.println(q1.poll());
		System.out.println(q1);
		System.out.println(q1.poll());
		System.out.println(q1);
		
		
		
		
	}
	
	
	
	

}
