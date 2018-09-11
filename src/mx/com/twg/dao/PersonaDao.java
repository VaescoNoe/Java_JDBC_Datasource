package mx.com.twg.dao;


import mx.com.twg.exception.*;

import java.util.List;

import mx.com.twg.dto.Persona;

public interface PersonaDao {
	
	public List<Persona> selectPersonas() throws PersonaDaoException;
	public Persona selectPersona(int id) throws PersonaDaoException;
	public void insertPersona(Persona persona) throws PersonaDaoException;
	public void updatePersona(int id,Persona persona) throws PersonaDaoException;
	public void deletePersona(int id) throws PersonaDaoException;

}
