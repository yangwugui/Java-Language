package ruandao.exception;

public class MyError extends Exception {
	String message;
	
	public MyError(String message){
		this.message = message;
	}
	
	public String getMessage(){
		return this.message;
	}
}
