/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Memento;
import Cliente.Cliente;
import Contrato.*;
import Viviendas.*;
import java.util.*;
/**
 *
 * @author fernando
 */
public class Memento {
    private List<Cliente> clientes = new ArrayList<>();
    private List<ContratoVivienda> contratosVivienda = new ArrayList<>(); 
	private List<ContratoPiso> contratosPisos = new ArrayList<>();
    private List<Vivienda> viviendas = new ArrayList<>();
    private List<Piso> pisos = new ArrayList<>();

    public Memento() {
    }
	
    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<ContratoPiso> getContratosPisos() {
        return contratosPisos;
    }

    public void setContratosPisos(List<ContratoPiso> contratosPisos) {
        this.contratosPisos = contratosPisos;
    }

    public List<ContratoVivienda> getContratosVivienda() {
        return contratosVivienda;
    }

    public void setContratosVivienda(List<ContratoVivienda> contratosVivienda) {
        this.contratosVivienda = contratosVivienda;
    }

    public List<Vivienda> getViviendas() {
        return viviendas;
    }

    public void setViviendas(List<Vivienda> viviendas) {
        this.viviendas = viviendas;
    }

    public List<Piso> getPisos() {
        return pisos;
    }

    public void setPisos(List<Piso> pisos) {
        this.pisos = pisos;
    }

}