package model;

import java.time.LocalDateTime;

public class EstacionamientoViaApp extends Estacionamiento {
	
	private Celular celular;
	
	public EstacionamientoViaApp(LocalDateTime horaInicio, String patente, Celular celular) {
		super(horaInicio, null, patente);
		this.celular = celular;
	}
	
	@Override
	public Celular getCelular() {
		return this.celular;
	}

}
