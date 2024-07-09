package model;

<<<<<<< HEAD
import java.time.LocalTime;

public class EstacionamientoViaApp extends Estacionamiento {
	
	private String nroCelular;

	public EstacionamientoViaApp(LocalTime horaIni, String patente, String nCelular) {
		super(horaIni, patente);
		nroCelular = nCelular;
		
	}

	public String getNroCelular() {
		return nroCelular;
	}

	
	
=======
import java.time.LocalDateTime;

public class EstacionamientoViaApp extends Estacionamiento {
	
	private Celular celular;
	
	public EstacionamientoViaApp(LocalDateTime horaInicio, String patente, Celular celular) {
		super(horaInicio, null, patente);
		this.celular = celular;
	}
	
	public int getNroCelular() {
		return this.celular.getNumero();
	}
>>>>>>> 1c74bee497cf6335336915acd2004e6037689274

}
