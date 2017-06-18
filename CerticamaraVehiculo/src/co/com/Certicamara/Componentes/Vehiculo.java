package co.com.Certicamara.Componentes;

public class Vehiculo {
	private int PosicionX;
	private int PosicionY;

	enum Cardinalidad {
		N, S, E, O
	}

	/**
	 * Constructor para inicializar las posiciones del Vehiculo
	 */
	public Vehiculo() {
		// Asigna la posicion del vehiculo
		AsignaPosicionVehiculo(0, "S");
		AsignaPosicionVehiculo(0, "E");
	}

	/**
	 * 
	 * @return
	 */
	public int getPosicionX() {
		return PosicionX;
	}

	/**
	 * 
	 * @param posicionX
	 */
	public void setPosicionX(int posicionX) {
		PosicionX = posicionX;
	}

	/**
	 * 
	 * @return
	 */
	public int getPosicionY() {
		return PosicionY;
	}

	/**
	 * 
	 * @param posicionY
	 */
	public void setPosicionY(int posicionY) {
		PosicionY = posicionY;
	}

	/**
	 * Metodo para realizar ingresar las nuevas posiciones del vehiculo.
	 * @param Posicion
	 * @param Referencia
	 */
	public void AsignaPosicionVehiculo(int Posicion, String Referencia) {
		if (Referencia.equals(Cardinalidad.N.toString()) | Referencia.equals(Cardinalidad.S.toString())) {
			setPosicionX(Posicion);
		} else if (Referencia.equals(Cardinalidad.E.toString()) | Referencia.equals(Cardinalidad.O.toString())) {
			setPosicionY(Posicion);
		}
	}
}
