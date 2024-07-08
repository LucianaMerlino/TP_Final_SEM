package model;

import java.time.LocalDateTime;

public class RecargaCredito extends Compra {
	
	private Double monto;
	private Celular celular;
	
	public RecargaCredito(int nroControl, PuntoDeVenta puntoDeVenta, Double monto, Celular celular) {
		super(nroControl, puntoDeVenta, LocalDateTime.now());
		this.monto = monto;
		this.celular = celular;
	}

}