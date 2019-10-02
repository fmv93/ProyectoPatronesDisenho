/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Viviendas.PisoImp;
import java.io.*;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author gracus
 * @param <Piso>
 */
public class DAOPisos<Piso> extends DAO {

	protected static DAO daoPisos;
	private List<Piso> pisos;

	private DAOPisos() {
		this.pisos = new ArrayList<Piso>();
		pisos = leer();
	}

	public static DAO getInstance() {
		if (daoPisos == null) {
			daoPisos = new DAOPisos();
		}
		return daoPisos;
	}

	@Override
	public List<Piso> leer() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File("DAO/pisos.txt");// ruta
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] parts = linea.split("\t");
				Piso Aux = (Piso) new PisoImp(parseInt(parts[0]), parts[1], parseInt(parts[2]), parseInt(parts[3]), parseInt(parts[4]), parts[5].charAt(0));
				pisos.add(Aux);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta 
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		//System.out.println(fr);

		return pisos;

	}

	@Override
	public void escribir(List lista) {
		FileWriter fichero = null;
		try {

			fichero = new FileWriter("DAO/pisos.txt");// home/fernando/Escritorio/IS2_Trabajo_grupo_13/DAO/

			// Escribimos linea a linea en el fichero   
			for (int i = 0; i < lista.size(); i++) {
				PisoImp aux = (PisoImp) lista.get(i);
				String escribir = aux.toFile() + "\n";
				fichero.write(escribir);
			}
			fichero.close();

		} catch (IOException ex) {
			System.out.println("Mensaje de la excepción: " + ex.getMessage());
		}
	}

	@Override
	public boolean borrar() {
		File fichero = new File("pisos.txt");
		boolean done = false;

		if (fichero.delete()) {
			done = true;
		}
		return done;
	}

	public List<Piso> getLista() {
		return pisos;
	}

}
