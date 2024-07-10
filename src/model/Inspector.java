package model;

import java.util.List;
import java.util.stream.Collectors;

public class Inspector {
	
	public Boolean tieneEstacionamientoVigente(String patente, List<Estacionamiento> estacionamientos) {
		
		return estacionamientos.stream().anyMatch(e->e.getPatente().equals(patente)) 
				&& 
				estacionamientos.stream().filter(e->e.getPatente().equals(patente)).collect(Collectors.toList()).get(0).esVigente();
	}
	
	public Infraccion altaInfraccion(String patente) {
		
		return new Infraccion(patente, this);
	}

}
