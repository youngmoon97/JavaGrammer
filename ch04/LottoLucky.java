package ch04;

import java.util.Arrays;
import java.util.Iterator;

public class LottoLucky {

	public static void main(String[] args) {
		int lotto[] = getLotto();
		for (int i = 0; i < lotto.length; i++) {
			System.out.println(lotto[i]+"\t");
		}
	}
	
	public static int[] getLotto() {
		int lotto[] =new int[6];
		boolean isNumThere = false;
		for (int i = 0; i < lotto.length; i++) {
			isNumThere = false;
			lotto[i]= (int)(Math.random()*45)+1;
			for(int j=0;j<i;j++) {
				 if(lotto[i] == lotto[j]) {
					 isNumThere = true;
				 }
			}
			if(isNumThere)
				i--;
		/*for (int i = 0; i < lotto.length; i++) {
			lotto[i]= (int)(Math.random()*45)+1;
			for(int j=0;j<i;j++) {
				 if(lotto[i] == lotto[j]) {
					 i--;
					 break;
				 }
			}
		}*/
		Arrays.sort(lotto);
		System.out.println(Math.PI);
		return lotto;
		}
		return lotto;
	}
}
