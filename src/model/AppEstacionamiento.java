package model;

import java.time.LocalTime;

public class AppEstacionamiento {
	private SEM sem;
	private Celular celular;
	private String patente;
	private ModoEstacionamiento modo;
	private EstadoDesplazamiento estadoDesplazamiento; 
	private AsistenciaAlUsuario asistencia;
	private String posicionInicioEstacionamiento;
	
	public void setModo(ModoEstacionamiento modoEstacionamiento) {
		modo =  modoEstacionamiento;
		modo.configurarApp(this);
	}
	
	public Celular getCelular() {
		return celular;
	}
	
	public AppEstacionamiento(SEM s, Celular c, String patente, ModoEstacionamiento modo) {
		this.sem = s;
		this.celular = c;
		this.patente = patente;
		this.modo = modo;
	}
	

	public String iniciarEstacionamiento(LocalTime horaInicio) {
		return modo.iniciarEstacionamiento(horaInicio);
	}
		

	public String finalizarEstacionamiento(String nroCelular) {
		return modo.finalizarEstacionamiento(nroCelular);
	
	}

	public long saldoDisponible() {
		return celular.getCredito().longValue();
	}
	
	public void walking() {
		estadoDesplazamiento.walking();
	}
	
	public void driving() {
		estadoDesplazamiento.driving();
	}

	public void setEstadoDesplazamiento(EstadoDesplazamiento estado) {
		estadoDesplazamiento = estado;
		
	}

	public void posibleInicioEstacionamiento(String posicionUsuario) {
		if ((!(sem.esVigente(patente))) && (sem.esZonaMedida(posicionUsuario))) {
			posicionInicioEstacionamiento = posicionUsuario;
			modo.darInicio();
			asistencia.alertaDeInicio();
		}
		
	}

	public void posibleFinEstacionamiento(String posicionUsuario) {
		if (sem.esVigente(patente) && esLaMismaUbicacion(posicionUsuario) ) {
			modo.darFin();
			asistencia.alertaDeFin();
		}
		
	}
	
	private boolean esLaMismaUbicacion(String posicionUsuario) {
		return posicionInicioEstacionamiento.equals(posicionUsuario);
	}
	
	public void setAsistenciaAlUsuario(AsistenciaAlUsuario asistenciaAlUsuario) {
		asistencia = asistenciaAlUsuario;
		asistencia.configurarApp(this);
	}

	public SEM getSEM() {
		return sem;
	}

	public String getPatente() {
		return patente;
	}
	
	

}
