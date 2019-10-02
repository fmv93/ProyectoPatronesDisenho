/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Viviendas;

/**
 *
 * @author gracus
 */
public class ViviendaImp implements Vivienda {

    private int precio;
    private String direccion;
    private int numero;
    private int superficie;

    public ViviendaImp(int precio, String direccion, int numero, int superficie) {
        this.precio = precio;
        this.direccion = direccion;
        this.numero = numero;
        this.superficie = superficie;
    }

    @Override
    public int getPrecio() {
        return precio;
    }

    @Override
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public int getNumero() {
        return numero;
    }

    @Override
    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public int getSuperficie() {
        return superficie;
    }

    @Override
    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    @Override
    public String toString() {
        return "ViviendaImp{" + "precio=" + precio + ", direccion=" + direccion + ", número=" + numero + ", superficie=" + superficie + '}';
    }

	@Override
    public String toFile() {
        return precio + "\t" + direccion + "\t" + numero + "\t" + superficie;
    }

}
