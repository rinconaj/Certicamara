package co.com.Certicamara.Ejecutores;

import java.util.Scanner;

import co.com.Certicamara.Componentes.Superficie;
import co.com.Certicamara.Utilitarios.ValidadorDatos;
/**
 * 
 * @author Andres Julian Rincon.
 *
 */
public class CerticamaraVehiculo {
	private final static Scanner Scan = new Scanner(System.in);
	private static Superficie SuperficieLogica;

	/**
	 * Metodo inicial para realizar la ejecucion.
	 * @param args
	 */
	public static void main(String args[]) {
		// String capturaDirecciones;
		System.out.println("********************************VEHICULO A CONTROL REMOTO********************************");
		SuperficieLogica = new Superficie(IngresarDimensiones("N"), IngresarDimensiones("M"));
		SuperficieLogica.ImprimirSuperficie();
		System.out.println("-------Realizar Movimientos del Vehiculo-------");
		IngresarDirecciones();
	}
	
	/**
	 * Metodo para ingresar las dimensiones de la superficie.
	 * @param Dimension
	 * @return int
	 */
	public static int IngresarDimensiones(String Dimension) {
		String Dato;
		do {
			System.out.println("Ingrese la dimension de " + Dimension + " en la superficie:");
			Dato = Scan.next();
		} while (!ValidadorDatos.ValidarNumeros(Dato));
		return Integer.parseInt(Dato);
	}

	/**
	 * Metodo para Ingresar y validar las direcciones ingresadas en la consola.
	 */
	public static void IngresarDirecciones() {
		String Dato;
		boolean Validacion;
		boolean Terminar = false;
		while (!Terminar){
			do {
				System.out.println(
						"Ingrese una posicion y una direccion [Norte (N); Sur(S); Este (E); Oeste(O)]. Puede ingresar varias posiciones con direcciones separadas por Punto y Coma (;)");
				Dato = Scan.next();
				Validacion = ValidadorDatos.ValidarDirecciones(Dato);
				if (Validacion) {
					for (String Direcciones : ValidadorDatos.SegmentarDirecciones(Dato)) {
						Validacion = false;
						Validacion = SuperficieLogica.RealizarMovimiento(ValidadorDatos.RetornarNumeros(Direcciones), ValidadorDatos.RetornaCaracteres(Direcciones));
						SuperficieLogica.ImprimirSuperficie();
					}
				}
				System.out.println("-----------------------------------------Posicion del vehiculo-----------------------------------------");
				System.out.println("("+SuperficieLogica.getVehiculoRemoto().getPosicionX()+","+SuperficieLogica.getVehiculoRemoto().getPosicionY()+")");
				System.out.println("-------------------------------------------------------------------------------------------------------");
			} while (!Validacion);
			System.out.println("Desea Terminar S/N");
			Dato = Scan.next();
			if (Dato.toUpperCase().equals("S")){
				Terminar = true;
			}
		} 
	}
}