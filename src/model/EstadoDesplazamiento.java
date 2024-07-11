package model;

public abstract class EstadoDesplazamiento {
	
	private AppEstacionamiento appEstacionamiento;
	private GPS gps;
	
	public EstadoDesplazamiento(AppEstacionamiento app, GPS gps) {
		this.appEstacionamiento = app;
		this.gps = gps;
	}
	
	public abstract void walking();
	
	public abstract void driving();

	public GPS getGps() {
		return gps;
	}

	public AppEstacionamiento getAppEstacionamiento() {
		return appEstacionamiento;
	}
	

}
