package model;

import java.time.LocalDateTime;

public class Infraccion {
	
	private LocalDateTime fechaHora;
	private String 		  patente;
	private Inspector 	  inspector;
	
	public Infraccion(String patente, Inspector inspector) {
		
		this.fechaHora = LocalDateTime.now();
		this.patente   = patente;
		this.inspector = inspector;
	}

	public String getPatente() {
		return patente;
	}

	public Inspector getInspector() {
		return inspector;
	}

}