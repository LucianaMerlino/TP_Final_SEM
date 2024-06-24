package model;

public class ModoManual extends ModoEstacionamiento{
	
	
	public ModoManual(SEM sem, Celular celular, String patente) {
		this.sem = sem;
		this.celular = celular;
		this.patente = patente;
	}
	
	public String mensajeIniciarEstConCredito(int horaInicio, int horaFin) {
		return "Hora de comienzo de estacionamiento " + horaInicio + "\n" +
				"Hora estimada de fin de estacionamiento " + horaFin;
	}
	
	public String mensajeFinEstacionamiento(int horaInicio, int horaFin, int duracion, int cosot) {
		return "Hora comienzo de estacionamiento: " + horaInicio + "\n"+
				"Hora fin de estacionamiento: " + horaFin + "\n" +
				"Duración del estacionamiento: " + duracion + "\n" +
				"Costo total del estacionamiento: " + cosot;
	}

}
