package day1219;

import java.util.ArrayList;
import java.util.Iterator;

public class Ch16Ex02 {
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();	
			
		list.add("�赿��");
		list.add("�谡��");
		list.add("�輺��");
		list.add("�����");
		
		
		/*Iterator<String> it = list.iterator();	
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
		*/
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		
		int i = list.indexOf("�輺��");
		
		System.out.println(i);
		
		
	}
	

	
}
