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
	private List<Compra> compras;
	private List<Zona> zonas;
	private List<Infraccion> infracciones;
	private List<Celular> celulares;
	
	
	public SEM(int precioPorHora, LocalTime inicioFranja, 
			   LocalTime finFranja) {
			   
		this.precioPorHora = precioPorHora;
		this.inicioFranja = inicioFranja;
		this.finFranja = finFranja;
		this.estacionamientos = new ArrayList<Estacionamiento>();
		this.compras = new ArrayList<Compra>();
		this.infracciones = new ArrayList<Infraccion>();
		this.celulares = new ArrayList<Celular>();
		this.zonas = new ArrayList<Zona>();
	}

	public int getPrecioHora() {
		
		return this.precioPorHora;
	}
	
	public List<Celular> getCelulares() {
		return this.celulares;
	}
	
	public List<Estacionamiento> getEstacionamientos() {
		return this.estacionamientos;
	}	
	
	public List<Zona> getZonas() {
		return this.zonas;
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
	
	public void registrarCelular(Celular celular) {
		
		this.celulares.add(celular);
		
	}
	
	
	public void iniciarEstacionamientoViaCompra(CompraPuntual compraPuntual) {
												
		this.estacionamientos.add(new EstacionamientoViaCompra(compraPuntual, 
															   compraPuntual.getHora(),
															   compraPuntual.getHora(),
															   compraPuntual.getPatente()));
	} // testear
	
	public void iniciarEstacionamientoViaApp(EstacionamientoViaApp estacionamientoViaApp) {
	
		this.estacionamientos.add(estacionamientoViaApp);
		
	} // testeado
	
	public void recargarCredito(RecargaCredito recarga) {
		/**
		 * Recarga todos los celulares de la lista con el credito de la recarga de 
		 * credito dada.
		 * */
		 
		 this.getCelulares().stream()
		 					.forEach(celular -> celular.setCredito(recarga.getMonto()));
	} // testear
	
	public void registrarInfraccion(Infraccion infraccion) {
		
		this.infracciones.add(infraccion);
	} // testear
	
	public PuntoDeVenta encontrarPuntoBuscadoEnLasZonas(PuntoDeVenta punto) {
		/**
		 * Recorre la lista de Zonas, y busca al punto de venta dado, 
		 * en cada lista de puntos de ventas de cada zona de la lista de zonas.
		 * */
		return this.getZonas().stream()
							  .flatMap(zona -> zona.getPuntosDeVentas().stream())
							  .filter(puntoDeVenta -> puntoDeVenta == punto)
							  .collect(Collectors.toList())
							  .get(0);
	} // testear
	
	
	
	public void finalizarEstacionamientoViaApp(Celular celular) {
	
		LocalTime horaActual = LocalTime.now();
		
		//LocalTime horaFin = LocalTime.of(20, 0);
		
		this.getEstacionamientos().stream()
								  .filter(estacionamiento -> estacionamiento instanceof EstacionamientoViaApp)
								  .map(estacionamiento -> (EstacionamientoViaApp) estacionamiento)
								  .filter(estacionamiento -> estacionamiento.getCelular().getNumero() == celular.getNumero())
								  .forEach(estacionamiento -> estacionamiento.setHoraFin(horaActual));     																	
	} // testear

	
	
	

	public boolean esZonamedida(Zona ubicacionActual) {
		// TODO: hacer
		return false;
	}
	
	public void finalizarTodosLosEstacionamientosVigentes() {
		
		this.getEstacionamientos().stream()
								  .filter(estacionamiento -> estacionamiento.esVigente())
								  .forEach(estacionamiento -> estacionamiento.setHoraFin(this.getFinFranja()));	
	}	// testeado
	
}













