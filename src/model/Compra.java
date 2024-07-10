package model;

import java.time.LocalDateTime;

public abstract class Compra {
	
	private int nroControl;
	private SEM sem;
	private PuntoDeVenta puntoDeVenta;
	private LocalDateTime fechaHora;
	
	protected Compra(int nroControl, SEM sem, PuntoDeVenta puntoDeVenta, LocalDateTime fechaHora) {
		this.nroControl = nroControl;
		this.sem = sem;
		this.puntoDeVenta = puntoDeVenta;
		this.fechaHora = fechaHora;
	}
	
	protected LocalDateTime getFechaHora() {
		return this.fechaHora;
	}

}
