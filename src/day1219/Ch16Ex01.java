package day1219;

import java.util.HashSet;
import java.util.Iterator;

public class Ch16Ex01 {

	public static void main(String[] args) {

		HashSet<String> set = new HashSet<>();

		set.add("����");
		set.add("����");
		set.add("������");

		System.out.println(set.isEmpty());

		System.out.println(set.contains("������"));

		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

}
