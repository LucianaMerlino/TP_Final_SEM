package ar.edu.po2.unq.TPFinalSEM;
import java.time.LocalTime;

public abstract class Estacionamiento {
	
	protected LocalTime horaInicio;
	protected LocalTime horaFin;
	protected String patente;
	
	public Estacionamiento(LocalTime horaInicio, LocalTime horaFin, 
						   String patente) {
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.patente = patente;
	}
		
	public String getPatente() {

		return this.patente;
	}
	
	public LocalTime getHoraInicio() {
		return this.horaInicio;
	}
	
	public LocalTime getHoraFin() {
		return this.horaFin;
	}
	
	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}


	public boolean noEsVigente() {
		
		return this.getHoraFin().getHour() == 20 ;
			
	}
	
	public boolean esVigente() {
		
		return !this.noEsVigente();  
	}	
	

}