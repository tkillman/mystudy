package day1124;

import java.util.HashSet;
import java.util.Iterator;

public class HasSetTest {
	
	HashSet<Integer> hs1 = new HashSet<Integer>();
	
	
	
	
	public static void main(String[] args){
		
		HashSet<Integer> hs1 = new HashSet<Integer>();
		hs1.add(1);
		hs1.add(2);
		hs1.add(3);
		hs1.add(4);
		hs1.add(5);
		
		hs1.add(7);
		hs1.add(6);// �� ������ �߿����� �ʴ�.
		
		hs1.add(8);
		hs1.add(1); // ������ ���� ���� �ʴ´�. 
		
		System.out.println(hs1.toString()); 
		
		
		Iterator i_hs1 = hs1.iterator();
		
		
		
		while(i_hs1.hasNext()){
			System.out.println(i_hs1.next());
			
		}
		
		
		
		
		
		
	}
	

}
