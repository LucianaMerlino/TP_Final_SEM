package ar.edu.po2.unq.TPFinalSEM;

public class Celular {
	
	private int numero;
	private Double credito;
	
	public Celular(int numero, Double credito) {
		this.numero = numero;
		this.credito = credito;
	}
	
	/**
	 * Agrego el metodo setCredito(credito) para que el sem le pueda cargar credito
	 * */
	 
	 public Double getCredito() {
		return this.credito;
	}
	 
	public void setCredito(Double credito) {
	 	this.credito += credito;
	}

	public void consumirCredito(int costoTotal) {
		this.credito -= costoTotal;
		
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
}
