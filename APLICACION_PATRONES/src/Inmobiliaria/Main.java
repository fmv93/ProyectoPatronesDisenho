/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inmobiliaria;

import java.util.*;

/**
 *
 * @author gracus
 */
public class Main {

	public static void main(String[] args) {

		Inmobiliaria inmobiliaria = new InmobiliariaImp();
		menu(inmobiliaria);

	}

	//PATRONES DELEGATE y FACTORIA ABSTRACTA
	public static void menu(Inmobiliaria inmobiliaria) {
		int opcion = -1;
		while (opcion != 0) {

			Scanner entrada = new Scanner(System.in);
			System.out.print(""
					+ "====================\n"
					+ "---MENÚ PRINCIPAL---\n"
					+ "====================\n"
					+ "1. VIVIENDAS.\n"
					+ "2. CLIENTES.\n"
					+ "3. GESTIÓN.\n"
					+ "4. COPIA DE SEGURIDAD.\n"
					+ "0. SALIR.\n"
					+ "====================\n"
					+ "INTRODUZCA OPCIÓN: ");
			opcion = entrada.nextInt();

			switch (opcion) {

				case 1: //Acceso al menú perteneciente a las viviendas.
					System.out.println("");
					submenuViviendas(inmobiliaria);
					break;

				case 2: //Acceso al menú perteneciente a las clientes.	
					System.out.println("");
					submenuClientes(inmobiliaria);
					break;

				case 3: //Acceso al menú perteneciente a la gestión inmobiliaria.
					System.out.println("");
					submenuGestion(inmobiliaria);
					break;
				case 4: //Acceso al menú perteneciente a la creación y restauración.
					System.out.println("");
					submenuCopiaSeguridad(inmobiliaria);
					break;

				case 0: //Salir del menú
					opcion = 0;
					break;
			}
		}
	}

	private static void submenuViviendas(Inmobiliaria inmobiliaria) {
		int opcion = -1;
		while (opcion != 0) {

			Scanner entrada = new Scanner(System.in);
			System.out.print(""
					+ "\t====================\n"
					+ "\t---MENÚ VIVIENDAS---\n"
					+ "\t====================\n"
					+ "\t1. CREAR VIVIENDA.\n"
					+ "\t2. LISTAR VIVIENDA.\n"
					+ "\t3. CARGAR VIVIENDA.\n"
					+ "\t4. CREAR PISO.\n"
					+ "\t5. LISTAR PISOS.\n"
					+ "\t6. CARGAR PISOS.\n"
					+ "\t0. VOLVER.\n"
					+ "\t====================\n"
					+ "\tINTRODUZCA OPCIÓN: ");
			opcion = entrada.nextInt();
			System.out.println("");

			switch (opcion) {

				case 1: //Crear nueva vivienda y añadirla a la lista.
					System.out.println("\tCREANDO VIVIENDAS...\n");
					inmobiliaria.crearViviendas();
					System.out.println("");
					break;

				case 2: //Mostrar viviendas.
					System.out.println("\tLISTANDO VIVIENDAS...\n");
					inmobiliaria.listarViviendas();
					System.out.println("");
					break;

				case 3: //Cargar viviendas desde el DAO.
					System.out.println("\tCARGANDO VIVIENDAS...\n");
					inmobiliaria.cargarDAOViviendas();
					System.out.println("");
					break;

				case 4: //Crear nuevo piso y añadirlo a la lista.
					System.out.println("\tCREANDO PISOS...\n");
					inmobiliaria.crearPisos();
					System.out.println("");
					break;

				case 5: //Mostrar pisos.
					System.out.println("\tLISTANDO PISOS...\n");
					inmobiliaria.listarPisos();
					System.out.println("");
					break;

				case 6: //Cargar pisos desde el DAO.
					System.out.println("\tCARGANDO PISOS...\n");
					inmobiliaria.cargarDAOPisos();
					System.out.println("");
					break;

				case 0: //Volver al menú principal.
					System.out.println("");
					opcion = 0;
					break;
			}
		}

	}

	private static void submenuClientes(Inmobiliaria inmobiliaria) {
		int opcion = -1;
		while (opcion != 0) {

			Scanner entrada = new Scanner(System.in);
			System.out.print(""
					+ "\t====================\n"
					+ "\t---MENÚ CONTRATOS---\n"
					+ "\t====================\n"
					+ "\t1. CREAR CLIENTES.\n"
					+ "\t2. LISTAR CLIENTES.\n"
					+ "\t3. CARGAR CLIENTES.\n"
					+ "\t0. VOLVER.\n"
					+ "\t====================\n"
					+ "\tINTRODUZCA OPCIÓN: ");
			opcion = entrada.nextInt();
			System.out.println("");

			switch (opcion) {

				case 1: //Crear nuevo cliente y añadirlo a la lista.
					System.out.println("\tCREANDO CLIENTE...\n");
					inmobiliaria.altaCliente();
					break;

				case 2: //Mostrar clientes.
					System.out.println("\tLISTANDO CLIENTES...\n");
					inmobiliaria.listarClientes();
					System.out.println("");
					break;

				case 3: //Cargar clientes desde el DAO.
					System.out.println("\tCARGANDO CLIENTES...\n");
					inmobiliaria.cargarDAOClientes();
					System.out.println("");
					break;

				case 0: //Volver al menú principal.
					System.out.println("");
					opcion = 0;
					break;
			}
		}
	}

