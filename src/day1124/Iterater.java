package day1124;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Iterater {

	
	public static void main(String[] args) {
		
		
		ArrayList<Integer> hs1 = new ArrayList<Integer>();
		hs1.add(1);
		hs1.add(2);
		hs1.add(3);
		hs1.add(4);
		hs1.add(5);
		hs1.add(6);
		hs1.add(7);
		hs1.add(8);
		hs1.add(1); // 동일한 값은 들어가질 않는다.
		
		System.out.println(hs1.toString()); 
		
		Iterator i_hs1 = (Iterator)hs1.iterator();
		
		while(i_hs1.hasNext()){
			System.out.println(i_hs1.next());
			
		}
	}
	
	
}
