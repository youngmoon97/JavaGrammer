package AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

	/*	2. ��ư�� Ŭ���ϸ� ActionEvent �̺�Ʈ ��ü �߻�
	 * �̺�Ʈ �ҽ��� ActionEvent ��ü�� �����ϱ� ����
	 * ActionListener�� ����*/
public class EventEx1 extends MFrame
implements ActionListener{
	Button btn ;
	// 1. �̺�Ʈ �ҽ� ����
	public EventEx1() {
		add(btn = new Button("�̺�Ʈ"), BorderLayout.SOUTH);
		// 4. �̺�Ʈ�ҽ��� �̺�Ʈ �ڵ鷯 ����(accXXXListener)
		btn.addActionListener(this);
		validate();
	}
	// 3. �̺�Ʈ�������� �޼ҵ�(�̺�Ʈ ��鷯) ����
	@Override
	public void actionPerformed(ActionEvent e) {
		setBackground(MColor.rColor());
	}
	
	public static void main(String[] args) {
		new EventEx1();
	}

}
