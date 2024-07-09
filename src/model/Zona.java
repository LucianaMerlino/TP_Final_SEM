package model;

import java.util.ArrayList;
import java.util.List;

public class Zona {

	private List<PuntoDeVenta> puntosDeVenta;
	
	public Zona () {
		this.puntosDeVenta = new ArrayList<PuntoDeVenta>();
	}

	public void agregarPuntoDeVenta(PuntoDeVenta puntoDeVenta) {
		this.puntosDeVenta.add(puntoDeVenta);
	}
	
	public void quitarPuntoDeVenta(PuntoDeVenta puntoDeVenta) {
		this.puntosDeVenta.remove(puntoDeVenta);
	}

	public List<PuntoDeVenta> getPuntosDeVenta() {
		return this.puntosDeVenta;
	}

}