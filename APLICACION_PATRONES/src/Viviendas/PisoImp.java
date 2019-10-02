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
public class PisoImp extends ViviendaImp implements Piso {

	private int planta;
	private char puerta;

	public PisoImp(int precio, String direccion, int numero, int superficie, int planta, char puerta) {
		super(precio, direccion, numero, superficie);
		this.planta = planta;
		this.puerta = puerta;
	}

	@Override
	public int getPlanta() {
		return planta;
	}

	@Override
	public void setPlanta(int planta) {
		this.planta = planta;
	}

	@Override
	public char getPuerta() {
		return puerta;
	}

	@Override
	public void setPuerta(char puerta) {
		this.puerta = puerta;
	}

	@Override
	public String toString() {
		return "PisoImp{" + super.toString() + "planta=" + planta + ", puerta=" + puerta + '}';
	}

	@Override
	public String toFile() {
		return super.toFile() + "\t" + planta + "\t" + puerta;
	}
}
