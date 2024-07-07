package model;

public class EstadoWalking extends EstadoDesplazamiento {
	

	public EstadoWalking(AppEstacionamiento app, GPS gps) {
		super(app, gps);
	}

	@Override
	public void walking() {
	}

	@Override
	public void driving() {
		getAppEstacionamiento().setEstadoDesplazamiento (new EstadoDriving(getAppEstacionamiento(), getGps()));
		getAppEstacionamiento().posibleFinEstacionamiento(getGps().posicionUsuario());
	}

}
