/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factorias;

import Cliente.*;
import DAO.*;
import Viviendas.*;
import java.util.List;
import Contrato.*;

/**
 *
 * @author gracus
 */
public class FactoriaDAO {

	private DAO daoViviendas;
	private DAO daoPisos;
	private DAO daoClientes;
	private DAO daoContratosViviendas;
	private DAO daoContratosPisos;

	public FactoriaDAO() {
	}

	public DAO getDaoViviendas() {
		return this.daoViviendas = DAOViviendas.getInstance();
	}

	public DAO getDaoPisos() {
		return this.daoPisos = DAOPisos.getInstance();
	}

	public DAO getDaoClientes() {
		return this.daoClientes = DAOClientes.getInstance();
	}

	public DAO getDaoContratosViviendas() {
		return this.daoContratosViviendas = DAOContratosViviendas.getInstance();
	}
	
	public DAO getDaoContratosPisos() {
		return this.daoContratosPisos = DAOContratosPisos.getInstance();
	}

	public List<Vivienda> getListaViviendas() {
		return daoViviendas.getLista();
	}

	public List<Piso> getListaPisos() {
		return daoPisos.getLista();
	}

	public List<Cliente> getListaClientes() {
		return daoClientes.getLista();
	}

	public List<ContratoVivienda> getListaContratosViviendas() {
		return daoContratosViviendas.getLista();
	}
	
	public List<ContratoPiso> getListaContratosPisos() {
		return daoContratosPisos.getLista();
	}
                        
                public boolean guardarArchivo(List viviendas,List pisos, List clientes,List ContratosPisos,List ContratosViviendas){
                    daoViviendas.escribir(viviendas);
                    daoPisos.escribir(pisos);
                    daoClientes.escribir(clientes);
                    daoContratosViviendas.escribir(ContratosViviendas);
                    daoContratosPisos.escribir(ContratosPisos);
                    return true;
                }

}
