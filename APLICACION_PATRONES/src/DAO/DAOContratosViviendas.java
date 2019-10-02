/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Cliente.*;
import Contrato.ContratoVivienda;
import Contrato.ContratoViviendaImp;
import Viviendas.*;
import java.io.*;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gracus
 */
public class DAOContratosViviendas<Contrato> extends DAO {

    protected static DAO daoContratos;
    private List<ContratoVivienda> contratosViviendas;

    private DAOContratosViviendas() {
        contratosViviendas = new ArrayList<>();
        contratosViviendas = leer();
    }

    public static DAO getInstance() {
        if (daoContratos == null) {
            daoContratos = new DAOContratosViviendas();
        }
        return daoContratos;
    }

    @Override
    public List<ContratoVivienda> leer() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("DAO/contratosViviendas.txt");// ruta
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] parts = linea.split("\t");
                Cliente clienteAux=new ClienteImp(parts[2], parts[3], parts[4], parts[5]);
                Vivienda viviendaAux= new ViviendaImp(parseInt(parts[6]), parts[7], parseInt(parts[8]), parseInt(parts[9]));
                ContratoVivienda aux = (ContratoVivienda) new ContratoViviendaImp(parseInt(parts[0]), parts[1],clienteAux,viviendaAux);
                contratosViviendas.add(aux);
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

        return contratosViviendas;

    }

    @Override
    public void escribir(List lista) {
        FileWriter fichero = null;
        try {

            fichero = new FileWriter("DAO/contratosViviendas.txt");// home/fernando/Escritorio/IS2_Trabajo_grupo_13/DAO/

            // Escribimos linea a linea en el fichero   
            for (int i = 0; i < lista.size(); i++) {
                ContratoViviendaImp aux = (ContratoViviendaImp) lista.get(i);
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
        File fichero = new File("contratosViviendas.txt");
        boolean done = false;

        if (fichero.delete()) {
            done = true;
        }
        return done;
    }

    public List<ContratoVivienda> getLista() {
        return contratosViviendas;
    }

}
