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

}
