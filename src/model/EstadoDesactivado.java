package model;

public class EstadoDesactivado extends EstadoDesplazamiento{

	public EstadoDesactivado(AppEstacionamiento app, GPS gps) {
		super(app, gps);
		ModoManual modoManual = new ModoManual(app.getSEM(), app.getCelular(), app.getPatente());
		AlertaDesactivada alertadesactivada = new AlertaDesactivada();
		app.setModo(modoManual);
		app.setAsistenciaAlUsuario(alertadesactivada);
	}

	@Override
	public void walking() {
	}

	@Override
	public void driving() {
	}

}
