package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

//import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.BatchAllocator.Slicing;

public class SEM {
	
	private ArrayList<Estacionamiento> estacionamientos;
	private LocalTime finFranjaHoraria;
	private Double precioHora;

	public void iniciarEstacionamientoViaApp(LocalTime horaInicio, String patente, String nroCelular) {
		estacionamientos.add(new EstacionamientoViaApp(horaInicio, patente, nroCelular));
		
	}

	public LocalTime getFinDeFranjaHoraria() {
		return finFranjaHoraria;
	}

	public Double getPrecioHora() {
		return precioHora;
	}

	public InfoEstacionamiento finalizarEstacionamientoViaApp(String nroCelular) {
		
		return new InfoEstacionamiento(null, null);
	}

	public boolean esVigente(String patente) {
		Stream<Estacionamiento> estacionamientosInciadosHoy = 
				estacionamientosConPatente(patente).stream().filter(estacionamiento -> estacionamiento.getFecha().isEqual(LocalDate.now()));
		return 	estacionamientosInciadosHoy.anyMatch(estacionamiento -> estacionamiento.getHoraFin().isAfter(LocalTime.now()));

	}
	
	private List<Estacionamiento> estacionamientosConPatente(String patente) {
		List<Estacionamiento> estacionamientosConPatente = 
				estacionamientos.stream().filter(estacionamiento -> estacionamiento.getPatente().equals(patente)).toList();
		return estacionamientosConPatente;
	}

	public boolean esZonaMedida(String posicionUsuario) {
		// TODO Auto-generated method stub
		return false;
	}




}
