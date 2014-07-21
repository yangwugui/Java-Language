package ruandao.io;

import java.io.Serializable;
import java.util.Date;

public class Borrow implements Serializable {
	String person;
	Book book;
	Date start;
	
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	
	public Borrow(String person){
		this(person, new Date() );
	}
	
	public Borrow(String person, Date start){
		this.person = person;
		this.start = start;
	}
}
