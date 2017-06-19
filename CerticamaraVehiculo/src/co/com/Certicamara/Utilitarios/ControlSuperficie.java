package co.com.Certicamara.Utilitarios;

import co.com.Certicamara.Componentes.Superficie;
import co.com.Certicamara.Interfaces.InterfaceSuperficie;

public class ControlSuperficie implements InterfaceSuperficie {
	private Superficie SuperficieLogica;

	public ControlSuperficie(int x, int y) {
		this.SuperficieLogica = new Superficie(x, y);
		AsignarSuperficie();
	}
	
	public Superficie getSuperficie(){
		return SuperficieLogica;
	}

	/**
	 * Metodo para asignar los valores a la Superficie Virtual
	 */
	public void AsignarSuperficie() {
		for (int i = 0; i < this.SuperficieLogica.getLimiteX(); i++) {
			for (int j = 0; j < this.SuperficieLogica.getLimiteY(); j++) {
				if (this.SuperficieLogica.getVehiculoRemoto().getPosicionX() == i
						&& this.SuperficieLogica.getVehiculoRemoto().getPosicionY() == j) {
					this.SuperficieLogica.getSuperficieLogica()[i][j] = "Vehiculo";
				} else {
					SuperficieLogica.getSuperficieLogica()[i][j] = "Vacio";
				}
			}
		}
	}

	/**
	 * Metodo para mostrar graficamente la matriz en la consola
	 */
	public void ImprimirSuperficie() {
		for (int i = this.SuperficieLogica.getLimiteX() - 1; i >= 0; i--) {
			System.out.println("");
			for (int j = 0; j < this.SuperficieLogica.getLimiteY(); j++) {
				System.out.print(this.SuperficieLogica.getSuperficieLogica()[i][j] + " ");
			}
		}
		System.out.println("");
	}

	/**
	 * Metodo que realiza la validacion y la ejecucion del movimiento a partir
	 * de los limites de la superficie
	 * 
	 * @param Posicion,
	 *            Cardinalidad
	 * @param boolean
	 * @return
	 */
	public boolean RealizarMovimiento(int Posicion, String Cardinalidad) {
		boolean Retorno = true;
		int ValidacionPosicion;
		if (Cardinalidad.toUpperCase().equals("N")) {
			ValidacionPosicion = (this.SuperficieLogica.getVehiculoRemoto().getPosicionX() + Posicion);
			if (ValidacionPosicion > this.SuperficieLogica.getLimiteX() - 1) {
				System.out.println(
						"La Posicion de esta direccion " + Posicion + Cardinalidad + " esta fuera del rango X");
				Retorno = false;
			}
		} else if (Cardinalidad.toUpperCase().equals("S")) {
			ValidacionPosicion = (this.SuperficieLogica.getVehiculoRemoto().getPosicionX() - Posicion);
			if (ValidacionPosicion < 0) {
				System.out.println(
						"La Posicion de esta direccion " + Posicion + Cardinalidad + " esta fuera del rango X");
				Retorno = false;
			}
		} else if (Cardinalidad.toUpperCase().equals("O")) {
			ValidacionPosicion = (this.SuperficieLogica.getVehiculoRemoto().getPosicionY() + Posicion);
			if (ValidacionPosicion > this.SuperficieLogica.getLimiteY() - 1) {
				System.out.println(
						"La Posicion de esta direccion " + Posicion + Cardinalidad + " esta fuera del rango Y");
				Retorno = false;
			}
		} else {
			ValidacionPosicion = (this.SuperficieLogica.getVehiculoRemoto().getPosicionY() - Posicion);
			if (ValidacionPosicion < 0) {
				System.out.println(
						"La Posicion de esta direccion " + Posicion + Cardinalidad + " esta fuera del rango Y");
				Retorno = false;
			}
		}
		if (Retorno) {
			this.SuperficieLogica.getVehiculoRemoto().AsignaPosicionVehiculo(ValidacionPosicion, Cardinalidad);
		}
		AsignarSuperficie();
		return Retorno;
	}

}
