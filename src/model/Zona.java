package model;

import java.util.ArrayList;
import java.util.List;

public class Zona {

	private List<PuntoDeVenta> puntosDeVenta;
	private Inspector inspector;
	
	public Zona (Inspector inspector) {
		this.puntosDeVenta = new ArrayList<PuntoDeVenta>();
		this.setInspector(inspector);
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

	public Inspector getInspector() {
		return inspector;
	}

	public void setInspector(Inspector inspector) {
		this.inspector = inspector;
	}
	
	public Boolean pertenece(String ubicacion) {
		return true;
	}

}