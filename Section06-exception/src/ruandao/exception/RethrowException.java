package ruandao.exception;

public class RethrowException extends MyException {
	public RethrowException(Throwable innerException, String msg){
		super(innerException,msg, 5);
	}
}
