package model;

public class EstadoDesactivado extends EstadoDesplazamiento{

	public EstadoDesactivado(AppEstacionamiento app, GPS gps) {
		super(app, gps);
	}

	@Override
	public void walking() {
	}

	@Override
	public void driving() {
	}

}
