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
public class PrimeraLineaPlaya extends ViviendaDecorator{
Vivienda vivienda;
    public PrimeraLineaPlaya(Vivienda vivienda) {
        super(vivienda);
    }

    @Override
    public void setDireccion(String direccion) {
        vivienda.setDireccion(direccion);
        }

    @Override
    public void setNumero(int numero) {
        vivienda.setNumero(numero);
     }

    @Override
    public void setPrecio(int precio) {
       vivienda.setPrecio(precio);
    }

    @Override
    public void setSuperficie(int superficie) {
        vivienda.setSuperficie(superficie);
    }

    @Override
    public String toFile() {
      return  vivienda.toFile().concat(" (vistas al mar)");

  }

    @Override
    public String toString() {
        return vivienda.toString().concat(" (vistas al mar)");
    }

}
