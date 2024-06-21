package model;

import java.util.List;

public class Inspector {
	
	public Boolean tieneEstacionamientoVigente(String patente, List<Estacionamiento> estacionamientos) {
		
		return estacionamientos.stream().anyMatch(e->e.getPatente().equals(patente));
	}
	
	public Infraccion altaInfraccion(String patente) {
		
		return new Infraccion(patente, this);
	}

}
