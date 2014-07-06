package ruandao.datetime.bookstore;

import java.util.Date;

public class Borrow {
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
	
	public Borrow(String person, Book book){
		this.person = person;
		this.book = book;
		start = new Date();
	}
}
