package mx.com.twg.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mx.com.twg.exception.*;
import mx.com.twg.dao.PersonaDao;
import mx.com.twg.dto.Persona;

public class PersonaDaoImpl implements PersonaDao {
	
	private java.sql.Connection userConn;
	private final String SQL_SELECT = "SELECT * FROM persona";
	private final String SQL_SELECT_PERSONA = "SELECT * FROM persona WHERE id_persona = ?";
	private final String SQL_INSERT = "INSERT INTO persona VALUES (null, ?, ? )";
	private final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ? WHERE id_persona = ?";
	private final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";

	public PersonaDaoImpl(){
	}

	public PersonaDaoImpl(final java.sql.Connection userConn){
		this.userConn = userConn;
	}
	
	@Override
	public List<Persona> selectPersonas() throws PersonaDaoException{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Persona> lp = new ArrayList<>();
		
		try {
			conn = (userConn != null) ? userConn : Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				lp.add(asignar(rs,new Persona()));
			}
			
		}catch (Exception _e) {
			_e.printStackTrace();
			throw new PersonaDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			Conexion.close(stmt);
			Conexion.close(conn);

		}
		return lp;
	}


	@Override
	public Persona selectPersona(int id) throws PersonaDaoException{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Persona p =null;
		
		try {
			conn = (userConn != null) ? userConn : Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_PERSONA);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			while(rs.next()) 
			p = asignar(rs,new Persona());
			
		}catch (Exception _e) {
			_e.printStackTrace();
			throw new PersonaDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			Conexion.close(stmt);
			Conexion.close(conn);

		}
		return p;
	}

	@Override
	public void insertPersona(Persona persona) throws PersonaDaoException{
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = (userConn != null) ? userConn : Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, persona.getNombre());
			stmt.setString(2, persona.getApellido());
			stmt.execute();
		}catch (Exception _e) {
			_e.printStackTrace();
			throw new PersonaDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			Conexion.close(stmt);
			Conexion.close(conn);
		}
	}

	@Override
	public void updatePersona(int id, Persona persona)throws PersonaDaoException {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = (userConn != null) ? userConn : Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, persona.getNombre());
			stmt.setString(2, persona.getApellido());
			stmt.setInt(3, id);
			stmt.execute();
		}catch (Exception _e) {
			_e.printStackTrace();
			throw new PersonaDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			Conexion.close(stmt);
			Conexion.close(conn);
		}
	}

	@Override
	public void deletePersona(int id) throws PersonaDaoException{
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = (userConn != null) ? userConn : Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, id);
			stmt.execute();
		}catch (Exception _e) {
			_e.printStackTrace();
			throw new PersonaDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			Conexion.close(stmt);
			Conexion.close(conn);
		}
	}
	

	private Persona asignar(ResultSet rs, Persona p) throws SQLException{
		int index = 1;
			p.setIdPersona(rs.getInt(index++));
			p.setNombre(rs.getString(index++));
			p.setApellido(rs.getString(index));
		return p;
	}

}
