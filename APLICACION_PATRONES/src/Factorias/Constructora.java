/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factorias;

import Viviendas.Piso;
import Viviendas.PisoImp;
import Viviendas.Vivienda;
import Viviendas.ViviendaImp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author gracus
 */
public class Constructora {

	public static Constructora constructora = null;
	Scanner entrada = new Scanner(System.in);
	private List<Vivienda> newViviendas;
	private List<Piso> newPisos;

	private Constructora() {
		this.newViviendas = new ArrayList<Vivienda>();
		this.newPisos = new ArrayList<Piso>();
	}

	// Patrón Singleton. Para instanciar una factoria, llamar este metodo.
	public static Constructora getInstance() {
		if (constructora == null) {
			constructora = new Constructora();
		}
		return constructora;
	}

	public List<Vivienda> getNewViviendas() {
		return newViviendas;
	}

	public List<Piso> getNewPisos() {
		return newPisos;
	}

	public List<Vivienda> construirViviendas() {
		int precio;
		String direccion;
		int numeroInicio, numeroFin;
		int superficie;

		System.out.print("Introducir dirección: ");
		direccion = entrada.nextLine();
		System.out.print("Introducir numero inicio: ");
		numeroInicio = entrada.nextInt();
		System.out.print("Introducir numero fin: ");
		numeroFin = entrada.nextInt();
		System.out.print("Introducir superficie: ");
		superficie = entrada.nextInt();
		System.out.print("Introducir precio de venta: ");
		precio = entrada.nextInt();

		for (int i = numeroInicio; i <= numeroFin; i++) {
			Vivienda v = (Vivienda) new ViviendaImp(precio, direccion, i, superficie);
			newViviendas.add(v);
		}
		return newViviendas;
	}

	public List<Piso> construirPisos() {
		int precio;
		String direccion;
		int numeroInicio, numeroFin;
		int superficie;
		int numPlantas;
		//char puerta;

		System.out.print("Introducir dirección: ");
		direccion = entrada.nextLine();
		System.out.print("Introducir número inicio: ");
		numeroInicio = entrada.nextInt();
		System.out.print("Introducir número fin: ");
		numeroFin = entrada.nextInt();
		System.out.print("Introducir superficie: ");
		superficie = entrada.nextInt();
		System.out.print("Introducir precio de venta: ");
		precio = entrada.nextInt();
		System.out.print("Introducir plantas: ");
		numPlantas = entrada.nextInt();

		for (int i = numeroInicio; i <= numeroFin; i++) {
			for (int planta = 0; planta <= numPlantas; planta++) {
				Piso pa = new PisoImp(precio, direccion, i, superficie, planta, 'a');
				newPisos.add(pa);
				Piso pb = new PisoImp(precio, direccion, i, superficie, planta, 'b');
				newPisos.add(pb);
			}
		}
		return newPisos;
	}
}
