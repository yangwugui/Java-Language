package ruandao.exception;

public class MathTool {
	// 返回-1表示参数不合法，比如参数为负数是不允许的。
	// 返回的结果不是-1,才真的是表示阶乘的运算结果。
	public int fact(int i) 
			throws MyException{
		if( i<0 ) {
			//throw new MyException(this,"出错了！",9);
		}
		if( i==0 )return 1;
		return i * fact( i-1);
	}
}
