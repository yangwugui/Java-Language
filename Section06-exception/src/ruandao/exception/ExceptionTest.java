package ruandao.exception;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ExceptionTest {

	public static void main(String[] args)
			throws Exception{
		try{
			jiecheng();
		}
		catch(RethrowException e){
			MyException innner = (MyException)e.getCause();
		}
		return ;
		
	}
	
	public static void jiecheng() throws Exception 
			{
		Scanner input = new Scanner(System.in);
		System.out.println("������һ��������");
		int x = input.nextInt();
		MathTool tool = new MathTool();
		
		int result = 0;
		
		try{
			result= tool.fact(x);
		}

		catch(MyException e){
			System.out.println(e.getMessage());
			System.out.println(" ���󼶱��ǣ�" + e.getErrorLevel());
			throw new RethrowException(e, "error");
		}
		finally{
			System.out.println("��л����л����л�ϵۣ�");
		}
		System.out.println( x + "�Ľ׳���" + result);

	}

}
