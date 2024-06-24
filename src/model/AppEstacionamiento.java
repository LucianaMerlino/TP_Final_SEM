package model;


public class AppEstacionamiento {
	private SEM sem;
	private Celular celular;
	private String patente;
	private ModoEstacionamiento modo;
	
	public void setModoManual() {
		modo = new ModoManual(sem, celular, patente);
	}
	
	public AppEstacionamiento(SEM s, Celular c, String patente) {
		this.sem = s;
		this.celular = c;
		this.patente = patente;
		this.modo = new ModoManual(s,c,patente);
	}
	
	public void setModoAutomatico() {
		modo = new ModoAutomatico(sem, celular, patente);
	}

	public String iniciarEstacionamiento(int horaInicio) {
		return modo.iniciarEstacionamiento(horaInicio);
	}
		

	public String finalizarEstacionamiento(int nroCelular) {
		return modo.finalizarEstacionamiento(nroCelular);
	
	}

	public Integer saldoDisponible() {
		return celular.getCredito();
	}
	
	

}
