package day1219;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

public class Ch16Ex09 {
	
	
	public static void main(String[] args) {
		
		Hashtable<String, String> phoneList = new Hashtable<>();
		
		phoneList.put("±èµ¿±Ô", "010-8449-0556");
		phoneList.put("±è¼º¿Á", "010-7978-0887");
		phoneList.put("±èÀç¸í", "010-6270-0889");
		phoneList.put("±è°¡¿ø", "010-7145-2003");
		
	    Enumeration<String> enu = phoneList.keys();
		
	    
	    while(enu.hasMoreElements()){
	    	String k = enu.nextElement();
	    	String v= phoneList.get(k);
	    	System.out.println(v);
	    }
		
	}
	

}
