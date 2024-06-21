package model;

import java.time.LocalDateTime;

public class CompraPuntual extends Compra {
	
	private Double horas;
	private String patente;
	
	public CompraPuntual(int nroControl, Double horas, String patente) {
		this.nroControl = nroControl;
		this.fechaHora = LocalDateTime.now();
		this.horas = horas;
		this.patente = patente;
		
	}

	public LocalDateTime getFechaHora() {
		
		return this.fechaHora;
		
	}

	public String getPatente() {
		
		return this.patente;
	}

	public Double getHoras() {
		
		return this.horas;
	}

}
