/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Cliente.*;
import Contrato.ContratoPisoImp;
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
public class DAOContratosPisos<Contrato> extends DAO {

    protected static DAO daoContratos;
    private List<Contrato> contratos;

    private DAOContratosPisos() {
        contratos = new ArrayList<>();
        contratos = leer();
    }

    public static DAO getInstance() {
        if (daoContratos == null) {
            daoContratos = new DAOContratosPisos();
        }
        return daoContratos;
    }

    @Override
    public List<Contrato> leer() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("DAO/contratosPisos.txt");// ruta
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] parts = linea.split("\t");
                Cliente clienteAux=new ClienteImp(parts[2], parts[3], parts[4], parts[5]);
                Piso pisoAux= new PisoImp(parseInt(parts[6]), parts[7], parseInt(parts[8]), parseInt((parts[9])), parseInt(parts[10]), parts[11].charAt(0));
                
                Contrato aux = (Contrato) new ContratoPisoImp(parseInt(parts[0]), parts[1],clienteAux,pisoAux);
                contratos.add(aux);
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

        return contratos;

    }

    @Override
    public void escribir(List lista) {
        FileWriter fichero = null;
        try {

            fichero = new FileWriter("DAO/contratosPisos.txt");// home/fernando/Escritorio/IS2_Trabajo_grupo_13/DAO/

            // Escribimos linea a linea en el fichero   
            for (int i = 0; i < lista.size(); i++) {
                ContratoPisoImp aux = (ContratoPisoImp) lista.get(i);
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
        File fichero = new File("contratosPisos.txt");
        boolean done = false;

        if (fichero.delete()) {
            done = true;
        }
        return done;
    }

    public List<Contrato> getLista() {
        return contratos;
    }

}
