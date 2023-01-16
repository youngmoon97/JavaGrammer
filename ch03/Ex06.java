package ch03;

import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요");
		int a = sc.nextInt();
		System.out.println("입력 숫자 : "+a);
		if(a%3==0) {
			System.out.println("3배수");
		}
		else {
			System.out.println("3배수 ㄴㄴ");
		}
	}

}
