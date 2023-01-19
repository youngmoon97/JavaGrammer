package event;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import AWT.MColor;
import AWT.MFrame;

public class MouseEventEx3 extends MFrame {
	Button btn;
	public MouseEventEx3() {
		add(btn = new Button("button"), BorderLayout.SOUTH);
		btn.addMouseListener(new MyMouseAdater());
	}
	
	class MyMouseAdater extends MouseAdapter{
		//Adapter : 필요한 메서드만 override한다.
		@Override
		public void mouseEntered(MouseEvent e) {
			setBackground(MColor.rColor());
		}
		@Override
		public void mouseExited(MouseEvent e) {
			setBackground(MColor.rColor());
		}
	}
	public static void main(String[] args) {
		new MouseEventEx3();
	}

}
