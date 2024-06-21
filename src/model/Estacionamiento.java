package model;

import java.time.LocalDateTime;

public abstract class Estacionamiento {
	
	protected LocalDateTime horaInicio;
	protected LocalDateTime horaFin;
	protected String patente;
	
	public String getPatente() {

		return this.patente;
	}

}
