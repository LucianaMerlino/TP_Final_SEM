package model;

import java.time.LocalDate;
//import java.time.LocalDateTime;
import java.time.LocalTime;

public abstract class Estacionamiento {
	
	private LocalDate fecha;
	protected LocalTime horaInicio;
	protected LocalTime horaFin;
	protected String patente;
	
	public Estacionamiento (LocalTime horaIni, String patente) {
		fecha = LocalDate.now();
		horaInicio = horaIni;
	}
	
	public String getPatente() {

	public LocalDateTime getHoraInicio() {
		return horaInicio;
	}
	
	public LocalDateTime getHoraFin() {
		return horaFin;
	}

	public String getPatente() {
		return patente;
	}

	public Boolean estaVigente() {
		return (this.horaFin.isBefore(LocalDateTime.now()) || this.getHoraFin() == null);
	}
	public LocalDate getFecha() {
		return fecha;
	}

	protected  LocalTime getHoraFin() {
		return horaFin;
	}

}
