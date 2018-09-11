
package mx.com.twg.exception;

public class DaoException extends Exception
{
	private Throwable throwable;

	public DaoException(String message){
		super(message);
	}

	public DaoException(String message, Throwable throwable){
		super(message);
		this.throwable = throwable;
	}

	public Throwable getCause(){
		return throwable;
	}

}
