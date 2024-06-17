package ar.edu.po2.unq.TPFinalSEM;
import java.time.LocalDateTime;

public abstract class Estacionamiento {
	
	protected LocalDateTime horaInicio;
	protected LocalDateTime horaFin;
	protected String patente;
	protected boolean estaVigente;
	
	public Estacionamiento(LocalDateTime horaInicio, LocalDateTime horaFin, 
						   String patente, boolean estaVigente) {
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.patente = patente;
		this.estaVigente = estaVigente;
	}
	
	
	public String getPatente() {

		return this.patente;
	}
	
	public boolean getEstaVigente() {
		return this.estaVigente;
	}
	
	public void setEstaVigente(boolean estaVigente) {
		this.estaVigente = estaVigente;
	}
}
