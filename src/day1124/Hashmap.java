package day1124;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Hashmap {
	
	public static void main(String[] args) {
		
		HashMap<String, Integer> fruitPrice = new HashMap<String, Integer>();
			
		fruitPrice.put("apple", 1500);
		fruitPrice.put("banana", 2000);
		fruitPrice.put("lemon", 900);
		fruitPrice.put("orange", 1300);
		
		/*System.out.println(fruitPrice);*/
		
		Set entrySet = fruitPrice.entrySet();
		
		Iterator i_entry= entrySet.iterator();
		
		
		
		/*while (i_entry.hasNext()) {
			System.out.println(i_entry.next());
			
		}	*/
		
		Set se= fruitPrice.keySet();
		
		Iterator se_entry = se.iterator();
		
		
		
		
		
		
			
	}

}
