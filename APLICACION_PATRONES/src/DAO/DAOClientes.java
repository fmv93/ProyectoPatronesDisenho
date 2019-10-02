/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Cliente.ClienteImp;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gracus
 * @param <Cliente>
 */
public class DAOClientes<Cliente> extends DAO {

    protected static DAO daoClientes;
    private List<Cliente> clientes;

    private DAOClientes() {
		clientes = new ArrayList<Cliente>();
        clientes = leer();
    }

    public static DAO getInstance() {
        if (daoClientes == null) {
            daoClientes = new DAOClientes();
        }
        return daoClientes;
    }

    @Override
    public List<Cliente> leer() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("DAO/clientes.txt");// ruta
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] parts = linea.split("\t");
                Cliente ClienteAux = (Cliente) new ClienteImp(parts[0], parts[1], parts[2], parts[3]);
                clientes.add(ClienteAux);
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

        return clientes;

    }

    @Override
    public void escribir(List lista) {
        FileWriter fichero = null;
        try {

            fichero = new FileWriter("DAO/clientes.txt");// home/fernando/Escritorio/IS2_Trabajo_grupo_13/DAO/

            // Escribimos linea a linea en el fichero   
            for (int i = 0; i < lista.size(); i++) {
                ClienteImp aux = (ClienteImp) lista.get(i);
                String escribir = aux.toFile()+"\n";
                fichero.write(escribir);
            }
            fichero.close();

        } catch (IOException ex) {
            System.out.println("Mensaje de la excepción: " + ex.getMessage());
        }
    }

    @Override
    public boolean borrar() {
        File fichero = new File("clientes.txt");
        boolean done = false;

        if (fichero.delete()) {
            done = true;
        }
        return done;
    }
	
	@Override
	public List<Cliente> getLista() {
        return clientes;
    }

}
