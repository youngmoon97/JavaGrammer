package AWT;

import java.awt.Choice;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChoiceEx3 extends MFrame2 
implements ItemListener{
	Choice name, star;
	String ms[] = {"�� ��","�� ��","�̹�ȣ","�����","����","������"};
	String fs[] = {"��ƶ�","�̿���","���ϴ�","��ä��","�� ��","�迬��"};
	//���ڿ����� ������ ���� ������ �߰�
	public ChoiceEx3() {
		name = new Choice();
		name.add("���ڿ�����");
		name.add("���ڿ�����");
		star = new Choice();
		choicename(star,ms);
		
		name.addItemListener(this);
		star.addItemListener(this);
		
		add(name);
		add(star);
		}//--������
	
		public void choicename(Choice c, String s[]) {
			for (int i = 0; i < s.length; i++) {
				c.add(s[i]);
			}
		}//--�̸����¸޼���
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		name = (Choice)e.getSource();
		if(e.getItem().equals("���ڿ�����")) {
			star.removeAll();
			choicename(star, ms);	//�ٲ۰ųֱ�
		}else {
			star.removeAll();
			choicename(star,	fs);
		}
		add(name);
		add(star);
	}//--�����۹ٲٱ�
	
	public static void main(String[] args) {
		new ChoiceEx3();
	}
}
