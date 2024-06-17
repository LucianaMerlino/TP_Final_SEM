package ar.edu.po2.unq.TPFinalSEM;

public class PuntoDeVenta {
	
	public CompraPuntual crearCompraPuntual(int nroControl, Double horas, String patente) {
		
		return new CompraPuntual(nroControl, horas, patente);
		
	}
	
	public RecargaCredito crearRecargaCredito(int nroControl, Double monto, Celular celular) {
		
		return new RecargaCredito(nroControl, monto, celular);
	}

}
