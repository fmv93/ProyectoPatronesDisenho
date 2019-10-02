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
public interface Piso extends Vivienda {
	 
	int getPlanta();

	char getPuerta();

	void setPlanta(int planta);

	void setPuerta(char puerta);
        

	String toString();
                        public String toFile();
}
