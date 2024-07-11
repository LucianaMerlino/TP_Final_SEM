package model;

public class EstadoActivado extends EstadoDesplazamiento{
	
	public EstadoActivado(AppEstacionamiento app, GPS gps) {
		super(app, gps);
	}

	public void walking() {
		getAppEstacionamiento().setEstadoDesplazamiento(new EstadoWalking(getAppEstacionamiento(), getGps()));
	}
	
	public void driving() {
		getAppEstacionamiento().setEstadoDesplazamiento(new EstadoDriving(getAppEstacionamiento(), getGps()));
	}
}
