/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Viviendas;

/**
 *
 * @author Fernando
 */
public abstract class ViviendaDecorator implements Vivienda {

    private Vivienda vivienda;

    public ViviendaDecorator(Vivienda vivienda) {

        this.vivienda = vivienda;

    }

    public Vivienda getVivienda() {

        return this.vivienda;

    }

    public void setVivienda(Vivienda vivienda) {
        this.vivienda = vivienda;
    }

    @Override
    public int getPrecio() {
        return vivienda.getPrecio();
    }

    @Override
    public String getDireccion() {
        return vivienda.getDireccion();
    }

    @Override
    public int getNumero() {
        return vivienda.getNumero();
    }

    @Override
    public int getSuperficie() {
        return vivienda.getSuperficie();
    }

}
