package ruandao.oop;

public class Carnivore extends Animal{
	public Carnivore(String name){
		super(name);
	}
	
	public void sayHello(){
		System.out.println("你好！我是凶猛的肉食动物" + name);
	}
	
	public void eat(){
		System.out.println("我喜欢食肉。");
	}
}
