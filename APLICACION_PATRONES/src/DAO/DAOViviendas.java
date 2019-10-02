/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Viviendas.ViviendaImp;
import java.io.*;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gracus
 * @param <Vivienda>
 */
public class DAOViviendas<Vivienda> extends DAO {

	protected static DAO daoViviendas;
	private List<Vivienda> viviendas;

	private DAOViviendas() {
		viviendas =	new ArrayList<>();
		viviendas = leer();
	}


	public static DAO getInstance() {
		if (daoViviendas == null) {
			daoViviendas = new DAOViviendas();
		}
		return daoViviendas;
	}

	@Override
	public List<Vivienda> leer() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("DAO/viviendas.txt");// ruta
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] parts = linea.split("\t");
                Vivienda Aux = (Vivienda) new ViviendaImp(parseInt(parts[0]), parts[1], parseInt(parts[2]), parseInt(parts[3]));
                viviendas.add(Aux);
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

        return viviendas;

	}

	@Override
	public void escribir(List lista) {
		FileWriter fichero = null;
		try {

			fichero = new FileWriter("DAO/viviendas.txt");// home/fernando/Escritorio/IS2_Trabajo_grupo_13/DAO/

			// Escribimos linea a linea en el fichero   
			for (int i = 0; i < lista.size(); i++) {
				ViviendaImp aux = (ViviendaImp) lista.get(i);
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
		File fichero = new File("viviendas.txt");
		boolean done = false;

		if (fichero.delete()) {
			done = true;
		}
		return done;
	}

	public List<Vivienda> getLista() {
		return viviendas;
	}

}
