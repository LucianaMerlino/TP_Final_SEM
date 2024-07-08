package ar.edu.po2.unq.TPFinalSEM;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class RecargaCredito extends Compra {
	
	private Double monto;
	private Celular celular;
	
	public RecargaCredito(int nroControl, Double monto, Celular celular) {
		
		this.nroControl = nroControl;
		this.hora = LocalTime.now();
		this.monto = monto;
		this.celular = celular;
		
	}
	/**
	 * Agrego el método get monto para que el sem pueda cargar el credito:
	 * */
	public Double getMonto() {
		
		return this.monto;
	}
		

}
