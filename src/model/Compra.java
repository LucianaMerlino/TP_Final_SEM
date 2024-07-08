package model;

import java.time.LocalDateTime;

public abstract class Compra {
	
	private int nroControl;
	private PuntoDeVenta puntoDeVenta;
	private LocalDateTime fechaHora;
	
	protected Compra(int nroControl, PuntoDeVenta puntoDeVenta, LocalDateTime fechaHora) {
		this.nroControl = nroControl;
		this.puntoDeVenta = puntoDeVenta;
		this.fechaHora = fechaHora;
	}
	
	protected LocalDateTime getFechaHora() {
		return this.fechaHora;
	}

}
