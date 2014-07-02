package ruandao.exception;

public class HandleError {
	//static double result;

	public static void main(String[] args) 
			throws MyError {
		double d = 0;
		try {
			d = squareRoot(-500);
		}
		catch( MyError except){
			// no code 
		}
		System.out.println("result=" + d);
	}
	
	public static double func(double x) 
			throws MyError{
		return squareRoot(x);
	}
	
	// Î±´úÂë
	public static double squareRoot(double x) 
			throws MyError{
		if( x<0 ) throw new MyError("x must large than 0.");  
		return Math.sqrt(x);
	}
	
}
