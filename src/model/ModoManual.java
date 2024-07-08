package model;

import java.time.LocalTime;

public class ModoManual extends ModoEstacionamiento{
	
	
	public ModoManual(SEM sem, Celular celular, String patente) {
		super(sem, celular, patente);
	}
	
	public String mensajeIniciarEstConCredito(LocalTime horaInicio, LocalTime horaFin) {
		return "Hora de comienzo de estacionamiento " + horaInicio + "\n" +
				"Hora estimada de fin de estacionamiento " + horaFin;
	}
	
	public String mensajeFinEstacionamiento(LocalTime horaInicio, LocalTime horaFin, Double duracion, Double cosot) {
		return "Hora comienzo de estacionamiento: " + horaInicio + "\n"+
				"Hora fin de estacionamiento: " + horaFin + "\n" +
				"Duración del estacionamiento: " + duracion + "\n" +
				"Costo total del estacionamiento: " + cosot;
	}

	@Override
	protected void darInicio() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void darFin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void configurarApp(AppEstacionamiento appEstacionamiento) {
		
	}




}