	private static void submenuGestion(Inmobiliaria inmobiliaria) {
		int opcion = -1;
		while (opcion != 0) {

			Scanner entrada = new Scanner(System.in);
			System.out.print(""
					+ "\t====================\n"
					+ "\t----MENÚ GESTIÓN----\n"
					+ "\t====================\n"
					+ "\t1. VENDER VIVIENDA.\n"
					+ "\t2. LISTAR CONTRATOS VENTA VIVIENDAS.\n"
					+ "\t3. CARGAR CONTRATOS VIVIENDAS.\n"
					+ "\t4. VENDER PISO.\n"
					+ "\t5. LISTAR CONTRATOS VENTA PISOS.\n"
					+ "\t6. CARGAR CONTRATOS PISOS.\n"
					+ "\t0. VOLVER.\n"
					+ "\t====================\n"
					+ "\tINTRODUZCA OPCIÓN: ");
			opcion = entrada.nextInt();
			System.out.println("");

			switch (opcion) {

				case 1: //Vender una vivienda. ( Crea un contrato que asocia un cliente con una vivienda) 
					System.out.println("\tVENDIENDO VIVIENDA...\n");
					inmobiliaria.venderVivienda();
					break;

				case 2: //Mostrar contratos viviendas.
					System.out.println("\tLISTANDO CONTRATOS VENTA VIVIENDAS...\n");
					inmobiliaria.listarContratosViviendas();
					System.out.println("");
					break;

				case 3: //Cargar contratos desde el DAO.
					System.out.println("\nCARGANDO CONTRATOS VENTA VIVIENDAS...\n");
					inmobiliaria.cargarDAOContratosViviendas();
					System.out.println("");
					break;

				case 4: //Vender un piso. ( Crea un contrato que asocia un cliente con un piso) 
					System.out.println("\tVENDIENDO PISO...\n");
					inmobiliaria.venderPiso();
					break;

				case 5: //Mostrar contratos pisos.
					System.out.println("\tLISTANDO CONTRATOS VENTA PISOS...\n");
					inmobiliaria.listarContratosPisos();
					System.out.println("");
					break;

				case 6: //Cargar contratos desde el DAO.
					System.out.println("\tCARGANDO CONTRATOS VENTA PISOS...\n");
					inmobiliaria.cargarDAOContratosPisos();
					System.out.println("");
					break;

				case 0: //Volver al menú principal.
					System.out.println("");
					opcion = 0;
					break;
			}
		}
	}

	private static void submenuCopiaSeguridad(Inmobiliaria inmobiliaria) {
		int opcion = -1;
		while (opcion != 0) {

			Scanner entrada = new Scanner(System.in);
			System.out.print(""
					+ "\t====================\n"
					+ "\t----MENÚ COPIA DE SEGURIDAD----\n"
					+ "\t====================\n"
					+ "\t1. GUARDAR COPIA DE SEGURIDAD\n"
					+ "\t2. RESTAURAR COPIA DE SEGURIDAD\n"
					+ "\t3. GUARDAR EN FICHERO\n"
					+ "\t0. VOLVER.\n"
					+ "\t====================\n"
					+ "\tINTRODUZCA OPCIÓN: ");
			opcion = entrada.nextInt();
			System.out.println("");

			switch (opcion) {

				case 1: //guardar una  copia de seguridad de las listas 
					System.out.println("\tGUARDANDO COPIA DE SEGURIDAD...\n");
					inmobiliaria.crearCopia();
					System.out.println("");
					break;

				case 2: //restaurar las copias de seguridad
					System.out.println("\tRESTAURANDO COPIA DE SEGURIDAD ...\n");
					inmobiliaria.restaurarCopia();
					System.out.println("");
					break;
				case 3: //guardar en ficheros1

					System.out.println("\tCUARDANDO EN FICHEROS...\n");
					inmobiliaria.guardarArchivos();
					System.out.println("");
					;
					break;

				case 0: //Volver al menú principal.
					System.out.println("");
					opcion = 0;
					break;
			}
		}
	}
}
