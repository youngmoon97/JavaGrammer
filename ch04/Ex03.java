package ch04;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요");
		int a = sc.nextInt();
			if(a>=1 && a<=100) {
				String s= ""+a;
				if (s.contains("3")) {
					System.out.println("짝");
				}
				else if (s.contains("6")) {
					System.out.println("짝");
				}
				else if (s.contains("9")) {
					System.out.println("짝");
				}
				else {
					System.out.println(a);
				}
			}else {
				System.out.println("1-20까지 숫자만");
		}
	}
}


