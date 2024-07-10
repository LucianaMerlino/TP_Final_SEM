package model;

public class Celular {
	
	private String numero;
	private Double credito;
	private GPS gps;
	
	public Celular(String numero, Double credito, GPS gps) {
		
		this.numero = numero;
		this.credito = credito;
		this.gps = gps;
	}

	public String getNumero() {
		return numero;
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
