package ruandao.oop;

public abstract class Animal {
	protected String name;
	
	public Animal(String name){
		this.name = name;
	}
	
	// java���Ե��У����������ָ������ô����������ģ�����鷽����
	// �൱��c++����virtual�ؼ���ָ���ĳ�Ա������
	public void sayHello(){
		System.out.println("��ã�����" + name);
	}
	
	abstract void eat() ;

	public void about(){
		this.sayHello();
		this.eat();
	}
}
