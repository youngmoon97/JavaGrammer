package AWT;

import java.awt.Choice;

public class ChoiceEx3 extends MFrame {
	Choice name, star;
	String ms[] = {"�� ��","�� ��","�̹�ȣ","�����","����","������"};
	String fs[] = {"��ƶ�","�̿���","���ϴ�","��ä��","�� ��","�迬��"};
	
	public ChoiceEx3() {
		name = new Choice();
		name.add("���ڿ�����");
		name.add("���ڿ�����");
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
