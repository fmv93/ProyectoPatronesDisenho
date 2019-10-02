/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contrato;

import Cliente.Cliente;
import Viviendas.*;

/**
 *
 * @author gracus
 */
public class ContratoPisoImp implements ContratoPiso {

    private int idContrato;
    private String fecha;
    private Cliente cliente;
    private Piso piso;


    public ContratoPisoImp(int idContrato, String fecha, Cliente cliente, Piso piso) {
        this.idContrato = idContrato;
        this.fecha = fecha;
        this.cliente = cliente;
        this.piso = piso;
    }

    @Override
    public int getIdContrato() {
        return idContrato;
    }

    @Override
    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    @Override
    public String getFecha() {
        return fecha;
    }

    @Override
    public void setFechaCreacion(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

	@Override
    public Vivienda getPiso() {
        return piso;
    }

 
	@Override
    public void setPiso(Piso piso) {
        this.piso = piso;
    }

    @Override
    public String toString() {
        return "ContratoPisoImp{" + "idContrato=" + idContrato + ", fecha=" + fecha + ", cliente=" + cliente + ", vivienda=" + piso + '}';
    }

    @Override
    public String toFile() {
        return idContrato + "\t" + fecha + "\t" + cliente.toFile()+ "\t" + piso.toFile() ;
    }


}
