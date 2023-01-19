package event;

import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ItemEventEx1 extends MFrame {
	
	Label label;
	Checkbox cb1, cb2, cb3;
	
	public ItemEventEx1() {
		super(300, 200);
		setLayout(new FlowLayout());
		add(cb1=new Checkbox("����"));
		add(cb2=new Checkbox("�ٳ���"));
		add(cb3=new Checkbox("���"));
		add(label = new Label("���� ���� :                    "));
		MyItem mi = new MyItem(this);
		cb1.addItemListener(mi);
		cb2.addItemListener(mi);
		cb3.addItemListener(mi);
	}
	public static void main(String[] args) {
		new ItemEventEx1();
	}
}

//�ܺ�Ŭ�������� �ʿ��� �̺�Ʈ ������ ����(Event2����)

class MyItem implements ItemListener{
	ItemEventEx1 f;
	public MyItem(ItemEventEx1 f) {
		this.f=f;
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		Checkbox cb = (Checkbox)e.getSource();
		String str = cb.getLabel()+ " : " +cb.getState();
		f.setTitle(str);
		f.label.setText(str);
	}
}



