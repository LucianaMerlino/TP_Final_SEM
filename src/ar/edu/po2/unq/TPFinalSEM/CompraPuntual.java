package ar.edu.po2.unq.TPFinalSEM;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class CompraPuntual extends Compra {
	
	private int horas;
	private String patente;
	
	public CompraPuntual(int nroControl, int horas, String patente) {
		this.nroControl = nroControl;
		this.hora = LocalTime.now();
		this.horas = horas;
		this.patente = patente;
		
	}

	public LocalTime getHora() {
		
		return this.hora;
		
	}

	public String getPatente() {
		
		return this.patente;
	}

	public int getHoras() {
		
		return this.horas;
	}

}