package model;

public class Celular {
	
	private String numero;
	private long credito;
	private GPS gps;
	
<<<<<<< HEAD
	public Celular(String numero) {
=======

	public Celular(int numero) {
>>>>>>> 1c74bee497cf6335336915acd2004e6037689274
		
		this.numero = numero;
		this.credito = (long) 0;
	}

	public String getNumero() {
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

	public long getCredito() {
		// TODO Auto-generated method stub
		return this.credito;
	}

	public void descontarCredito(double costoEstacionamiento) {
		// TODO Auto-generated method stub
		
	}

	public GPS getGps() {
		return gps;
	}

}
