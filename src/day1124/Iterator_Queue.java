package day1124;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import com.mytest.pclass.exception;

public class Iterator_Queue {
	
	public static void main(String[] args) {
		
Queue<String> q1 = new LinkedList<String>();
		
		q1.offer("ù°");
		q1.offer("��°");
		q1.offer("��°");
		
	
		Iterator q1_1 = (Iterator) q1.iterator();
		
		while(q1_1.hasNext()){
			System.out.println(q1_1.next());
			
			
		}
		
		
		
	}

}
