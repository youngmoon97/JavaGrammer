package AWT;

import java.awt.Choice;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChoiceEx3 extends MFrame2 
implements ItemListener{
	Choice name, star;
	String ms[] = {"현 빈","원 빈","이민호","김수현","김우빈","이종석"};
	String fs[] = {"고아라","이연희","이하늬","문채원","수 지","김연아"};
	//남자연예인 누르면 남자 연예인 뜨게
	public ChoiceEx3() {
		name = new Choice();
		name.add("남자연예인");
		name.add("여자연예인");
		star = new Choice();
		choicename(star,ms);
		
		name.addItemListener(this);
		star.addItemListener(this);
		
		add(name);
		add(star);
		}//--생성자
	
		public void choicename(Choice c, String s[]) {
			for (int i = 0; i < s.length; i++) {
				c.add(s[i]);
			}
		}//--이름고르는메서드
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		name = (Choice)e.getSource();
		if(e.getItem().equals("남자연예인")) {
			star.removeAll();
			choicename(star, ms);	//바꾼거넣기
		}else {
			star.removeAll();
			choicename(star,	fs);
		}
		add(name);
		add(star);
	}//--아이템바꾸기
	
	public static void main(String[] args) {
		new ChoiceEx3();
	}
}
