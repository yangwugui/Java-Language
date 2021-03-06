package ruandao.datetime.library;

import java.util.Date;

public class Borrow {
	String person;
	Date start;
	
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
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
