package AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

	/*	2. 버튼을 클릭하면 ActionEvent 이벤트 객체 발생
	 * 이벤트 소스랑 ActionEvent 객체를 연결하기 위한
	 * ActionListener를 구현*/
public class EventEx1 extends MFrame
implements ActionListener{
	Button btn ;
	// 1. 이벤트 소스 생성
	public EventEx1() {
		add(btn = new Button("이벤트"), BorderLayout.SOUTH);
		// 4. 이벤트소스랑 이벤트 핸들러 연결(accXXXListener)
		btn.addActionListener(this);
		validate();
	}
	// 3. 이벤트리스너의 메소드(이벤트 헨들러) 구현
	@Override
	public void actionPerformed(ActionEvent e) {
		setBackground(MColor.rColor());
	}
	
	public static void main(String[] args) {
		new EventEx1();
	}

}
