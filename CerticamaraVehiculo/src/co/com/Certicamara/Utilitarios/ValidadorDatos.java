package co.com.Certicamara.Utilitarios;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andres Julian Rincon
 *
 */
public class ValidadorDatos {
	/**
	 * Metodo para realizar la validacion si existe numeros en una cadena alfanumerica
	 * @param Dato
	 * @return boolean
	 */
	public static boolean ValidarNumeros(String Dato) {
		try {
			RetornarNumeros(Dato);
			return true;
		} catch (NumberFormatException e) {
			System.out.println("Debe Digitar numeros enteros en la ubicacion \""+Dato+"\"");
			return false;
		}
	}
	
	/**
	 * Metodo para extraer solo datos numericos de una cadena de caracteres.
	 * @param Dato
	 * @return Integer
	 * @throws NumberFormatException
	 *  
	 */
	public static int RetornarNumeros(String Dato) throws NumberFormatException{
		return Integer.parseInt(Dato.replaceAll("\\D+", ""));
	}
	
	/**
	 * Metodo para realizar las validaciones de las direcciones ingresadas en el cual se encuentre la cardinalidad y numeros digitados.
	 * @param Direcciones
	 * @return boolean
	 */
	public static boolean ValidarDirecciones(String Direcciones) {
		boolean Bandera = false;
		for (String Direccion : SegmentarDirecciones(Direcciones)) {
			Bandera = false;
			if (!ValidarNumeros(Direccion)) {
				break;
			}
			if (!ValidarCardinalidad(Direccion)) {
				break;
			}
			Bandera = true;
		}
		return Bandera;
	}
	
	/**
	 * Metodo para segmentar las direcciones ingresadas por consola
	 * @param Direcciones
	 * @return List
	 */
	public static List<String> SegmentarDirecciones(String Direcciones){
		List<String> Retorno = new ArrayList<String>();
		for (String Direccion : Direcciones.split(";")) {
			Retorno.add(Direccion);
		}
		return Retorno;
	}
	
	/**
	 * Metodo para realizar las validaciones de las cardinalidades permitidas por el sistema.
	 * @param Direccion
	 * @return boolean
	 */
	public static boolean ValidarCardinalidad(String Direccion) {
		String Referencia = RetornaCaracteres(Direccion);
		if (!(Referencia.equals("N") | Referencia.equals("S") | Referencia.equals("E") | Referencia.equals("O"))) {
			System.out.println("La Direccion "+Direccion+" no tiene la codificacion adecuada (debe ser N,S,E,O)");
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Metodo para extraer los caracteres no numericos de una cadena de caracteres.
	 * @param Dato
	 * @return String
	 */
	public static String RetornaCaracteres(String Dato){
		return Dato.replaceAll("^[\\s\\.\\d]+", "").replaceAll("\\+", "_");
	}
}