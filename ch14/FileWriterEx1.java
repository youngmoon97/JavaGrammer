package ch14;

import java.io.FileWriter;

public class FileWriterEx1 {
	public static void main(String[] args) {
		String str = "�츮���� ���ǿ��� ��� ������ �޲�����,\n"
				+ "���� �ű⿣ ���̻� �����ϵ� �ƹ��͵� ���� �� ����.\n"
				+ "������ ������ ������ �Ǹ� �η����� ������ ���ǿ� �����̰�\n"
				+ "�;��Ѵ�.";
		try {
			char intxt[] = new char[str.length()];
			str.getChars(0, str.length(), intxt, 0);
//				for (int i = 0; i < intxt.length; i++) {
//					System.out.println(intxt[i]);
//				}
			//FileWriter ��ü ������ ������ ���������.
			FileWriter fw = new FileWriter("ch14/bbb.txt");
			fw.write(intxt);
			fw.flush();
			fw.close();
			System.out.println("End!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
