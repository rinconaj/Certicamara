package co.com.Certicamara.Interfaces;

import co.com.Certicamara.Componentes.Superficie;

public interface InterfaceSuperficie {
	public Superficie getSuperficie();
	public void AsignarSuperficie();
	public void ImprimirSuperficie();
	public boolean RealizarMovimiento(int Posicion, String Cardinalidad);
}
