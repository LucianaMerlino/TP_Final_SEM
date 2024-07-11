package model;

import java.time.LocalDateTime;

public class RecargaCredito extends Compra {
	
	private Double monto;
	private Celular celular;
	
	public RecargaCredito(int nroControl, SEM sem, PuntoDeVenta puntoDeVenta, Double monto, Celular celular) {
		super(nroControl, sem, puntoDeVenta, LocalDateTime.now());
		this.monto = monto;
		this.celular = celular;
	}

	public Double getMonto() {
		return monto;
	}

	public Celular getCelular() {
		return celular;
	}

}