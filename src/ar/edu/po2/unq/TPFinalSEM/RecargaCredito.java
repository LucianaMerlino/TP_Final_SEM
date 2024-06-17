package ar.edu.po2.unq.TPFinalSEM;

import java.time.LocalDateTime;

public class RecargaCredito extends Compra {
	
	private Double monto;
	private Celular celular;
	
	public RecargaCredito(int nroControl, Double monto, Celular celular) {
		
		this.nroControl = nroControl;
		this.fechaHora = LocalDateTime.now();
		this.monto = monto;
		this.celular = celular;
		
	}

}
