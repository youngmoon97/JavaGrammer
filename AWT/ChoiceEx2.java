package AWT;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ChoiceEx2 extends MFrame 
implements ItemListener{
	String sair[] = {"�����װ�","�ƽþƳ�","����λ�","������"};
	String scity[] = {"�� ��","�� ��","�� ��","�� ��","���ֵ�"};
	Choice air,city;
	
	public ChoiceEx2() {
		super(300,300,new Color(100,200,100),true);
		air = new Choice();
		city = new Choice();
		for (int i = 0; i < sair.length; i++) {
			air.add(sair[i]);
		}
		for (int i = 0; i < scity.length; i++) {
			city.add(scity[i]);
		}
		add(air);
		add(city);
		air.addItemListener(this);
		city.addItemListener(this);
		add(new Label("�װ���� ���ø� �����ϼ���."));
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		repaint(); // ��������� paintȣ��
	}
	@Override
	public void paint(Graphics g) {
		if(air==null || city==null) {
			return; // �޼��� �߰��� return�� ���Ŀ� �ڵ��� ����ȭ
		}
		g.setColor(Color.blue);
		String str = "�װ��� ���� : "+air.getSelectedItem();
		g.drawString(str, 30, 120);
		g.setColor(Color.red);
		str = "���� ���� : " + city.getSelectedItem();
		g.drawString(str, 30, 150);
	}
	public static void main(String[] args) {
		new ChoiceEx2();
	}
}
