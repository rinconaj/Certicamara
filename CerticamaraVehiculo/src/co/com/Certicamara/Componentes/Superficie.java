package co.com.Certicamara.Componentes;

public class Superficie {
	private String[][] SuperficieLogica;
	private Vehiculo VehiculoRemoto;

	/**
	 * Constructor para inicializar la superficie.
	 * @param x
	 * @param y
	 */
	public Superficie(int x, int y) {
		this.SuperficieLogica = new String[x][y];
		Inicializar();
	}

	/**
	 * 
	 * @return
	 */
	public int getLimiteX() {
		return SuperficieLogica.length;
	}

	/**
	 * 
	 * @return
	 */
	public int getLimiteY() {
		return SuperficieLogica[0].length;
	}

	/**
	 * 
	 * @return
	 */
	public Vehiculo getVehiculoRemoto() {
		return VehiculoRemoto;
	}

	/**
	 * 
	 * @return
	 */
	public String[][] getSuperficieLogica() {
		return SuperficieLogica;
	}

	/**
	 * Metodo para inicializar la matriz con los valores y la ubicacion inicial del vehiculo.
	 */
	private void Inicializar() {
		this.VehiculoRemoto = new Vehiculo();
		//
		AsignarSuperficie();
	}

	/**
	 * Metodo para asignar los valores a la Superficie Virtual 
	 */
	private void AsignarSuperficie() {
		for (int i = 0; i < getLimiteX(); i++) {
			for (int j = 0; j < getLimiteY(); j++) {
				if (getVehiculoRemoto().getPosicionX() == i && getVehiculoRemoto().getPosicionY() == j) {
					SuperficieLogica[i][j] = "Vehiculo";
				} else {
					SuperficieLogica[i][j] = "Vacio";
				}
			}
		}
	}

	/**
	 * Metodo para mostrar graficamente la matriz en la consola
	 */
	public void ImprimirSuperficie() {
		for (int i = getLimiteX() - 1; i >= 0; i--) {
			System.out.println("");
			for (int j = 0; j < getLimiteY(); j++) {
				System.out.print(getSuperficieLogica()[i][j] + " ");
			}
		}
		System.out.println("");
	}

	/**
	 * Metodo que realiza la validacion y la ejecucion del movimiento a partir de los limites de la superficie
	 * @param Posicion, Cardinalidad
	 * @param boolean
	 * @return
	 */
	public boolean RealizarMovimiento(int Posicion, String Cardinalidad) {
		boolean Retorno = true;
		int ValidacionPosicion;
		switch (Cardinalidad) {
		case "N":
			ValidacionPosicion = (getVehiculoRemoto().getPosicionX() + Posicion);
			if (ValidacionPosicion > this.getLimiteX() - 1) {
				System.out.println(
						"La Posicion de esta direccion " + Posicion + Cardinalidad + " esta fuera del rango X");
				Retorno = false;
			}
			break;
		case "S":
			ValidacionPosicion = (getVehiculoRemoto().getPosicionX() - Posicion);
			if (ValidacionPosicion < 0) {
				System.out.println(
						"La Posicion de esta direccion " + Posicion + Cardinalidad + " esta fuera del rango X");
				Retorno = false;
			}
			break;
		case "O":
			ValidacionPosicion = (getVehiculoRemoto().getPosicionY() + Posicion);
			if (ValidacionPosicion > this.getLimiteY() - 1) {
				System.out.println(
						"La Posicion de esta direccion " + Posicion + Cardinalidad + " esta fuera del rango Y");
				Retorno = false;
			}
			break;
		default:
			ValidacionPosicion = (getVehiculoRemoto().getPosicionY() - Posicion);
			if (ValidacionPosicion < 0) {
				System.out.println(
						"La Posicion de esta direccion " + Posicion + Cardinalidad + " esta fuera del rango Y");
				Retorno = false;
			}
			break;
		}
		if (Retorno) {
			this.getVehiculoRemoto().AsignaPosicionVehiculo(ValidacionPosicion, Cardinalidad);
		}
		AsignarSuperficie();
		return Retorno;
	}
}
