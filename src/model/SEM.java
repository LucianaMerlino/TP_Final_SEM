package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

//import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.BatchAllocator.Slicing;

public class SEM {
	
	private ArrayList<Estacionamiento> estacionamientos;
	private ArrayList<Infraccion> infracciones;
	private ArrayList<Zona> zonas;
	private ArrayList<Compra> compras;
	private ArrayList<Observador> observadores;
	private LocalTime inicioFranjaHoraria;
	private LocalTime finFranjaHoraria;
	private Double precioHora;
	
	public SEM(LocalTime inicioFranjaH, LocalTime finFranjaH, Double precioH) {
		this.inicioFranjaHoraria 	= inicioFranjaH;
		this.finFranjaHoraria 		= finFranjaH;
		this.precioHora 			= precioH;
		this.estacionamientos 		= new ArrayList<Estacionamiento>();
		this.infracciones 			= new ArrayList<Infraccion>();
		this.zonas 					= new ArrayList<Zona>();
		this.compras 				= new ArrayList<Compra>();
		this.observadores 			= new ArrayList<Observador>();
		
	}
	public ArrayList<Compra> getCompras(){
		return compras;
	}
	
	public void nuevaZonaMedida(Zona zona) {
		zonas.add(zona);
	}

	public LocalTime getFinDeFranjaHoraria() {
		return finFranjaHoraria;
	}

	public Double getPrecioHora() {
		return precioHora;
	}
	
	public ArrayList<Estacionamiento> getEstacionamientos() {
		return this.estacionamientos;
	}
	
	private LocalTime getFinFranja() {
		return this.finFranjaHoraria;
	}	
	
	public LocalTime getInicioFranjaHoraria() {
		return inicioFranjaHoraria;
	}
	
	public ArrayList<Infraccion> getInfracciones() {
		return this.infracciones;
	}

	public void setInicioFranjaHoraria(LocalTime inicioFranjaHoraria) {
		this.inicioFranjaHoraria = inicioFranjaHoraria;
	} 
	
	public void suscribirObservador(Observador obser) {
		observadores.add(obser);
	}
	
	public void dessuscribirObservador(Observador obser) {
		observadores.remove(obser);
	}
	
	public void iniciarEstacionamientoViaCompra(CompraPuntual compraP) {
		this.estacionamientos.add(new EstacionamientoViaCompra(compraP));
		this.compras.add(compraP);
		this.observadores.stream().forEach(observador -> observador.notificacionInicioEstacionamiento());
	}
	
	public void iniciarEstacionamientoViaApp(LocalTime horaInicio, String patente, String nroCelular) {
		estacionamientos.add(new EstacionamientoViaApp(horaInicio, patente, nroCelular));
		this.observadores.stream().forEach(observador -> observador.notificacionInicioEstacionamiento());
	}

	public InfoEstacionamiento finalizarEstacionamientoViaApp(String patente) {
		Estacionamiento est = encontrarEstacionamientoVigente(patente);
		est.setHoraFin(LocalTime.now());
		this.observadores.stream().forEach(observador -> observador.notificacionFinEstacionamiento());
		return new InfoEstacionamiento(est.getHoraInicio(), est.getHoraFin());
		
	}

	public boolean esVigente(String patente) {
		return 	estacionamientoConpatenteEIniciadoHoy(patente)	.stream()
																.anyMatch(estacionamiento -> estacionamiento
																.esVigente());

	}
	
	private Estacionamiento encontrarEstacionamientoVigente(String patente) {
		return estacionamientoConpatenteEIniciadoHoy(patente)	.stream()
																.filter(estacionamiento-> estacionamiento.esVigente())
																.toList()
																.get(0);
	}
	
	private List<Estacionamiento> estacionamientoConpatenteEIniciadoHoy(String patente){
		return estacionamientosConPatente(patente)	.stream()
													.filter(estacionamiento -> estacionamiento.getFecha().isEqual(LocalDate.now()))
													.toList();
	}
	
	private List<Estacionamiento> estacionamientosConPatente(String patente) {
		List<Estacionamiento> estacionamientosConPatente = estacionamientos	.stream()
																			.filter(estacionamiento -> estacionamiento.getPatente().equals(patente))
																			.toList();
		return estacionamientosConPatente;
	}

	public boolean esZonaMedida(String posicionUsuario) {
		return zonas.stream().anyMatch(zona->zona.pertenece(posicionUsuario));
	}

	
	public void finalizarTodosLosEstacionamientosVigentes() {
		this.getEstacionamientos().stream()
								  .filter(estacionamiento -> estacionamiento.esVigente())
								  .forEach(estacionamiento -> estacionamiento.setHoraFin(this.getFinFranja()));	
	}

		public void registrarInfraccion(Infraccion infraccion) {
		this.infracciones.add(infraccion);
	}
		public void registrarCompraPuntual(CompraPuntual compraPuntual) {
			this.registrarCompra(compraPuntual);
			
		}
		public void registrarRecargaCredito(RecargaCredito recargaCredito) {
			this.registrarCompra(recargaCredito);
			this.observadores.stream().forEach(observador -> observador.notificacionRecargaDECredito());
		}
		
		private void registrarCompra(Compra compra) {
			compras.add(compra);
		}
	
	




}
