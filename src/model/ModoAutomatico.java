package model;

public class ModoAutomatico extends ModoEstacionamiento {


	public ModoAutomatico(SEM sem, Celular celular, String patente) {
		this.sem = sem;
		this.celular = celular;
		this.patente = patente;
	}



	@Override
	protected String mensajeIniciarEstConCredito(int horaInicio, int horaFin) {
		return "Hora de comienzo de estacionamiento automático :" + horaInicio + "\n" +
				"Su saldo le permitirá mantener el estacionamiento hasta: " + horaFin;
	}

	@Override
	protected String mensajeFinEstacionamiento(int horaInicio, int horaFin, int duracion, int costo) {
		return "El estacionamiento automatico ha comenzado a las " + horaInicio + "y ha finalizado a las " + horaFin + 
				"\n" + "Duración del estacionamiento: " + duracion + "\n" +
				"Costo total del estacionamiento: " + costo;
	}

}
