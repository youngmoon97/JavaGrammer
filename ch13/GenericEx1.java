package ch13;

class Box1 {//�پ��� Ÿ���� �����͸� ����
	
	private Object data;
	
	public void set(Object data) {
		this.data = data;
	}
	
	public Object get() {
		return data;
	}
}

class Box2<T>{
	private T data;
	public void set(T data) {
		this.data = data;
	}
	public T get() {
		return data;
	}
}

public class GenericEx1{
	public static void main(String[] args) {
		Box1 b = new Box1();
		b.set(Integer.valueOf(22));
		Integer i = (Integer)b.get();
		b.set("����");
		//Integer i2 = (Integer)b.get(); -> ����
		Box2<String> b2 = new Box2<String>();
		b2.set("����");
		//b2.set(Integer.valueOf(23)); ����
	}

}
