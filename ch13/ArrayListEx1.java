package ch13;

import java.util.ArrayList;
import java.util.Iterator;

import javax.print.DocFlavor.STRING;

public class ArrayListEx1 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("��������");
		list.add("���뱹��");
		list.add("�����");
		list.add(2, "������ ����");
		list.add(3,"���屹��");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("----------");
		Iterator<String> e = list.iterator();
		while (e.hasNext()) {
			System.out.println(e.next());;
			
		}
	}

}
