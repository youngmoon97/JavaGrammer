package ch14;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReaderEx1 {
	public static void main(String[] args) {
		InputStream is = System.in;
		//1byte������ ���� data�� ���ڴ����� ��ȯ
		Reader reader = new InputStreamReader(is);
		while(true) {
			try {
				int a = reader.read();//�������� ������ : �Է�
				if(a==-1/*ctrl+z*/) break;
				System.out.print((char)a);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("End");
	}

}
