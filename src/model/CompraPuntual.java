package model;

import java.time.LocalDateTime;

public class CompraPuntual extends Compra {
	
	private int horas;
	private String patente;
	
	public CompraPuntual(int nroControl, PuntoDeVenta puntoDeVenta, int horas, String patente) {
		super(nroControl, puntoDeVenta, LocalDateTime.now());
		this.horas = horas;
		this.patente = patente;
		
	}

	public LocalDateTime getFechaHora() {
		return super.getFechaHora();
	}

	public String getPatente() {
		return this.patente;
	}

	public int getHoras() {
		return this.horas;
	}

}
