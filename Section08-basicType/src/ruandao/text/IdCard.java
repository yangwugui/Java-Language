package ruandao.text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IdCard {
	Date birthday;
	String gender;
	
	public static void main(String[] args) {
		IdCard idCard = new IdCard();
		idCard.validIdCard("42010819900630573X");
		System.out.println(idCard.birthday + ", " + idCard.gender);
	}

	public boolean validIdCard(String idString){
		boolean ok = false;
		if( idString.length() != 18 ) return false;
		for( char c : idString.substring(0,17).toCharArray()){
			if( !Character.isDigit(c)) return false;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			birthday = sdf.parse(idString.substring(6,14));
		} catch (ParseException e) {
			return false;
		}
		int number = Integer.parseInt(idString.substring(16,17));
		gender =  number % 2 == 0 ? "Å®" : "ÄÐ";
			
		return ok;
	}
}
