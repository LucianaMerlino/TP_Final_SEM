package model;

import java.time.LocalDateTime;

public abstract class Estacionamiento {
	
	private LocalDateTime horaInicio;
	private LocalDateTime horaFin;
	private String patente;
	
	protected Estacionamiento(LocalDateTime horaInicio, LocalDateTime horaFin, String patente) {
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.patente = patente;
	}

	public LocalDateTime getHoraInicio() {
		return horaInicio;
	}
	
	public LocalDateTime getHoraFin() {
		return horaFin;
	}
	
	public void setHoraFin(LocalDateTime horaFin) {
		this.horaFin = horaFin;
	}

	public String getPatente() {
		return patente;
	}
	
	public abstract Celular getCelular();

	public Boolean estaVigente() {
		return (this.horaFin.isBefore(LocalDateTime.now()) || this.getHoraFin() == null);
	}

}
