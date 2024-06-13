package ar.edu.po2.unq.TPFinalSEM;

public class AlertaActivada implements Alerta {

	@Override
	public String alertaFinEstacionamiento() {
		return "Usted ha finalizado su estacionamiento medido, por favor finalice su estacionamiento";


	}

	@Override
	public String alertaInicioEstacionamiento() {
		return "Usted se encuentra en una zona de estacionamiento medido, por favor inicie su estacionamiento";

	}
	


}
