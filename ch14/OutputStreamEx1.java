package ch14;

import java.io.OutputStream;

public class OutputStreamEx1 {

	public static void main(String[] args) {
		int i = 'A';
		char c = 'b';
		char c1 = 'z';
		try {
			OutputStream os = System.out;//�ܼ�â�� ��½�Ʈ���� ����� �žҴ�.
			os.write(i);
			os.write(c);
			os.write(c1);
			os.flush();//��Ʈ���� �����ִ� data�� ����.
			os. close();//������� �ʴ� ��Ʈ���� �ݵ�� �ݴ´�.
		} catch (Exception e) {}
	}

}
