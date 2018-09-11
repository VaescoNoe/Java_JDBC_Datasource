
package mx.com.twg.exception;

public class PersonaDaoException extends DaoException
{

	public PersonaDaoException(String message){
		super(message);
	}


	public PersonaDaoException(String message, Throwable cause){
		super(message, cause);
	}

}
