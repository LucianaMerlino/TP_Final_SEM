package model;

import java.util.List;
import java.util.stream.Collectors;

public class Inspector {
	
	private SEM sem;
	
	public Boolean tieneEstacionamientoVigente(String patente, List<Estacionamiento> estacionamientos) {
		return estacionamientos.stream().anyMatch(e->e.getPatente().equals(patente)) 
				&& 
				estacionamientos.stream().filter(e->e.getPatente().equals(patente)).collect(Collectors.toList()).get(0).esVigente();
	}
	
	public void altaInfraccion(String patente) {
		Infraccion infraccion = new Infraccion(patente, this);
		this.sem.registrarInfraccion(infraccion);
	}

}
