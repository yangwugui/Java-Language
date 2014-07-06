package ruandao.date;

import java.util.Calendar;
import java.util.Date;

public class DateMinus {

	public static void main(String[] args) {

	}
	
	public void minus(Date date1, Date date2){
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(date1);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(date2);
		
		if( calendar1.before(calendar2) ){
			Calendar tmp = calendar1;
			calendar1 = calendar2;
			calendar2 = tmp;
		}
		
		int year1 = calendar1.get(Calendar.YEAR);
		int month1 = calendar1.get(Calendar.MONTH); // base 0
		int day1 = calendar1.get(Calendar.DAY_OF_MONTH); // base 1
		
		int year2 = calendar2.get(Calendar.YEAR);
		int month2 = calendar2.get(Calendar.MONTH); // base 0
		int day2 = calendar2.get(Calendar.DAY_OF_MONTH); // base 1
		
		if(day1<day2){
			month1 --;
			calendar1.add(Calendar.MONTH, -1);
			day1 += calendar1.getActualMaximum(Calendar.DAY_OF_MONTH);
			if(month1<0){
				month1 = 11;
				year1 --;
			}
		}
		int day = day1 - day2;
		
		if(month1<month2){
			month1 += 12;
			year1 --;
		}
		int month = month1 - month2;
		
		int year = year1 - year2;
	}

}
