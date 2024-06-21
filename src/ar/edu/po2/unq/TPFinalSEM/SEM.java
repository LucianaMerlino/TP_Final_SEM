package ar.edu.po2.unq.TPFinalSEM;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class SEM {
	
	private int precioPorHora;
	private LocalDateTime inicioFranja;
	private LocalDateTime finFranja;
	private List<Estacionamiento> estacionamientos;
	
	public SEM(int precioPorHora, LocalDateTime inicioFranja, LocalDateTime finFranja, List<Estacionamiento> estacionamientos) {
		this.precioPorHora = precioPorHora;
		this.inicioFranja = inicioFranja;
		this.finFranja = finFranja;
		this.estacionamientos = estacionamientos;
	}

	public int getPrecioHora() {
		
		return this.precioPorHora;
	}
	
	public void setPrecioHora(int precio) {
		this.precioPorHora = precio;
	}
	
	public List<Estacionamiento> getEstacionamientos() {
		return this.estacionamientos;
	}	
	
	
	public void finalizarEstacionamientoViaApp(int numeroDeCelular) {
	
		LocalDate diaActual = LocalDate.now();
		LocalTime horaActual = LocalTime.now();
	
		LocalDateTime fechaYHoraActual = LocalDateTime.of(diaActual, horaActual);
		
		this.getEstacionamientos().stream()
								  .filter(estacionamiento -> estacionamiento instanceof EstacionamientoViaApp)
								  .map(estacionamiento -> (EstacionamientoViaApp) estacionamiento)
								  .filter(estacionamiento -> estacionamiento.getNumeroDeCelular() == numeroDeCelular)
								  .forEach(estacionamiento -> estacionamiento.setHoraFin(fechaYHoraActual));     																	
	}

	public void iniciarEstacionamientoViaApp(String patente, int nroCelular) {
		// TODO Auto-generated method stub
		
	}
	
	public LocalDateTime getInicioFranja() {
	
		return this.inicioFranja;
		
	}
	
	public void setInicioFranja(LocalDateTime horaInicio) {
		
		this.inicioFranja = horaInicio;	
	}

	public LocalDateTime getFinFranja() {
		
		return this.finFranja;
		
	}
	
	public void setFinFranja(LocalDateTime horaFin) {
	
		this.finFranja = horaFin;
			
	}

	

	public boolean esZonamedida(Zona ubicacionActual) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void finalizarTodosLosEstacionamientosVigentes() {
		
		this.getEstacionamientos().stream()
								  .filter(estacionamiento -> estacionamiento.noEsVigente())
								  .forEach(estacionamiento -> estacionamiento.setHoraFin(this.getFinFranja()));	
	}	
	
}
