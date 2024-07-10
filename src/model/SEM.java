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
	private LocalTime InicioFranjaHoraria;
	private LocalTime finFranjaHoraria;
	private Double precioHora;


	public void iniciarEstacionamientoViaApp(LocalTime horaInicio, String patente, String nroCelular) {
		estacionamientos.add(new EstacionamientoViaApp(horaInicio, patente, nroCelular));
		
	}
	
	public void iniciarEstacionamientoViaCompraPuntual(CompraPuntual compraP) {
		estacionamientos.add(new EstacionamientoViaCompra(compraP));
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

	public InfoEstacionamiento finalizarEstacionamientoViaApp(String patente) {
		Estacionamiento est = encontrarEstacionamientoVigente(patente);
		est.setHoraFin(LocalTime.now());
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

	private LocalTime getFinFranja() {
		return this.finFranjaHoraria;
	}	
	
	public void registrarInfraccion(Infraccion infraccion) {
		this.infracciones.add(infraccion);
	}

	public LocalTime getInicioFranjaHoraria() {
		return InicioFranjaHoraria;
	}

	public void setInicioFranjaHoraria(LocalTime inicioFranjaHoraria) {
		InicioFranjaHoraria = inicioFranjaHoraria;
	} 




}
