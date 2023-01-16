package ch04;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		//입력한 숫자가 음수인지 양수인지 판단
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요");
		int a = sc.nextInt();
		
			if(a>=1 && a<=20) {
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
