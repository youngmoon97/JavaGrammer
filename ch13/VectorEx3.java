package ch13;

import java.util.Vector;

public class VectorEx3 {
	public static void main(String[] args) {
		Vector vlist = new Vector(4,3);
		System.out.println(vlist.capacity());
		for (int i = 0; i < 10; i++) {
			vlist.add(i*10);
		}
		System.out.println(vlist.size());
		System.out.println(vlist.capacity());
		System.out.println("ù��° ���:" + vlist.firstElement());
		System.out.println("������ ���:" + vlist.lastElement());
		System.out.println("�ι�° ���:" + vlist.elementAt(1));//get�̶� ����
		System.out.println(vlist.isEmpty());
		vlist.remove(2);//3��° ��� ����
		System.out.println(vlist.size());
		System.out.println(vlist.capacity());
		vlist.trimToSize();//�ʿ���� �뷮����
		if(vlist.contains(50)) {
			System.out.println("����� ��ü");
		}
		vlist.removeAllElements();//��� ��� ���� 
	}

}
