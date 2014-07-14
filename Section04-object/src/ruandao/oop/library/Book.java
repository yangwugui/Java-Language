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
		this.state = "�ɽ�";
		this.count = 0;
	}
	
	public String toString(){
		String str = "��" + this.name + "�����Ѿ����� " + this.count + "�Σ�"; 
		str += this.state.equals("�ɽ�") ? "���ڿɽ衣" : "�Ѿ�����ˡ�";
		return str;
	}
	
}
