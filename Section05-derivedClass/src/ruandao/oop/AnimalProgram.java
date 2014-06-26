package ruandao.oop;

public class AnimalProgram {

	public static void main(String[] args) {
		// �̳�
		Carnivore carnivore = new Carnivore("ʨ��");
		carnivore.sayHello();
		Dog dog = new Dog();
		dog.sayHello();
		Wolf wolf = new Wolf();
		dog.sayHello();

		Herbivore herbivore = new Herbivore("����¹");
		herbivore.sayHello();
		Elephant elephant = new Elephant();
		elephant.sayHello();
		Panda panda = new Panda();
		panda.sayHello();
		
		// ��̬
		Animal animal1 = new Dog();
		animal1.eat();
		Animal animal2 = new Carnivore("ʨ��");
		animal2.eat();
		
		// ��̬��ʵ�ֻص�(CallBack)�����еĴ������δ֪�Ĵ���
		Animal animal = new Panda();
		animal.about();
	}
	
}
