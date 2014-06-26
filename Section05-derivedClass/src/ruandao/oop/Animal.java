package ruandao.oop;

public abstract class Animal {
	protected String name;
	
	public Animal(String name){
		this.name = name;
	}
	
	// java语言当中，如果不特殊指定，那么方法是虚拟的，简称虚方法。
	// 相当于c++中用virtual关键字指定的成员函数。
	public void sayHello(){
		System.out.println("你好，我是" + name);
	}
	
	abstract void eat() ;

	public void about(){
		this.sayHello();
		this.eat();
	}
}
