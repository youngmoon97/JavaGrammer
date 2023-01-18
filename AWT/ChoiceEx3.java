package AWT;

import java.awt.Choice;

public class ChoiceEx3 extends MFrame {
	Choice name, star;
	String ms[] = {"현 빈","원 빈","이민호","김수현","김우빈","이종석"};
	String fs[] = {"고아라","이연희","이하늬","문채원","수 지","김연아"};
	
	public ChoiceEx3() {
		name = new Choice();
		name.add("남자연예인");
		name.add("여자연예인");
		star = new Choice();
		for (int i = 0; i < fs.length; i++) {
			star.add(fs[i]);
		}
		add(name);
		add(star);
	}
	public static void main(String[] args) {
		new ChoiceEx3();
	}
}
