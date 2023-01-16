package ch11;

import ch06.AccessEx5;

public class StringEx3 {
	public static void main(String[] args) {
		String str = "전지현이가 백화점에서 팬사인회를 연다."
				 + "전지현은 5일 오후 3시 서울 소공동 롯데 백화점"
				 + " 8층 이벤트홀에서... 구두 브랜드 조이제화의" 
				 + " 홍보를 위한 팬사인회에 참석한다.";
		int len = str.length();
		/*1번.순방향으로 공백문자의 index번호를 출력하시오.
		5, 11,......87, : hint : indexOf을 사용한다.*/
		
		/*2번.역방향으로 공백문자의 index번호를 출력하시오.
		87, 81, 78,....5,  : hint : lastIndexOf을 사용한다.*/
		
		/*3번.빈칸을 '_' 출력하시오. hint:charAt*/
		
		/*4번 첫단어 출력하기 : substring, indexOf*/
		
		/*5번 마지막단어 출력하기 : substring, lastIndexOf*/
		
		for (int i = 0; i < len; i++) {
			if(str.charAt(i)==' ') {
				System.out.print(i+", ");
			}
		}//--1
		
		System.out.println("\n ");
		for (int i = len-1; i >= 0; i--) {
			if(str.charAt(i)==' ') {
				System.out.print(i+", ");
			}
		}//--2		
		System.out.println("\n ");
		for (int i = 0; i < len; i++) {
			if(str.charAt(i)==' ') {
				System.out.print('_');
			}else
				System.out.print(str.charAt(i));
		}
		System.out.println("\n ");
		String arr[]=str.split(" ");
		int lastidx = arr.length-1;
		System.out.println(arr[0]);
		System.out.println(arr[lastidx]);
		
		}
}

