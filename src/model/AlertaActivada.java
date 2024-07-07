package model;

public class AlertaActivada extends AsistenciaAlUsuario{

	@Override
	public String alertaDeInicio() {
		return "Alerta de inicio de estacionamiento, por favor inicie su estacionamineto Medido.";
		
	}

	@Override
	public String alertaDeFin() {
		return "Alerta de fin de estacionamiento, por favor finalice su estacionamineto Medido.";
		
	}

}
