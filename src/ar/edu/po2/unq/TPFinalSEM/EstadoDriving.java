package ar.edu.po2.unq.TPFinalSEM;

public class EstadoDriving extends EstadoDeDesplazamiento {
	
	
	
	@Override
	public void driving(AppDeEstacionamiento app) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void walking(AppDeEstacionamiento app) {
		app.setEstadoDeDesplazamiento(new EstadoWalking());
		app.getEstadoDeDesplazamiento().setUbicacionEstacionamiento(getUbicacionActual());
		app.alertarOIniciarSiCumple(getUbicacionActual());
		
	}

	@Override
	protected void setUbicacionEstacionamiento(Zona ubicacionActual2) {
		// TODO Auto-generated method stub
		
	}



}
