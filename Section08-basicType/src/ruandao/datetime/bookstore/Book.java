package ruandao.datetime.bookstore;

import java.util.HashMap;

public class Book {
	private String name;
	private int amount;
	private int count;
	
	HashMap<String,Borrow> borrows;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
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
		this.borrows = new HashMap<String, Borrow>();
		this.name = name;
		this.amount = 10;
		this.count = 0;
	}
	
	public String toString(){
		String str = "��" + this.name + "��һ����" +  (this.amount + borrows.size()) + "����";
		str += "�Ѿ����� " + this.count + "�˴Σ�"; 
		str += this.amount == 0 ? "�Ѿ�ȫ������ˡ�" : "��ʣ��" + this.amount + "���ɽ衣";
		return str;
	}
	
}
