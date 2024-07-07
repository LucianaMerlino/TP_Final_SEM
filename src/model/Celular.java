package model;

public class Celular {
	
	private String numero;
	private long credito;
	
	public Celular(String numero) {
		
		this.numero = numero;
		this.credito = (long) 0;
	}

	public String getNumero() {
		return numero;
	}

	public long getCredito() {
		// TODO Auto-generated method stub
		return this.credito;
	}

	public void descontarCredito(double costoEstacionamiento) {
		// TODO Auto-generated method stub
		
	}

}
