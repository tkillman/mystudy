package day1201;

import java.util.ArrayList;

public class ForEach {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<>();
		
		list.add("����");
		list.add("���");
		list.add("��");
		
		
		for(String elements : list){
			System.out.println(elements);
		}
		
		
	}
	
}
