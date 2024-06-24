package model;

public abstract class ModoEstacionamiento {
	
	protected SEM sem;
	protected Celular celular;
	protected String patente;
	

	public String iniciarEstacionamiento(int horaInicio) {
		if (this.tieneSuficienteCreditoParaEstacionar()) {
			sem.iniciarEstacionamientoViaApp(horaInicio, this.horaFin(horaInicio), celular.getNumero(), this.patente);
		return mensajeIniciarEstConCredito(horaInicio, this.horaFin(horaInicio));
		}else {
			return "Saldo insuficiente. Estacionamiento no permitido."; //Esto podría haberse modelado con una excepción
	}
		
	}

	protected abstract String mensajeIniciarEstConCredito(int horaInicio, int horaFin);

	private boolean tieneSuficienteCreditoParaEstacionar() {
		return celular.getCredito()>= sem.getPrecioHora();
	}

	private int horaFin(int horaInicio) {
		if (this.tieneSuficienteCredito(horaInicio)) {
			return this.sem.getFinDeFranjaHoraria();
			} else {
			return horaInicio + this.calcularTiempoMaximo();
		}
		
	}
	
	private Boolean tieneSuficienteCredito(int horaInicio) {
		return horaInicio + this.calcularTiempoMaximo() >= this.sem.getFinDeFranjaHoraria();
	}

	private int calcularTiempoMaximo() {
		return this.celular.getCredito() / this.sem.getPrecioHora();
	}

	public String finalizarEstacionamiento(int nroCelular) {
		InfoEstacionamiento infoEstacionamiento = sem.finalizarEstacionamientoViaApp(nroCelular);
		int costoEstacionamiento =  infoEstacionamiento.duracion() * sem.getPrecioHora();
		celular.descontarCredito(costoEstacionamiento);
		return mensajeFinEstacionamiento(infoEstacionamiento.gethInicio(), infoEstacionamiento.gethFin(), 
										infoEstacionamiento.duracion(), costoEstacionamiento);
	
	}

	protected abstract String mensajeFinEstacionamiento(int gethInicio, int gethFin, int duracion,
			int costoEstacionamiento);

}
