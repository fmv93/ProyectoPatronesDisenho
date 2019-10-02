/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inmobiliaria;

import Cliente.*;
import Contrato.*;
import Viviendas.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author gracus
 */
public class GenerateInitValues {

    static List<Vivienda> viviendas = new ArrayList<>();
    static List<Piso> pisos = new ArrayList<>();
    static List<Cliente> clientes = new ArrayList<>();
    static List<ContratoViviendaImp> contratosViviendas = new ArrayList<>();
    static List<ContratoPisoImp> contratosPisos = new ArrayList<>();

    public static void main(String[] args) {

        borrarArchivosActuales();

        viviendas = generarViviendasPruebas();
        pisos = generarPisosPruebas();
        clientes = generarClientesPrueba();
        contratosViviendas = generarContratosViviendaPrueba();
        contratosPisos = generarContratosPisoPrueba();

        System.out.println("VIVIENDAS");
        for (int i = 0; i < viviendas.size(); i++) {
            System.out.println(viviendas.get(i));
        }

        System.out.println("\nPISOS");
        for (int i = 0; i < pisos.size(); i++) {
            System.out.println(pisos.get(i));
        }

        System.out.println("\nCLIENTES");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(clientes.get(i));
        }
        System.out.println("\nCONTRATOSVIVIENDAS");
        for (int i = 0; i < contratosViviendas.size(); i++) {
            System.out.println(contratosViviendas.get(i));
        }
        System.out.println("\nCONTRATOSPISOS");
        for (int i = 0; i < contratosPisos.size(); i++) {
            System.out.println(contratosPisos.get(i));
        }

