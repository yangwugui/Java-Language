package ruandao.array;

public class ArrayOfArray {

	public static void main(String[] args) {
		String[] team1 = {"��", "��", "��"};
		String[] team2 = {"�����", "��ɮ", "�˽�", "ɳ����", "������"};
		String[] team3 = {"����ʦ","����ʦ", "����ʦ"};
		
		String[][] banji = new String[][]{team1,team2,team3};
		
		String s;
		s = banji[0][1];  // s: "��"
		
		String[] team = banji[0]; // ��ͬ�� team = team1; 
	}

}
