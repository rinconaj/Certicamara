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
	}
}
