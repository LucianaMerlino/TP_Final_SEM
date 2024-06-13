package ar.edu.po2.unq.TPFinalSEM;


public class ModoManual extends AppDeEstacionamiento {

	public ModoManual(SEM s, EstadoDeDesplazamiento e) {
		super.setsEM(s);
		super.setEstadoDeDesplazamiento(e);
	}
	

	public String mensajeDeInicio() {
		return "Hora de inicio de estacionamiento: " + super.getHoraInicio() +  "Hora máxima de estacionamiento: " + this.calcularHoraMaxima();
		
	}
	
	private String calcularHoraMaxima() {
		if ((super.getCelular().getCredito() / super.getsEM().precioHora() + super.getHora()) < super.getsEM().getFinFranja()){
			return "" + super.getCelular().getCredito() / super.getsEM().precioHora() + super.getHora();
		} else {
			return "" + super.getsEM().getFinFranja();
		}
	}
	

	public String mensajeDeFinalizacion() {
		return "Hora inicio estacionamiento: " + super.getHoraInicio() +
				"Hora fin estacionamiento: " + super.getHoraFin() + 
				"Tiempo de estacionamiento: " + super.getDuracion()  + 
				"Costo del estacionamiento: " + super.getCostoTotal();
				
	}

	public AppDeEstacionamiento cambiarModoApp() {
		return new ModoAutomatico(super.getsEM(), super.getCelular());
	}


	@Override
	protected void iniciarEstacionamientoAutomatico(String patente2, int numero) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void finalizarEstacionamientoAutomatico(String patente2) {
		// TODO Auto-generated method stub
		
	}
	
}