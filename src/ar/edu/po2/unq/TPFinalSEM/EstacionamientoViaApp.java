package ar.edu.po2.unq.TPFinalSEM;

import java.time.LocalTime;

public class EstacionamientoViaApp extends Estacionamiento {

	private Celular celular;
	
	
	public EstacionamientoViaApp(LocalTime horaInicio, LocalTime horaFin, 
							     String patente, Celular celular) {
		super(horaInicio, horaFin, patente);
		
		this.celular = celular;
		
	}
	
	public Celular getCelular() {
		return this.celular;
	}

}
