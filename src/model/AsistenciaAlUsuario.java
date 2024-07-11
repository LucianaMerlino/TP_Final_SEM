package model;

public abstract class AsistenciaAlUsuario {

	public abstract String alertaDeInicio();

	public abstract String alertaDeFin();

	protected abstract void configurarApp(AppEstacionamiento appEstacionamiento);

}
