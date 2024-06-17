package ar.edu.po2.unq.TPFinalSEM;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SEM {
	
	private int precioPorHora;
	private LocalTime inicioFranja;
	private LocalTime finFranja;
	private List<Estacionamiento> estacionamientos;
	
	public SEM(int precioPorHora, LocalTime inicioFranja, LocalTime finFranja, List<Estacionamiento> estacionamientos) {
		this.precioPorHora = precioPorHora;
		this.inicioFranja = inicioFranja;
		this.finFranja = finFranja;
		this.estacionamientos = estacionamientos;
	}

	public int precioHora() {
		
		return this.precioPorHora;
	}
	
	public void setPrecioHora(int precio) {
		this.precioPorHora = precio;
	}
	
	public List<Estacionamiento> getEstacionamientos() {
		return this.estacionamientos;
	}	
	

	public List<EstacionamientoViaApp> finalizarEstacionamientoViaApp(String patente) {
	
		// Filtro los estacionamientos y me quedo con los EstacionamientoViaApp, pero no me gusta tener que hacer un down casting 
	
		List<EstacionamientoViaApp> estacionamientosViaApp = this.getEstacionamientos().stream()
																					  .filter(estacionamiento -> estacionamiento instanceof EstacionamientoViaApp)
																					  .map(estacionamiento -> (EstacionamientoViaApp) estacionamiento)
																					  .filter(estacionamiento -> estacionamiento.getPatente().equals(patente)) 
																					  .collect(Collectors.toList());
																					  
		List<EstacionamientoViaApp> estacionamientosFinalizados = estacionamientosViaApp.stream()
																					    .map(estacionamientoViaApp -> {
        																					 estacionamientoViaApp.setEstaVigente(false);
        																					 return estacionamientoViaApp;
    																					})
    																					.collect(Collectors.toList());
		return estacionamientosFinalizados;																	
		
	}

	public void iniciarEstacionamientoViaApp(String patente, int nroCelular) {
		// TODO Auto-generated method stub
		
	}
	
	public LocalTime getInicioFranja() {
	
		return this.inicioFranja;
		
	}
	
	public void setInicioFranja(LocalTime horaInicio) {
		
		this.inicioFranja = horaInicio;	
	}

	public LocalTime getFinFranja() {
		
		return this.finFranja;
		
	}
	
	public void setFinFranja(LocalTime horaFin) {
	
		this.finFranja = horaFin;
			
	}

	public boolean esVigente(String patente) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean esZonamedida(Zona ubicacionActual) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
