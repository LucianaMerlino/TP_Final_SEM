package model;

public class EstadoDriving extends EstadoDesplazamiento {

	public EstadoDriving(AppEstacionamiento app, GPS gps) {
		super(app, gps);
	}

	@Override
	public void walking() {
		getAppEstacionamiento().setEstadoDesplazamiento (new EstadoWalking(getAppEstacionamiento(), getGps()));
		getAppEstacionamiento().posibleInicioEstacionamiento(getGps().posicionUsuario());
		
	}

	@Override
	public void driving() {
	}
	

}
