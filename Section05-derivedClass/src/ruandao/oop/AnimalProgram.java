package ruandao.oop;

public class AnimalProgram {

	public static void main(String[] args) {
		// 继承
		Carnivore carnivore = new Carnivore("狮子");
		carnivore.sayHello();
		Dog dog = new Dog();
		dog.sayHello();
		Wolf wolf = new Wolf();
		dog.sayHello();

		Herbivore herbivore = new Herbivore("长颈鹿");
		herbivore.sayHello();
		Elephant elephant = new Elephant();
		elephant.sayHello();
		Panda panda = new Panda();
		panda.sayHello();
		
		// 多态
		Animal animal1 = new Dog();
		animal1.eat();
		Animal animal2 = new Carnivore("狮子");
		animal2.eat();
		
		// 多态：实现回调(CallBack)，已有的代码调用未知的代码
		Animal animal = new Panda();
		animal.about();
	}
	
}
