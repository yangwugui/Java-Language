package ruandao.flow;
import java.util.Scanner;


public class Select {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入分数(1-5):");
		int grade = input.nextInt();
		switch( grade ){
		case 1:
		case 2:
			System.out.println("请家长！");
			break;
		case 3:
			System.out.println("要努力啦！");
			break;
		case 4:
			System.out.println("还不错，继续保持！");
			break;
		default:
			System.out.println("真棒，very very Good!");
			break;
		}
	}

}
