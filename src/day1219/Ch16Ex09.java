package day1219;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

public class Ch16Ex09 {
	
	
	public static void main(String[] args) {
		
		Hashtable<String, String> phoneList = new Hashtable<>();
		
		phoneList.put("�赿��", "010-8449-0556");
		phoneList.put("�輺��", "010-7978-0887");
		phoneList.put("�����", "010-6270-0889");
		phoneList.put("�谡��", "010-7145-2003");
		
	    Enumeration<String> enu = phoneList.keys();
		
	    
	    while(enu.hasMoreElements()){
	    	String k = enu.nextElement();
	    	String v= phoneList.get(k);
	    	System.out.println(v);
	    }
		
	}
	

}
