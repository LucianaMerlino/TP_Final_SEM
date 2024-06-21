package ar.edu.po2.unq.TPFinalSEM;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class EstacionamientoViaApp extends Estacionamiento {

	private int numeroDeCelular;
	
	public EstacionamientoViaApp(LocalDateTime horaInicio, LocalDateTime horaFin, String patente) {
		super(horaInicio, horaFin, patente);
		
	}
	
	public EstacionamientoViaApp(LocalDateTime horaInicio, LocalDateTime horaFin, String patente, int numeroDeCelular) {
		super(horaInicio, horaFin, patente);
		
		this.numeroDeCelular = numeroDeCelular;
		
	}
	
	public int getNumeroDeCelular() {
		return this.numeroDeCelular;
	}
	
	
	@Override
	public boolean hayEstacionamientoVigente(String patente, int numeroDeCelular) {
		
		return (this.getNumeroDeCelular() == numeroDeCelular);
		
	}

	public boolean noEsVigente() {
		
		LocalDate diaActual = LocalDate.now();
		LocalTime horaActual = LocalTime.now();
	
		LocalDateTime fechaYHoraActual = LocalDateTime.of(diaActual, horaActual);
		
		return this.getHoraFin().getHour() == fechaYHoraActual.getHour() ;
		
		
		// hora fin == hora actual en este momento
		// creo un objeto hora con la hora actual, y preguntar si la hora de fin 
		// es la hora de este momento y cuando se finaliza el estacionamiento 
		// le seteo la hora actual
		
	}
	
	
}
