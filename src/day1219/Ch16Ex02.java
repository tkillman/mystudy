package day1219;

import java.util.ArrayList;
import java.util.Iterator;

public class Ch16Ex02 {
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();	
			
		list.add("±èµ¿±Ô");
		list.add("±è°¡¿ø");
		list.add("±è¼º¿Á");
		list.add("±èÀç¸í");
		
		
		/*Iterator<String> it = list.iterator();	
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
		*/
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		
		int i = list.indexOf("±è¼º¿Á");
		
		System.out.println(i);
		
		
	}
	

	
}
