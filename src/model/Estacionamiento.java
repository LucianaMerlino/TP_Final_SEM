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
	
<<<<<<< HEAD
	protected Estacionamiento(LocalDateTime horaInicio, LocalDateTime horaFin, String patente) {
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
=======
	public Estacionamiento (LocalTime horaIni, String patente) {
		this.fecha = LocalDate.now();
		this.horaInicio = horaIni;
>>>>>>> semtesteado
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
		return (this.getHoraFin() == null || this.horaFin.isBefore(LocalTime.now()));
	}
	
	public abstract Celular getCelular();
	public LocalDate getFecha() {
		return fecha;
	}
	



}
