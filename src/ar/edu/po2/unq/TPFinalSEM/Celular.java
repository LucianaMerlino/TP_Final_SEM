package ar.edu.po2.unq.TPFinalSEM;

public class Celular {
	
	private int numero;
	private int credito;
	
	public int getCredito() {
		return credito;
		
	}

	public void consumirCredito(int costoTotal) {
		this.credito -= costoTotal;
		
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
}
