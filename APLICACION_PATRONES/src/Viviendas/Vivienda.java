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
public interface Vivienda {

    String getDireccion();

    int getNumero();

    int getPrecio();

    int getSuperficie();

    void setDireccion(String direccion);

    void setNumero(int numero);

    void setPrecio(int precio);

    void setSuperficie(int superficie);

    String toString();

    public String toFile();

}
