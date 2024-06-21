package ar.edu.po2.unq.TPFinalSEM;

import java.time.LocalDateTime;
import java.time.Period;

public class EstacionamientoViaCompra extends Estacionamiento {
	
	private CompraPuntual compraPuntual;
	
	public EstacionamientoViaCompra(CompraPuntual compraPuntual, LocalDateTime horaInicio,
									LocalDateTime horaFin, String patente) {
	super(horaInicio, horaFin, patente);
		
		this.compraPuntual = compraPuntual;
		this.horaInicio = compraPuntual.getFechaHora();
		this.horaFin = this.horaInicio.plusMinutes((long) (compraPuntual.getHoras()/60));
		this.patente = compraPuntual.getPatente();
		
	}

}
