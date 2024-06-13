package ar.edu.po2.unq.TPFinalSEM;

public class ModoAutomatico extends AppDeEstacionamiento {
	
	
	private EstadoDeDesplazamiento estadoDeDesplazamiento = new EstadoWalking();
	
	public ModoAutomatico(SEM s, Celular c){
		super.setsEM(s);
		super.setCelular(c);
	}
	
	
	public AppDeEstacionamiento cambiarModo() {
		return new ModoManual(super.getsEM(), super.getEstadoDeDesplazamiento());
	}
	
	
	public void iniciarEstacionamientoAutomatico(String patente, int nroCelular) {
		super.iniciarEstacionamiento(patente, nroCelular);
	}
	public String mensajeDeFinalizacion() {
		return "Se ha finalizado el esatcionamiento medido de forma automática";
	}
	
	
	public String mensajeDeInicio() {
		return "Se ha iniciado el esatcionamiento medido de forma automática";
	}
	
	protected void finalizarEstacionamientoAutomatico(String patente2) {
		super.finalizarEstacionamiento(patente2);
	}
}
