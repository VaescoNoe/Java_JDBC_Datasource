
package mx.com.twg.factory;

import java.sql.Connection;

import mx.com.twg.dao.PersonaDao;
import mx.com.twg.jdbc.PersonaDaoImpl;

public class PersonaDaoFactory
{

	public static PersonaDao create(){
		return new PersonaDaoImpl();
	}

	public static PersonaDao create(Connection conn){
		return new PersonaDaoImpl( conn );
	}

}
