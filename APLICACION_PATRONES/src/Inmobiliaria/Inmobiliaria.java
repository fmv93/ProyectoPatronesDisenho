/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inmobiliaria;

import Viviendas.Vivienda;

/**
 *
 * @author gracus
 */
public interface Inmobiliaria { //En el patrón Observador, hace la función de sujeto

	public boolean altaCliente();

	public void listarClientes();

	public boolean crearViviendas();

	public void listarViviendas();

	public boolean venderVivienda();
	
	public boolean venderPiso();

	public void listarContratosViviendas() ;
	
	public void listarContratosPisos();

	public boolean notifyObserver(Vivienda vivienda);

	public boolean cargarDAOViviendas();

	public boolean cargarDAOPisos();

	public boolean cargarDAOClientes();

	public void listarPisos();

	public boolean crearPisos();

	public boolean cargarDAOContratosViviendas();
	
	public boolean cargarDAOContratosPisos();
                
                public boolean crearCopia();
                
                public boolean restaurarCopia();
                
                public boolean guardarArchivos();
                

}
