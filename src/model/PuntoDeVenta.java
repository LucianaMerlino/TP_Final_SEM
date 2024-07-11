package model;

public class PuntoDeVenta {

	private SEM sem;
	
	public PuntoDeVenta(SEM sem) {
		this.sem = sem;
	}

	public void crearEstacionamiento(int nroControl, int horas, String patente) {
		CompraPuntual compraPuntual = new CompraPuntual(nroControl, this.sem, this, horas, patente);
		this.sem.registrarCompraPuntual(compraPuntual);
		this.sem.iniciarEstacionamientoViaCompra(compraPuntual);
	}

	public void recargarCredito(int nroControl, Double monto, Celular celular) {
		RecargaCredito recargaCredito = new RecargaCredito(nroControl, this.sem, this, monto, celular);
		this.sem.registrarRecargaCredito(recargaCredito);
		//this.sem.recargarCredito(recargaCredito);
	}
	
}