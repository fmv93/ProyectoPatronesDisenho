/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contrato;

import Cliente.Cliente;
import Viviendas.Piso;
import Viviendas.Vivienda;

/**
 *
 * @author gracus
 */
public interface ContratoPiso {

	Cliente getCliente();

	String getFecha();

	int getIdContrato();

	Vivienda getPiso();

	void setCliente(Cliente cliente);

	void setFechaCreacion(String fecha);

	void setIdContrato(int idContrato);

	void setPiso(Piso piso);

	String toFile();

	String toString();
	
}
