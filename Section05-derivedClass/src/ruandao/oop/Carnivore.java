package ruandao.oop;

public class Carnivore extends Animal{
	public Carnivore(String name){
		super(name);
	}
	
	public void sayHello(){
		System.out.println("��ã��������͵���ʳ����" + name);
	}
	
	public void eat(){
		System.out.println("��ϲ��ʳ�⡣");
	}
}
