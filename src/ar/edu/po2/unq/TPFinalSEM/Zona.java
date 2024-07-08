package ar.edu.po2.unq.TPFinalSEM;

import java.util.List;

public class Zona {
	
	private List<PuntoDeVenta> puntosDeVentas;
	private Inspector inspector;
	
	public Zona(List<PuntoDeVenta> puntosDeVentas, Inspector inspector) {
		this.puntosDeVentas = puntosDeVentas;
		this.inspector = inspector;
	}
	
	public List<PuntoDeVenta> getPuntosDeVentas() {
		return this.puntosDeVentas;	
	}
	
	public void agregarPuntoDeVenta(PuntoDeVenta puntoDeVenta) {
	
		this.puntosDeVentas.add(puntoDeVenta);
	}
	
	public void quitarPuntoDeVenta(PuntoDeVenta puntoDeVenta) {
		
		this.puntosDeVentas.remove(puntoDeVenta);
	}
	
	
}
