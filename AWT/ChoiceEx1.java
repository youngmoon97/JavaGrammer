package AWT;

import java.awt.Choice;
import java.awt.Color;

public class ChoiceEx1 extends MFrame {
	String city[] = {"���ø� �����ϼ���.","������","�� ��",
			"�Ͽ���","�� ��","�� ��","�� ��"};
	Choice ch;
	public ChoiceEx1() {
		super(300,300,new Color(100,200,100),true);
		ch = new Choice();
		for (int i = 0; i < city.length; i++) {
			ch.add(city[i]);
		}
		add(ch);
	}
	
	public static void main(String[] args) {
		new ChoiceEx1();
	}
}
