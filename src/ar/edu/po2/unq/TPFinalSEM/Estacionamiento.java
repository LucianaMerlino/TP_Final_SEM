package ar.edu.po2.unq.TPFinalSEM;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public abstract class Estacionamiento {
	
	protected LocalDateTime horaInicio;
	protected LocalDateTime horaFin;
	protected String patente;
	
	public Estacionamiento(LocalDateTime horaInicio, LocalDateTime horaFin, 
						   String patente) {
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.patente = patente;
	}
		
	public String getPatente() {

		return this.patente;
	}
	
	public LocalDateTime getHoraInicio() {
		return this.horaInicio;
	}
	
	public LocalDateTime getHoraFin() {
		return this.horaFin;
	}
	
	public void setHoraFin(LocalDateTime hora) {
		this.horaFin = hora;
	}


	public boolean noEsVigente() {
		
		LocalDate diaActual = LocalDate.now();
		LocalTime horaActual = LocalTime.now();
	
		LocalDateTime fechaYHoraActual = LocalDateTime.of(diaActual, horaActual);
		
		return this.getHoraFin().getHour() == fechaYHoraActual.getHour() ;
			
	}

}