        generarFicheroViviendas(viviendas);
        generarFicheroPisos(pisos);
        generarFicheroClientes(clientes);
        generarFicheroContratosViviendas(contratosViviendas);
        generarFicheroContratosPisos(contratosPisos);

    }

    public static List<Vivienda> generarViviendasPruebas() {
        Vivienda viviendaPrueba1 = (Vivienda) new ViviendaImp(1000, "direccion1", 1, 100);
        viviendas.add(viviendaPrueba1);
        Vivienda viviendaPrueba2 = (Vivienda) new ViviendaImp(2000, "direccion2", 2, 200);
        viviendas.add(viviendaPrueba2);
        Vivienda viviendaPrueba3 = (Vivienda) new ViviendaImp(3000, "direccion3", 3, 300);
        viviendas.add(viviendaPrueba3);
        Vivienda viviendaPrueba4 = (Vivienda) new ViviendaImp(4000, "direccion4", 4, 400);
        viviendas.add(viviendaPrueba4);
        Vivienda viviendaPrueba5 = (Vivienda) new ViviendaImp(5000, "direccion5", 5, 500);
        viviendas.add(viviendaPrueba5);
        return viviendas;
    }

    public static List<Piso> generarPisosPruebas() {
        Piso piso1 = (Piso) new PisoImp(1000, "calle1", 1, 1000, 1, 'a');
        pisos.add(piso1);
        Piso piso2 = (Piso) new PisoImp(2000, "calle2", 1, 1000, 1, 'b');
        pisos.add(piso2);
        Piso piso3 = (Piso) new PisoImp(3000, "calle2", 1, 1000, 1, 'b');
        pisos.add(piso3);
        Piso piso4 = (Piso) new PisoImp(4000, "calle3", 1, 1000, 1, 'b');
        pisos.add(piso4);
        Piso piso5 = (Piso) new PisoImp(5000, "calle4", 1, 1000, 1, 'b');
        pisos.add(piso5);
        Piso piso6 = (Piso) new PisoImp(6000, "calle4", 4, 1000, 2, 'b');
        pisos.add(piso6);
        return pisos;
    }

    public static List<Cliente> generarClientesPrueba() {
        Cliente clientePrueba1 = (Cliente) new ClienteImp("nombre1", "apellidos1", "dni1", "email1");
        clientes.add(clientePrueba1);
        Cliente clientePrueba2 = (Cliente) new ClienteImp("nombre2", "apellidos2", "dni2", "email2");
        clientes.add(clientePrueba2);
        Cliente clientePrueba3 = (Cliente) new ClienteImp("nombre3", "apellidos3", "dni3", "email3");
        clientes.add(clientePrueba3);
        return clientes;
    }

    public static List<ContratoViviendaImp> generarContratosViviendaPrueba() {
        ContratoVivienda contrato1 = (ContratoViviendaImp) new ContratoViviendaImp(0, "01-ene-2018 01:01:01", clientes.get(1), viviendas.get(0));
        contratosViviendas.add((ContratoViviendaImp) contrato1);
        ContratoVivienda contrato2 = (ContratoViviendaImp) new ContratoViviendaImp(1, "02-feb-2018 02:02:02", clientes.get(1), viviendas.get(1));
        contratosViviendas.add((ContratoViviendaImp) contrato2);
        ContratoVivienda contrato3 = (ContratoViviendaImp) new ContratoViviendaImp(2, "03-mar-2018 03:03:03", clientes.get(2), viviendas.get(2));
        contratosViviendas.add((ContratoViviendaImp) contrato3);
        return contratosViviendas;
    }

    public static List<ContratoPisoImp> generarContratosPisoPrueba() {
        ContratoPiso contrato1 = (ContratoPisoImp) new ContratoPisoImp(0, "04-abr-2018 04:04:04", clientes.get(2), pisos.get(0));
        contratosPisos.add((ContratoPisoImp) contrato1);
        ContratoPiso contrato2 = (ContratoPisoImp) new ContratoPisoImp(0, "05-may-2018 05:05:05", clientes.get(1), pisos.get(1));
        contratosPisos.add((ContratoPisoImp) contrato2);
        ContratoPiso contrato3 = (ContratoPisoImp) new ContratoPisoImp(0, "06-jun-2018 06:06:06", clientes.get(1), pisos.get(2));
        contratosPisos.add((ContratoPisoImp) contrato3);
        return contratosPisos;
    }

    private static boolean borrarArchivosActuales() {

        int i = 0;
        boolean borradoCorrecto = false;
        File ficheroBorrar;

        for (int j = 0; j < 4; j++) {
            switch (i) {
                case 0: //Borra archivo viviendas.
                    ficheroBorrar = new File("DAO/viviendas.txt");
                    borradoCorrecto &= ficheroBorrar.delete();
                    break;
                case 1: //Borra archivo pisos.
                    ficheroBorrar = new File("DAO/pisos.txt");
                    borradoCorrecto &= ficheroBorrar.delete();
                    break;
                case 2: //Borra archivo clientes.
                    ficheroBorrar = new File("DAO/clientes.txt");
                    borradoCorrecto &= ficheroBorrar.delete();
                    break;
                case 3: //Borra archivo contratos.
                    ficheroBorrar = new File("DAO/contratosPisos.txt");
                    borradoCorrecto &= ficheroBorrar.delete();
                    ficheroBorrar = new File("DAO/contratosViviendas.txt");
                    borradoCorrecto &= ficheroBorrar.delete();
                    break;
            }

        }
        return borradoCorrecto;
    }

    private static void generarFicheroViviendas(List<Vivienda> viviendas) {
        FileWriter fichero = null;
        try {

            fichero = new FileWriter("DAO/viviendas.txt"); // cambiar nombre a posteriori de momento prueba 

            // Escribimos linea a linea en el fichero   
            for (int i = 0; i < viviendas.size(); i++) {
                ViviendaImp aux = (ViviendaImp) viviendas.get(i);
                String escribir = aux.toFile() + "\n";
                fichero.write(escribir);
            }
            fichero.close();

        } catch (IOException ex) {
            System.out.println("Mensaje de la excepción: " + ex.getMessage());
        }
    }

    private static void generarFicheroClientes(List<Cliente> clientes) {
        FileWriter fichero = null;
        try {

            fichero = new FileWriter("DAO/clientes.txt"); // cambiar nombre a posteriori de momento prueba 

            // Escribimos linea a linea en el fichero   
            for (int i = 0; i < clientes.size(); i++) {
                ClienteImp aux = (ClienteImp) clientes.get(i);
                String escribir = aux.toFile() + "\n";
                fichero.write(escribir);
            }
            fichero.close();

        } catch (IOException ex) {
            System.out.println("Mensaje de la excepción: " + ex.getMessage());
        }
    }

    private static void generarFicheroPisos(List<Piso> pisos) {
        FileWriter fichero = null;
        try {

            fichero = new FileWriter("DAO/pisos.txt"); // cambiar nombre a posteriori de momento prueba 

            // Escribimos linea a linea en el fichero   
            for (int i = 0; i < pisos.size(); i++) {
                PisoImp aux = (PisoImp) pisos.get(i);
                String escribir = aux.toFile() + "\n";
                fichero.write(escribir);
            }
            fichero.close();

        } catch (IOException ex) {
            System.out.println("Mensaje de la excepción: " + ex.getMessage());
        }
    }

    private static void generarFicheroContratosViviendas(List<ContratoViviendaImp> contratos) {
        FileWriter fichero = null;
        try {

            fichero = new FileWriter("DAO/contratosViviendas.txt"); // cambiar nombre a posteriori de momento prueba 

            // Escribimos linea a linea en el fichero   
            for (int i = 0; i < contratos.size(); i++) {
                ContratoViviendaImp aux = (ContratoViviendaImp) contratos.get(i);
                String escribir = aux.toFile() + "\n";
                fichero.write(escribir);
            }
            fichero.close();

        } catch (IOException ex) {
            System.out.println("Mensaje de la excepción: " + ex.getMessage());
        }
    }

    private static void generarFicheroContratosPisos(List<ContratoPisoImp> contratos) {
        FileWriter fichero = null;
        try {

            fichero = new FileWriter("DAO/contratosPisos.txt"); // cambiar nombre a posteriori de momento prueba 

            // Escribimos linea a linea en el fichero   
            for (int i = 0; i < contratos.size(); i++) {
                ContratoPisoImp aux = (ContratoPisoImp) contratos.get(i);
                String escribir = aux.toFile() + "\n";
                fichero.write(escribir);
            }
            fichero.close();

        } catch (IOException ex) {
            System.out.println("Mensaje de la excepción: " + ex.getMessage());
        }
    }
}