/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inmobiliaria;

import Cliente.Cliente;
import Cliente.ClienteImp;
import Viviendas.*;
import Contrato.*;
import Factorias.Constructora;
import Factorias.FactoriaDAO;
import Memento.Memento;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author gracus
 */
public class InmobiliariaImp implements Inmobiliaria {

	private FactoriaDAO factDAO;
	private Constructora constructora;
	private Memento copia = new Memento();

	Scanner entrada = new Scanner(System.in);

	private List<Vivienda> viviendas = new ArrayList<Vivienda>();
	private List<Piso> pisos = new ArrayList<Piso>();
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private List<ContratoVivienda> contratosViviendas = new ArrayList<ContratoVivienda>();
	private List<ContratoPiso> contratosPisos = new ArrayList<ContratoPiso>();

	public InmobiliariaImp() {
		this.factDAO = new FactoriaDAO();
	}

	@Override
	public boolean altaCliente() {
		String nombre;
		String apellidos;
		String dni;
		String email;
		System.out.print("Nombre: ");
		nombre = entrada.nextLine();
		System.out.print("Apellidos: ");
		apellidos = entrada.nextLine();
		System.out.print("DNI: ");
		dni = entrada.nextLine();
		System.out.print("e-mail: ");
		email = entrada.nextLine();
		Cliente c = (Cliente) new ClienteImp(nombre, apellidos, dni, email);
		//System.out.println("\n" + c.toString() + "\n"); // Comprobacion de los datos del cliente creado.
		return clientes.add(c);
	}

	@Override
	public void listarClientes() {
		for (int i = 0; i < clientes.size(); i++) {
			System.out.println(i + ".- " + clientes.get(i));
		}
	}

	@Override
	public void listarViviendas() {
		for (int i = 0; i < viviendas.size(); i++) {
			System.out.println(i + ".- " + viviendas.get(i));
		}
	}

	@Override
	public boolean venderVivienda() {
		int numCliente, numVivienda;
		Date fecha= new Date();
		
		listarClientes();
		System.out.print("Introducir número cliente: ");
		numCliente = entrada.nextInt();
		System.out.println("");
		listarViviendas();
		System.out.print("Introducir número vivienda: ");
		numVivienda = entrada.nextInt();
		System.out.println("");
		ContratoVivienda c = new ContratoViviendaImp(contratosViviendas.size() + 1, fecha.toLocaleString(), clientes.get(numCliente), viviendas.get(numVivienda));
		return contratosViviendas.add(c);
	}

	@Override
	public boolean venderPiso() {
		int numCliente, numPiso;
		Date fecha= new Date();
		listarClientes();
		System.out.print("Introducir número cliente: ");
		numCliente = entrada.nextInt();
		System.out.println("");
		listarPisos();
		System.out.print("Introducir número piso: ");
		numPiso = entrada.nextInt();
		System.out.println("");
		ContratoPiso c = new ContratoPisoImp(contratosPisos.size() + 1, fecha.toLocaleString(), clientes.get(numCliente), pisos.get(numPiso));
		return contratosPisos.add(c);

	}

	@Override
	public void listarContratosViviendas() {
		for (int i = 0; i < contratosViviendas.size(); i++) {
			System.out.println(i + ".- " + contratosViviendas.get(i));
		}
	}

	@Override
	public void listarContratosPisos() {
		for (int i = 0; i < contratosPisos.size(); i++) {
			System.out.println(i + ".- " + contratosPisos.get(i));
		}
	}

	@Override
	public boolean notifyObserver(Vivienda vivienda) {
		boolean result = true;
		for (Cliente cliente : clientes) {
			result &= cliente.update(vivienda);
		}
		return result;
	}

	@Override
	public boolean cargarDAOViviendas() {
		factDAO.getDaoViviendas();
		return viviendas.addAll(factDAO.getListaViviendas());
	}

	@Override
	public boolean cargarDAOPisos() {
		factDAO.getDaoPisos();
		return pisos.addAll(factDAO.getListaPisos());
	}

	@Override
	public boolean cargarDAOClientes() {
		factDAO.getDaoClientes();
		return clientes.addAll(factDAO.getListaClientes());
	}

	@Override
	public boolean cargarDAOContratosViviendas() {
		factDAO.getDaoContratosViviendas();
		return contratosViviendas.addAll(factDAO.getListaContratosViviendas());
	}

	@Override
	public boolean cargarDAOContratosPisos() {
		factDAO.getDaoContratosPisos();
		return contratosPisos.addAll(factDAO.getListaContratosPisos());
	}

	@Override
	public void listarPisos() {
		for (int i = 0; i < pisos.size(); i++) {
			System.out.println(pisos.get(i));
		}
	}

	@Override
	public boolean crearViviendas() {
		List<Vivienda> newViviendas;

		this.constructora = Constructora.getInstance();
		newViviendas = this.constructora.construirViviendas();
		for (int i = 0; i < newViviendas.size(); i++) {
			notifyObserver(newViviendas.get(i));
		}
		return viviendas.addAll(newViviendas);
	}

	@Override
	public boolean crearPisos() {
		List<Piso> newPisos;

		this.constructora = Constructora.getInstance();
		newPisos = this.constructora.construirPisos();
		for (int i = 0; i < newPisos.size(); i++) {
			notifyObserver(newPisos.get(i));
		}
		return pisos.addAll(newPisos);
	}

    @Override
    public boolean crearCopia() {
        List<Vivienda> viviendasCopy = new ArrayList<>();
        List<Piso> pisosCopy = new ArrayList<>();
        List<Cliente> clientesCopy = new ArrayList<>();
        List<ContratoVivienda> contratosViviendasCopy = new ArrayList<>();
        List<ContratoPiso> contratosPisosCopy = new ArrayList<>();
        viviendasCopy=viviendas;
        pisosCopy=pisos;
        clientesCopy=clientes;
        contratosViviendasCopy=contratosViviendas;
        contratosPisosCopy=contratosPisos;
        copia.setViviendas(viviendasCopy);
        copia.setPisos(pisosCopy);
        copia.setClientes(clientesCopy);
        copia.setContratosVivienda(contratosViviendasCopy);
        copia.setContratosPisos(contratosPisosCopy);
        return true;
    }

    @Override
    public boolean restaurarCopia() {       
        boolean respuesta=false;
        
        if (copia==null){ 
            System.out.println("\tNO HAY NINGUNA COPIA DE SEGURIDAD");
        }
        else{
            viviendas=copia.getViviendas();
            pisos=copia.getPisos();
            clientes=copia.getClientes();
            contratosViviendas=copia.getContratosVivienda();
            contratosPisos=copia.getContratosPisos();
            respuesta=true;
        }
       
       return respuesta;
    }
    

    @Override
    public boolean guardarArchivos() {
   factDAO.guardarArchivo(viviendas, pisos, clientes, contratosPisos, contratosViviendas);
   return true;
    }
}
