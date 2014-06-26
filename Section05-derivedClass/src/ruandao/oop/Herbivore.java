package ruandao.oop;

public class Herbivore extends Animal {
	public Herbivore(String name){
		super(name);
	}
	
	public void sayHello(){
		System.out.println("你好！我是温顺的食草动物" + name);
	}
	
	public void eat(){
		System.out.println("阿弥陀佛，杀生可是罪过呀！我只吃青草和树叶子！");
	}
	
}
