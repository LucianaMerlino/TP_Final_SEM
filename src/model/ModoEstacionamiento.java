package model;

import java.time.LocalTime;

public abstract class ModoEstacionamiento {
	
	private SEM sem;
	private Celular celular;
	private String patente;
	
	public ModoEstacionamiento(SEM sem, Celular celular, String patente) {
		this.sem = sem;
		this.celular = celular;
		this.patente = patente;
	}

	public String iniciarEstacionamiento(LocalTime horaInicio) {
		if (this.tieneSuficienteCreditoParaEstacionar()) {
			sem.iniciarEstacionamientoViaApp(horaInicio, celular.getNumero(), this.patente);
			return mensajeIniciarEstConCredito(horaInicio, this.horaFin(horaInicio));
		}else {
			return "Saldo insuficiente. Estacionamiento no permitido."; //Esto podría haberse modelado con una excepción
	}
		
	}
	
	public Celular getCelular() {
		return this.celular;
	}

	protected abstract String mensajeIniciarEstConCredito(LocalTime horaInicio, LocalTime horaFin);

	private boolean tieneSuficienteCreditoParaEstacionar() {
		return celular.getCredito()>= sem.getPrecioHora();
	}

	private LocalTime horaFin(LocalTime horaInicio) {
		if (this.tieneSuficienteCredito(horaInicio)) {
			return this.sem.getFinDeFranjaHoraria();
			} else {
			return horaInicio.plusHours(this.calcularTiempoMaximo());
		}
		
	}
	
	private Boolean tieneSuficienteCredito(LocalTime horaInicio) {
		return horaInicio.plusHours(this.calcularTiempoMaximo()).isAfter(this.sem.getFinDeFranjaHoraria()) 
				|| horaInicio.plusHours(this.calcularTiempoMaximo()).equals(this.sem.getFinDeFranjaHoraria());
		//horaInicio.plusHours(this.calcularTiempoMaximo()) >= this.sem.getFinDeFranjaHoraria()
	}

	private int calcularTiempoMaximo() {
		return (int) (this.celular.getCredito() / this.sem.getPrecioHora());
	}

	public String finalizarEstacionamiento(String nroCelular) {
		InfoEstacionamiento infoEstacionamiento = sem.finalizarEstacionamientoViaApp(nroCelular);
		double costoEstacionamiento =  infoEstacionamiento.duracion() * sem.getPrecioHora();
		celular.descontarCredito(costoEstacionamiento);
		return mensajeFinEstacionamiento(infoEstacionamiento.gethInicio(), infoEstacionamiento.gethFin(), 
										infoEstacionamiento.duracion(), costoEstacionamiento);
	
	}

	protected abstract String mensajeFinEstacionamiento(LocalTime gethInicio, LocalTime gethFin, Double duracion,
			Double costoEstacionamiento);

	protected abstract void darInicio();

	protected abstract void darFin();

}
