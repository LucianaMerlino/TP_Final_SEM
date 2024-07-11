package model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SEM {
	
	private int precioPorHora;
	private LocalTime inicioFranjaHoraria;
	private LocalTime finFranjaHoraria;
	private List<Zona> zonas;
	private List<Compra> compras;
	private List<Estacionamiento> estacionamientos;
	private List<Celular> celulares;
	private List<Infraccion> infracciones;
	
	
	public SEM(int precioPorHora, LocalTime inicioFranjaHoraria, 
			   LocalTime finFranjaHoraria) {
			   
		this.precioPorHora = precioPorHora;
		this.inicioFranjaHoraria = inicioFranjaHoraria;
		this.finFranjaHoraria = finFranjaHoraria;
		this.zonas = new ArrayList<Zona>();
		this.compras = new ArrayList<Compra>();
		this.estacionamientos = new ArrayList<Estacionamiento>();
		this.celulares = new ArrayList<Celular>();
		this.infracciones = new ArrayList<Infraccion>();
		
	}

	public int getPrecioHora() {
		return this.precioPorHora;
	}
	
	public LocalTime getInicioFranjaHoraria() {
		return this.inicioFranjaHoraria;
	}
	
	public void setInicioFranjaHoraria(LocalTime horaInicio) {
		this.inicioFranjaHoraria = horaInicio;	
	}
	
	public LocalTime getFinFranjaHoraria() {
		return this.finFranjaHoraria;
	}
	
	public void setFinFranjaHoraria(LocalTime horaFin) {
		this.finFranjaHoraria = horaFin;
	}
	
	public List<Zona> getZonas() {
		return this.zonas;
	}
	
	public void registrarZona(Zona zona) {
		this.zonas.add(zona);
	}
	
	public List<Estacionamiento> getEstacionamientos() {
		return this.estacionamientos;
	}	
	
	public void iniciarEstacionamientoViaCompra(CompraPuntual compraPuntual) {
		this.estacionamientos.add(new EstacionamientoViaCompra(compraPuntual));
	}
	
	public void iniciarEstacionamientoViaApp(EstacionamientoViaApp estacionamientoViaApp) {
		this.estacionamientos.add(estacionamientoViaApp);
	} 
	
	public List<Celular> getCelulares() {
		return this.celulares;
	}
	
	public void registrarCelular(Celular celular) {
		this.celulares.add(celular);
	}

	public List<Infraccion> getInfracciones() {
		return this.infracciones;
	}
	
	public void registrarInfraccion(Infraccion infraccion) {
		this.infracciones.add(infraccion);
	} 
	
	public List<Compra> getCompras() {
		return this.compras;
	}
	
	public void registrarCompraPuntual(CompraPuntual compraPuntual) {
		this.compras.add(compraPuntual);
	}
	
	public void recargarCredito(RecargaCredito recarga) {
		 this.getCelulares().stream()
		 						.filter(celular -> celular == recarga.getCelular())
		 						.collect(Collectors.toList()).get(0).cargarCredito(recarga.getMonto());
		 this.registrarRecargaCredito(recarga);
	}
	
	public void registrarRecargaCredito(RecargaCredito recargaCredito) {
		this.compras.add(recargaCredito);
	}
	
	public void finalizarEstacionamientoViaApp(Celular celular) {
		LocalDateTime horaActual = LocalDateTime.now();
		
		this.getEstacionamientos().stream().filter(estacionamiento -> estacionamiento.getCelular().getNumero() == celular.getNumero())
											.collect(Collectors.toList()).get(0).setHoraFin(horaActual);
	} 
	
	public void finalizarTodosLosEstacionamientosVigentes() {
		this.getEstacionamientos().stream()
								  .filter(estacionamiento -> estacionamiento.estaVigente())
								  .forEach(estacionamiento -> estacionamiento.setHoraFin(LocalDateTime.of(LocalDateTime.now().toLocalDate(), this.getFinFranjaHoraria())));	
	}

}