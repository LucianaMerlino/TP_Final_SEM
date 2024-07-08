package ar.edu.po2.unq.TPFinalSEM;

import java.time.LocalTime;
import java.time.Period;

public class EstacionamientoViaCompra extends Estacionamiento {
	
	private CompraPuntual compraPuntual;
	
	public EstacionamientoViaCompra(CompraPuntual compraPuntual, LocalTime horaInicio,
									LocalTime horaFin, String patente) {
	super(horaInicio, horaFin, patente);
		
		this.compraPuntual = compraPuntual;
		this.horaInicio = horaInicio; // codigo original: compraPuntual.getHora()
		this.horaFin = this.horaInicio.plusMinutes((long) (compraPuntual.getHoras()/60));
		this.patente = compraPuntual.getPatente();
		
	}

}
