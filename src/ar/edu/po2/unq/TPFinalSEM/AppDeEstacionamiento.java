package ar.edu.po2.unq.TPFinalSEM;

import java.time.LocalTime;

public abstract class AppDeEstacionamiento {
	
	private SEM sEM;
	private Celular celular;
	private String patente;
	private Alerta alerta = new AlertaDesactivada(); 
	private EstadoDeDesplazamiento estadoDeDesplazamiento;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	private LocalTime ahora= LocalTime.now();
	private int hora = ahora.getHour();
	private int duracion = this.calcularDuracion(getHoraInicio().getHour());
	private int costoTotal = this.calcularCosto(getDuracion());
	
    
	public String consultarSaldo() {
		return "Saldo disponible: " + this.getCelular().getCredito();
	}
	
	public void activarAlerta() {
		this.setAlerta(new AlertaActivada());
		this.activarDesplazmiento(); 
	}
	
	public void setAlerta(Alerta aler) {
		this.alerta = aler;	
	}

	public void desactivarAlerta() {
		this.setAlerta(new AlertaDesactivada());
	}
	
	public void activarDesplazmiento() {
		this.setEstadoDeDesplazamiento(new EstadoWalking());
	}
	

	
	public String iniciarEstacionamiento(String patente, int nroCelular) {
		if (this.getCelular().getCredito()>= this.getsEM().precioHora()) {
			this.getsEM().iniciarEstacionamientoViaApp(patente, nroCelular);
			this.setHoraDeInicio();
			return this.mensajeDeInicio();
		} else {
			return this.mensajeSaldoInsuficiente();
		}
	}
	
	private void setHoraDeInicio() {
		this.setHoraInicio(LocalTime.now());
		
	}

	
	public String finalizarEstacionamiento(String patente) {
		this.getsEM().finalizarEstacionamientoViaApp(patente);
		this.getCelular().consumirCredito(getCostoTotal());
		return this.mensajeDeFinalizacion();

	}
	

	private int calcularCosto(int duracion) {
		return duracion * getsEM().precioHora();
	}

	private int calcularDuracion(int horaInicio) {
		return this.getHoraInicio().getHour() - this.getHoraFin().getHour();
	}


	public abstract String mensajeDeFinalizacion();



	private String mensajeSaldoInsuficiente() {
		return "Su saldo es induficiente para iniciar un estacionamiento medido.";
	}


	public abstract String mensajeDeInicio();
	
	public void walking() {
		this.estadoDeDesplazamiento.walking(this);
	}
	
	public void driving() {
		this.estadoDeDesplazamiento.driving(this);

	}
	
	
	public AppDeEstacionamiento cambiarModoApp() {
		return null;
		
	}
	
	protected void alertarOIniciarSiCumple(Zona ubicacionActual) {
		if (!(this.getsEM().esVigente(this.getPatente())) && this.getsEM().esZonamedida(ubicacionActual)) {
			this.iniciarEstacionamientoAutomatico(this.getPatente(), this.getCelular().getNumero());
			this.alerta.alertaInicioEstacionamiento();
		}
	}
	


	protected abstract void iniciarEstacionamientoAutomatico(String patente2, int numero);

	public void alertarOFinalizarSiCumple(Zona ubicacionestacionamiento) {
		if(this.getsEM().esVigente(this.getPatente())) {
			this.alerta.alertaFinEstacionamiento();
			this.finalizarEstacionamientoAutomatico(this.getPatente());
		}
		
	}
	protected abstract void finalizarEstacionamientoAutomatico(String patente2);

	public Celular getCelular() {
		return celular;
	}


	public void setCelular(Celular celular) {
		this.celular = celular;
	}


	public LocalTime getHoraInicio() {
		return horaInicio;
	}


	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}


	public SEM getsEM() {
		return sEM;
	}


	public void setsEM(SEM sEM) {
		this.sEM = sEM;
	}


	public int getHora() {
		return hora;
	}


	public void setHora(int hora) {
		this.hora = hora;
	}


	public LocalTime getHoraFin() {
		return horaFin;
	}


	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}


	public int getDuracion() {
		return duracion;
	}


	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}


	public int getCostoTotal() {
		return costoTotal;
	}


	public void setCostoTotal(int costoTotal) {
		this.costoTotal = costoTotal;
	}


	public EstadoDeDesplazamiento getEstadoDeDesplazamiento() {
		return estadoDeDesplazamiento;
	}


	public void setEstadoDeDesplazamiento(EstadoDeDesplazamiento estadoDeDesplazamiento) {
		this.estadoDeDesplazamiento = estadoDeDesplazamiento;
	}



	public String getPatente() {
		return patente;
	}




}
