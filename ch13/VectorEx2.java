package ch13;

import java.util.Vector;

public class VectorEx2 {

	public static void main(String[] args) {
		String str[] = {"�븣����","������","��������","����ũ","ĳ����"};
		Vector vlist1 = new Vector();
		Vector<String> vlist2 = new Vector<String>();
		for (int i = 0; i < str.length; i++) {
			vlist1.add(str[i]);
			vlist2.add(str[i]);
		}
		for (int i = 0; i < vlist1.size(); i++) {
			String s = (String)vlist1.get(i);
			String s1 = vlist2.get(i);
		}
		for (Object obj : vlist1) {
			
		}
		for (String string : vlist2) {
			
		}
	}

}
