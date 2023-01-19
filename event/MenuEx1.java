package event;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.PopupMenu;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Popup;

import AWT.MFrame;

public class MenuEx1 extends MFrame {
	
	TextArea ta;
	MenuBar mb;
	Menu file, edit;
	PopupMenu pm;
	
	public MenuEx1() {
		super(300,300);
		setTitle("MyEdit1.0");
		mb = new MenuBar();
		file = new Menu("����");
		edit = new Menu("����");
		
		file.add("������");
		file.add("����");
		file.addSeparator();
		file.add("����");
		file.add("���̸����� ����");
		file.addSeparator();
		file.add("�μ�");
		file.add("����");
		
		edit.add("���");
		edit.add("����");
		edit.add("�߶󳻱�");
		edit.add("�ٿ��ֱ�");
		
		mb.add(file);
		mb.add(edit);
		add(ta = new TextArea());
		setMenuBar(mb);
		popupMenu();
		validate();
	}
	
	public void popupMenu() {
		pm = new PopupMenu();
		pm.add("�������");
		pm.add("�ǵ�����");
		pm.addSeparator();
		pm.add("����");
		pm.add("�߶󳻱�");
		pm.add("�ٿ��ֱ�");
		pm.addSeparator();
		pm.add("��μ���");
		pm.add("�Ӽ�");
		pm.add("����");
		pm.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				if(cmd.equals("����")) {
					System.exit(0);
				}else if(cmd.equals("����")) {
					ta.append("MyEdit1.0");
				}
			}
		});
		add(pm);
		ta.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getButton() == 3) {
					pm.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});
	}
	public static void main(String[] args) {
		new MenuEx1();
	}

}
