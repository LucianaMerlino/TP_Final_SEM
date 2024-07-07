package model;

import java.time.LocalTime;

public class ModoAutomatico extends ModoEstacionamiento {


	public ModoAutomatico(SEM sem, Celular celular, String patente) {
		super(sem, celular, patente);
	}



	@Override
	protected String mensajeIniciarEstConCredito(LocalTime horaInicio, LocalTime horaFin) {
		return "Hora de comienzo de estacionamiento automático :" + horaInicio + "\n" +
				"Su saldo le permitirá mantener el estacionamiento hasta: " + horaFin;
	}

	@Override
	protected String mensajeFinEstacionamiento(LocalTime horaInicio, LocalTime horaFin, Double duracion,
			Double costo) {
		return "El estacionamiento automatico ha comenzado a las " + horaInicio + "y ha finalizado a las " + horaFin + 
				"\n" + "Duración del estacionamiento: " + duracion + "\n" +
				"Costo total del estacionamiento: " + costo;
	}



	@Override
	protected void darInicio() {
		super.iniciarEstacionamiento(LocalTime.now()); //poner localTime
		
	}



	@Override
	protected void darFin() {
		super.finalizarEstacionamiento(super.getCelular().getNumero());
	}

}
