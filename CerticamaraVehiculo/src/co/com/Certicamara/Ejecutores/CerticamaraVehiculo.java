package co.com.Certicamara.Ejecutores;

import java.util.Scanner;

import co.com.Certicamara.Interfaces.InterfaceSuperficie;
import co.com.Certicamara.Utilitarios.ControlSuperficie;
import co.com.Certicamara.Utilitarios.ValidadorDatos;

/**
 * 
 * @author Andres Julian Rincon.
 *
 */
public class CerticamaraVehiculo {
	private final static Scanner Scan = new Scanner(System.in);
	private static InterfaceSuperficie SuperficieLogica;

	/**
	 * Metodo inicial para realizar la ejecucion.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		System.out.println("********************************VEHICULO A CONTROL REMOTO********************************");
		SuperficieLogica = new ControlSuperficie(IngresarDimensiones("N"), IngresarDimensiones("M"));
		SuperficieLogica.ImprimirSuperficie();
		System.out.println("-------Realizar Movimientos del Vehiculo-------");
		IngresarDirecciones();
	}

	/**
	 * Metodo para ingresar las dimensiones de la superficie.
	 * 
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
		boolean Validacion = false;
		while (!Validacion) {
			System.out.println(
					"Ingrese una posicion y una direccion [Norte (N); Sur(S); Este (E); Oeste(O)]. Puede ingresar varias posiciones con direcciones separadas por Punto y Coma (;)");
			Dato = Scan.next();
			Validacion = ValidadorDatos.ValidarDirecciones(Dato);
			if (Validacion) {
				for (String Direcciones : ValidadorDatos.SegmentarDirecciones(Dato)) {
					Validacion = false;
					Validacion = SuperficieLogica.RealizarMovimiento(ValidadorDatos.RetornarNumeros(Direcciones),
							ValidadorDatos.RetornaCaracteres(Direcciones));
					if (Validacion) {
						SuperficieLogica.ImprimirSuperficie();
					} else {
						break;
					}
				}
				System.out.println(
						"-----------------------------------------Posicion del vehiculo-----------------------------------------");
				System.out.println("(" + SuperficieLogica.getSuperficie().getVehiculoRemoto().getPosicionX() + ","
						+ SuperficieLogica.getSuperficie().getVehiculoRemoto().getPosicionY() + ")");
				System.out.println(
						"-------------------------------------------------------------------------------------------------------");
				System.out.println("Desea Terminar S/N");
				Dato = Scan.next();
				if (Dato.toUpperCase().equals("S")) {
					Validacion = true;
				} else {
					Validacion = false;
				}
			}
		}
	}
}