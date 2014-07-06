package ruandao.date;

import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import ruandao.utility.Console;

public class DateFormatDemo {

	public static void main(String[] args) 
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String dateString = Console.inputString("������һ������(yyyy-MM-dd)");
		Date date = sdf.parse(dateString);
		System.out.println("������������ǣ�" + date);
		
		SimpleDateFormat outSdf = new SimpleDateFormat("yyyy��M��d��");
		System.out.println("������������ǣ�" + outSdf.format(date) );
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println(calendar.getMaximum(Calendar.DAY_OF_MONTH));
		
	}

}
