package model;

import java.time.LocalTime;

public class EstacionamientoViaApp extends Estacionamiento {
	
	private String nroCelular;

	public EstacionamientoViaApp(LocalTime horaIni, String patente, String nCelular) {
		super(horaIni, patente);
		nroCelular = nCelular;
		
	}

	public String getNroCelular() {
		return nroCelular;
	}

	
	

}
