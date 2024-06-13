package ar.edu.po2.unq.TPFinalSEM;

public class EstadoWalking extends EstadoDeDesplazamiento {

	private Zona ubicacionEstacionamiento;
	
	
	public void setUbicacionEstacionamiento(Zona ubicacionActual) {
		this.ubicacionEstacionamiento = ubicacionActual;
	}
	
	public Zona getUbicacionEstacionamiento() {
		return this.ubicacionEstacionamiento;
	}
	@Override
	public void driving(AppDeEstacionamiento app) {
		app.setEstadoDeDesplazamiento(new EstadoDriving());
		if (this.ubicacionEstacionamiento == this.getUbicacionActual()) {
			app.alertarOFinalizarSiCumple(getUbicacionEstacionamiento());
		}
		
	}

	@Override
	public void walking(AppDeEstacionamiento app) {
		// TODO Auto-generated method stub
		
	}

	
}
