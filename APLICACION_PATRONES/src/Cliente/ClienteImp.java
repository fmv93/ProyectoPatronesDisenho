/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Viviendas.Vivienda;

/**
 *
 * @author gracus
 */
public class ClienteImp implements Cliente {

	private String nombre;
	private String apellidos;
	private String dni;
	private String email;

	public ClienteImp(String nombre, String apellidos, String dni, String email) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.email = email;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String getApellidos() {
		return apellidos;
	}

	@Override
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Override
	public String getDni() {
		return dni;
	}

	@Override
	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ClienteImp{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", email=" + email + '}';
	}

	@Override
	public String toFile() {
		return nombre + "\t" + apellidos + "\t" + dni + "\t" + email;
	}
	
	@Override
	public boolean update(Vivienda vivienda){
		System.out.println("Se ha enviado la información de la vivienda " + vivienda.toString() + " al correo " + email);	
		return true;
	}
}
