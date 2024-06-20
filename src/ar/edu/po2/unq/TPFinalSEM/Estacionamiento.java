package ar.edu.po2.unq.TPFinalSEM;
import java.time.LocalDateTime;

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

	protected abstract boolean hayEstacionamientoVigente(String patente, int numeroDeCelular);

}
