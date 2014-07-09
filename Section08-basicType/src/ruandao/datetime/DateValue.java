package ruandao.datetime;

public class DateValue {
	private int year;
	private int month;
	private int day;
	
	public DateValue(int year, int month, int day){
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public String toString(){
		return "years:" + year +", months=" + month + ", days=" + day;
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
}
