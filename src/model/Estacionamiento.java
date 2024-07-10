package model;

import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalDateTime;
import java.time.LocalTime;

public abstract class Estacionamiento {
	
	private LocalDate fecha;
	protected LocalTime horaInicio;
	protected LocalTime horaFin = null;
	protected String patente;
	
	public Estacionamiento (LocalTime horaIni, String patente) {
		this.fecha = LocalDate.now();
		this.horaInicio = horaIni;
		this.patente = patente;
	}
	


	public String getPatente() {
		return this.patente;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}
	
	public LocalTime getHoraFin() {
		return horaFin;
	}
	
	public abstract void setHoraFin(LocalTime horaFin);

	public Boolean esVigente() {
		return (this.horaFin.isBefore(LocalTime.now()) || this.getHoraFin() == null);
	}
	public LocalDate getFecha() {
		return fecha;
	}
	



}
