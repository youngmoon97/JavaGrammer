package ch08;

abstract class Tv{
	String color;
	boolean power;
	int ch;
	void powerOnOff() {
		power=!power;
	}
	void upCh() {
		ch++;
	}
	void downCh() {
		ch--;
	}
	abstract void setModel();
}
class SMTv extends Tv implements RemoteControl{

	@Override
	public void turnOn() {
	}

	@Override
	public void turnOff() {
	}

	@Override
	void setModel() {
	}
	
}
class LGTv extends Tv implements RemoteControl{
	@Override
	void setModel() {
	}
	@Override
	public void turnOff() {
	}
	@Override
	public void turnOn() {
	}
}
interface RemoteControl{
	void turnOn();
	void turnOff();
	
}
public class interfaceEx4 {

	public static void main(String[] args) {

	}

}
