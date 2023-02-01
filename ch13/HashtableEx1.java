package ch13;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashtableEx1 {

	public static void main(String[] args) {
		Hashtable<String, String> ht1 = new Hashtable<String, String>();
		ht1.put("���", "Apple");
		ht1.put("����", "Grapes");
		ht1.put("����", "Strawberry");
		ht1.put("����", "Erdbeeren");//�����
		ht1.put("a", "1111");
		Enumeration<String> e = ht1.keys();
		while (e.hasMoreElements()) {
			String key = e.nextElement();
			String value = ht1.get(key);
			System.out.println(key + " : " + value);
		}
	}

}
