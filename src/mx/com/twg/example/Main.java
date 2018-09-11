package mx.com.twg.example;

import java.util.List;

import mx.com.twg.dao.PersonaDao;
import mx.com.twg.dto.Persona;
import mx.com.twg.exception.PersonaDaoException;
import mx.com.twg.factory.PersonaDaoFactory;

public class Main {

	public static void main(String[] args) {
	
		nuevaPersona("Noe","Aurelio");
		consultarPersonas();
		actualizarPersonas(42,"Hugo","Chavez");
		consularPersona(42);
		borrarPersona(41);
		consultarPersonas();
	}

	private static void borrarPersona(int id) {
		try {
			PersonaDao per = PersonaDaoFactory.create();
			per.deletePersona(id);
		} catch (PersonaDaoException e) {
			e.printStackTrace();
		}
		
	}

	private static void consularPersona(int id) {
		try {
			PersonaDao per = PersonaDaoFactory.create();
			System.out.println(per.selectPersona(id));
		} catch (PersonaDaoException e) {
			e.printStackTrace();
		}
	}

	private static void actualizarPersonas(int id, String nombre, String apellido) {
		Persona p = null;
		try {
			PersonaDao per = PersonaDaoFactory.create();
			p = new Persona();
			p.setNombre(nombre);
			p.setApellido(apellido);
			per.updatePersona(id, p);
		} catch (PersonaDaoException e) {
			e.printStackTrace();
		}
		
	}

	private static void consultarPersonas() {
		
		
		try {
			PersonaDao per = PersonaDaoFactory.create();
			List<Persona> l =per.selectPersonas();
			iteracion(l);
		} catch (PersonaDaoException e) {
			e.printStackTrace();
		}
	}

	private static void nuevaPersona(String nombre, String apellido) {
		Persona p = null;
		
		try {
			PersonaDao per = PersonaDaoFactory.create();
			p = new Persona();
			p.setNombre(nombre);
			p.setApellido(apellido);
			per.insertPersona(p);
		} catch (PersonaDaoException e) {
			e.printStackTrace();
		}
		
	}

	private static void iteracion(List<Persona> l) {
		for(Persona p:l) {
			System.out.println(p);
		}
		
	}

}
