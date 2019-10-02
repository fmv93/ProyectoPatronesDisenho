/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contrato;

import Cliente.Cliente;
import Viviendas.Vivienda;

/**
 *
 * @author gracus
 */
public interface ContratoVivienda {

	Cliente getCliente();

	String getFecha();

	int getIdContrato();

	Vivienda getVivienda();

	void setCliente(Cliente cliente);

	void setFechaCreacion(String fecha);

	void setIdContrato(int idContrato);

	void setVivienda(Vivienda vivienda);

	String toFile();

	String toString();
	
}
