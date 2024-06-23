package model;


public class AppEstacionamiento {
	private SEM sem;
	private Celular celular;
	private String patente;
	
	
	public AppEstacionamiento(SEM s, Celular c, String p) {
		this.sem = s;
		this.celular = c;
		this.patente = p;
	}

	public String iniciarEstacionamiento(int horaInicio) {
		if (this.tieneSuficienteCreditoParaEstacionar()) {
			sem.iniciarEstacionamientoViaApp(horaInicio, this.horaFin(horaInicio), celular.getNumero(), this.patente);
		return "Hora de comienzo de estacionamiento " + horaInicio + "\n" +
				"Hora estimada de fin de estacionamiento " + this.horaFin(horaInicio);
		}else {
			return "Saldo insuficiente. Estacionamiento no permitido."; //Esto podría haberse modelado con una excepción
	}
		
	}

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
		return "Hora comienzo de estacionamiento: " + infoEstacionamiento.gethInicio() + "\n"+
				"Hora comienzo de estacionamiento: " + infoEstacionamiento.gethFin() + "\n" +
				"Duración del estacionamiento: " + infoEstacionamiento.duracion() + "\n" +
				"Costo total del estacionamiento: " + costoEstacionamiento;
	
	}

	public Integer saldoDisponible() {
		return celular.getCredito();
	}
	
	

}
