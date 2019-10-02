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
public interface Cliente { //En el patrón observador, hace la función de observador
	
	String getApellidos();

	String getDni();

	String getEmail();

	String getNombre();

	void setApellidos(String apellidos);

	void setDni(String dni);

	void setEmail(String email);

	void setNombre(String nombre);

	String toString();
	
	String toFile();
	
	boolean update(Vivienda vivienda);
	
}
