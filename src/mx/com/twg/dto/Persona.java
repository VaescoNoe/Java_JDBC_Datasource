
package mx.com.twg.dto;

import java.io.Serializable;

public class Persona implements Serializable
{
	
	private int idPersona;
	private String nombre;
	private String apellido;
	
	public Persona(){
	}

	public int getIdPersona(){
		return idPersona;
	}

	public void setIdPersona(int idPersona){
		this.idPersona = idPersona;
	}

	public String getNombre(){
		return nombre;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public String getApellido(){
		return apellido;
	}

	public void setApellido(String apellido){
		this.apellido = apellido;
	}

	public String toString()
	{
		return"idPersona=" + idPersona+", nombre=" + nombre+", apellido=" + apellido;
	}

}
