package ar.edu.po2.unq.TPFinalSEM;

import java.time.LocalDateTime;

public class EstacionamientoViaApp extends Estacionamiento {

	private int numeroDeCelular;
	
	public EstacionamientoViaApp(LocalDateTime horaInicio, LocalDateTime horaFin, String patente) {
		super(horaInicio, horaFin, patente);
	}
	
	public int getNumeroDeCelular() {
		return this.numeroDeCelular;
	}
	
	
	@Override
	public boolean hayEstacionamientoVigente(String patente, int numeroDeCelular) {
		
		return (this.getNumeroDeCelular() == numeroDeCelular);
		
	}

	public boolean esVigente(EstacionamientoViaApp estacionamiento) {
		
		return estacionamiento.getHoraFin().getHour() > estacionamiento.getHoraInicio().getHour();
		
	}
	
	
}
