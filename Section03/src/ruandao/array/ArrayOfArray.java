package ruandao.array;

public class ArrayOfArray {

	public static void main(String[] args) {
		String[] team1 = {"甲", "乙", "丙"};
		String[] team2 = {"孙悟空", "唐僧", "八戒", "沙和尚", "白龙马"};
		String[] team3 = {"杨老师","陈老师", "张老师"};
		
		String[][] banji = new String[][]{team1,team2,team3};
		
		String s;
		s = banji[0][1];  // s: "乙"
		
		String[] team = banji[0]; // 等同于 team = team1; 
	}

}
