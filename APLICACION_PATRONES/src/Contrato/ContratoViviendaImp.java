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
public class ContratoViviendaImp implements ContratoVivienda{

    private int idContrato;
    private String fecha;
    private Cliente cliente;
    private Vivienda vivienda;


    public ContratoViviendaImp(int idContrato, String fecha, Cliente cliente, Vivienda vivienda) {
        this.idContrato = idContrato;
        this.fecha = fecha;
        this.cliente = cliente;
        this.vivienda = vivienda;
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
    public Vivienda getVivienda() {
        return vivienda;
    }


	@Override
    public void setVivienda(Vivienda vivienda) {
        this.vivienda = vivienda;
    }

    @Override
    public String toString() {
        return "ContratoViviendaImp{" + "idContrato=" + idContrato + ", fecha=" + fecha + ", cliente=" + cliente + ", vivienda=" + vivienda + '}';
    }

    @Override
    public String toFile() {
        return idContrato + "\t" + fecha + "\t" + cliente.toFile()+ "\t" + vivienda.toFile() ;
    }
}
