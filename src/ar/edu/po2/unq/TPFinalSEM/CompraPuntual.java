package ar.edu.po2.unq.TPFinalSEM;

import java.time.LocalDateTime;

public class CompraPuntual extends Compra {
	
	private int horas;
	private String patente;
	
	public CompraPuntual(int nroControl, int horas, String patente) {
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

	public int getHoras() {
		
		return this.horas;
	}

}