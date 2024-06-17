package ar.edu.po2.unq.TPFinalSEM;

import java.time.LocalDateTime;

public class EstacionamientoViaApp extends Estacionamiento {
	
	public EstacionamientoViaApp(LocalDateTime horaInicio, LocalDateTime horaFin, String patente, boolean estaVigente) {
		super(horaInicio, horaFin, patente, estaVigente);
	}
}
