package ch10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionEx4 {

	public static void main(String[] args) {
		
		try {
			FileReader fr = new FileReader("ch10/test.txt");
			int a;
			while((a=fr.read())!=-1) {
				System.out.println((char)a);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
