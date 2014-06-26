package ruandao.oop;

public class Wolf extends Carnivore {
	public Wolf(){
		super("狼");
	}
	
	public void eat(){
		System.out.println("趁牧羊犬不注意，我们就偷吃小羊，羊肉真是美味呀！");
	}
}
