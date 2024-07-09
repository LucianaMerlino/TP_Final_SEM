package model;

public class PuntoDeVenta {
	
	public CompraPuntual crearCompraPuntual(int nroControl, int horas, String patente) {
		
		return new CompraPuntual(nroControl, this, horas, patente);
		
	}
	
	public RecargaCredito crearRecargaCredito(int nroControl, Double monto, Celular celular) {
		
		return new RecargaCredito(nroControl, this, monto, celular);
	}

}