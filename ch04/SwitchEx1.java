package ch04;

import java.util.Scanner;

public class SwitchEx1 {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Month를 입력하세요.");
			int m=sc.nextInt();
			if(m==12 || m==1||m==2) {
				System.out.println("겨울");
			}
	}

}
