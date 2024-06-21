package model;

public class Celular {
	
	private int numero;
	private Double credito;
	

	public Celular(int numero) {
		
		this.numero = numero;
		this.credito = 0.0;
	}

	public int getNumero() {
		return numero;
	}
	
	public Double getCredito() {
		return credito;
	}
	
	public void cargarCredito(Double monto) {
		this.credito += monto;
	}
	
	public void consumirCredito(Double monto) {
		this.credito -= monto;
	}

}
