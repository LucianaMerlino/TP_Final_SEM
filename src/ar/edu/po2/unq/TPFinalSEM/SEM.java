package ar.edu.po2.unq.TPFinalSEM;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SEM {
	
	private int precioPorHora;
	private LocalTime inicioFranja;
	private LocalTime finFranja;
	private List<Estacionamiento> estacionamientos;
	
	public SEM(int precioPorHora, LocalTime inicioFranja, 
			   LocalTime finFranja) {
		this.precioPorHora = precioPorHora;
		this.inicioFranja = inicioFranja;
		this.finFranja = finFranja;
		this.estacionamientos = new ArrayList<Estacionamiento>();
	}

	public int getPrecioHora() {
		
		return this.precioPorHora;
	}
	
	public List<Estacionamiento> getEstacionamientos() {
		return this.estacionamientos;
	}	
	
	
	public void finalizarEstacionamientoViaApp(Celular celular) {
	
		LocalTime horaActual = LocalTime.now();
		
		this.getEstacionamientos().stream()
								  .filter(estacionamiento -> estacionamiento instanceof EstacionamientoViaApp)
								  .map(estacionamiento -> (EstacionamientoViaApp) estacionamiento)
								  .filter(estacionamiento -> estacionamiento.getCelular().getNumero() == celular.getNumero())
								  .forEach(estacionamiento -> estacionamiento.setHoraFin(horaActual));     																	
	}

	public void iniciarEstacionamientoViaApp(EstacionamientoViaApp estacionamientoViaApp) {
	
		this.estacionamientos.add(estacionamientoViaApp);
		
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

	public boolean esZonamedida(Zona ubicacionActual) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void finalizarTodosLosEstacionamientosVigentes() {
		
		this.getEstacionamientos().stream()
								  .filter(estacionamiento -> estacionamiento.esVigente())
								  .forEach(estacionamiento -> estacionamiento.setHoraFin(this.getFinFranja()));	
	}	
	
}













