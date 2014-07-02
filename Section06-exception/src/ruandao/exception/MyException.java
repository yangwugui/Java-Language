package ruandao.exception;

public class MyException extends Exception{
	int errorLevel; // 1-10;
	String myMessage;
	
	public String getMyMessage() {
		return myMessage;
	}

	public void setMyMessage(String myMessage) {
		this.myMessage = myMessage;
	}

	public int getErrorLevel() {
		return errorLevel;
	}

	public void setErrorLevel(int errorLevel) {
		this.errorLevel = errorLevel;
	}

	public MyException(Throwable innerException, String message, int level){
		super(innerException);
		this.errorLevel = level;
		this.myMessage = message;
	}
}
