package model;

public class AlertaActivada implements AsistenciaAlUsuario{

	public String alertaDeInicio() {
		return "Alerta de inicio de estacionamiento, por favor inicie su estacionamineto Medido.";
		
	}

	public String alertaDeFin() {
		return "Alerta de fin de estacionamiento, por favor finalice su estacionamineto Medido.";
		
	}

	public void configurarApp(AppEstacionamiento appEstacionamiento) {
		appEstacionamiento.setEstadoDesplazamiento(new EstadoActivado(appEstacionamiento, appEstacionamiento.getCelular().getGps()));
		
	}

}
