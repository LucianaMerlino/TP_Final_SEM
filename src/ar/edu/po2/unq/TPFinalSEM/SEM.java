package ar.edu.po2.unq.TPFinalSEM;

import java.time.LocalTime;

public class SEM {
	
	private int precioPorHora;
	private LocalTime inicioFranja;
	private LocalTime finFranja;
	
	public SEM(int precioPorHora, LocalTime inicioFranja, LocalTime finFranja) {
		this.precioPorHora = precioPorHora;
		this.inicioFranja = inicioFranja;
		this.finFranja = finFranja;
	}

	public int precioHora() {
		// TODO Auto-generated method stub
		return this.precioPorHora;
	}
	
	public void setPrecioHora(int precio) {
		this.precioPorHora = precio;
	}

	public void finalizarEstacionamientoViaApp(String patente) {
		// TODO Auto-generated method stub
		
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
