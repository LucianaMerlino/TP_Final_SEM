package model;


public class AppEstacionamiento {
	private SEM sem;
	private Celular celular;
	
	
	public AppEstacionamiento(SEM s, Celular c) {
		this.sem = s;
		this.celular = c;
	}

	public void iniciarEstacionamiento(int horaInicio) {
		sem.iniciarEstacionamientoViaApp(horaInicio, this.horaFin(horaInicio), celular.getNumero());
		
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
	
	

}
