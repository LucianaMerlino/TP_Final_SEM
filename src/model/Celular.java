package model;

public class Celular {
	
	private String numero;
	private Double credito;
	private GPS gps;
	
	public Celular(String numero) {
		this.numero = numero;
		this.credito = 0.0;
		this.gps = new GPS();
	}

	public String getNumero() {
		return numero;
	}
	
	
	public GPS getGps() {
		return gps;
	}

	public void cargarCredito(Double monto) {
		this.credito += monto;
	}
	
	public void consumirCredito(Double monto) {
		this.credito -= monto;
	}

	public Double getCredito() {
		return this.credito;
	}


	public GPS getGps() {
		return gps;
	}

}
