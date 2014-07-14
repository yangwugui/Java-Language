package ruandao.oop.library;

public class Book {
	private String name;
	private String state;
	private int count;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Book(){
		// no code;
	}
	
	public Book( String name){
		this.name = name;
		this.state = "可借";
		this.count = 0;
	}
	
	public String toString(){
		String str = "《" + this.name + "》，已经借了 " + this.count + "次，"; 
		str += this.state.equals("可借") ? "现在可借。" : "已经借出了。";
		return str;
	}
	
}
