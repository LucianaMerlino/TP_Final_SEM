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

	
	
	
}
