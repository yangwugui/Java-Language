package ruandao.datetime.library;

import java.util.HashMap;

public class Book {
	private String name;
	private int amount;
	private int count;
	
	private HashMap<String,Borrow> borrows;
	
	public HashMap<String, Borrow> getBorrows(){
		if( this.borrows == null ){
			this.borrows = new HashMap<String,Borrow>();
		}
		return this.borrows;
	}
	
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
		// NO CODE
	}

	public Book(String name){
		this(name,10);
	}
	
	public Book( String name, int amount){
		this.name = name;
		this.amount = amount;
		this.count = 0;
	}
	
	public String toString(){
		String str = "��" + this.name + "��һ����" +  (this.amount + borrows.size()) + "����";
		str += "�Ѿ����� " + this.count + "�˴Σ�"; 
		str += this.amount == 0 ? "�Ѿ�ȫ������ˡ�" : "��ʣ��" + this.amount + "���ɽ衣";
		return str;
	}
	
}
