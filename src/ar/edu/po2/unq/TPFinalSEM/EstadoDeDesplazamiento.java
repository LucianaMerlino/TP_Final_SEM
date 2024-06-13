package ar.edu.po2.unq.TPFinalSEM;

public abstract class EstadoDeDesplazamiento {

	private Zona ubicacionActual = gps.getZonaActual();
	
	
	public void activarDesplazamiento() {
		// TODO Auto-generated method stub
		
	}

	public abstract void driving(AppDeEstacionamiento app);


	public abstract void walking(AppDeEstacionamiento app);

	public Zona getUbicacionActual() {
		return ubicacionActual;
	}

	public void setUbicacionActual(Zona ubicacionActual) {
		this.ubicacionActual = ubicacionActual;
	}

	protected abstract void setUbicacionEstacionamiento(Zona ubicacionActual2);
	
		
	
}
