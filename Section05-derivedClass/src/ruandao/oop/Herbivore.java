package ruandao.oop;

public class Herbivore extends Animal {
	public Herbivore(String name){
		super(name);
	}
	
	public void sayHello(){
		System.out.println("��ã�������˳��ʳ�ݶ���" + name);
	}
	
	public void eat(){
		System.out.println("�����ӷ�ɱ���������ѽ����ֻ����ݺ���Ҷ�ӣ�");
	}
	
}
