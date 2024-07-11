package model;


import java.time.LocalTime;

public class InfoEstacionamiento {
	
	private LocalTime hInicio;
	private LocalTime hFin;
	
	public InfoEstacionamiento(LocalTime horaInicio, LocalTime horaFin) {
		hInicio = horaInicio;
		hFin = horaFin;
	}

	public LocalTime gethInicio() {
		return hInicio;
	}

	public LocalTime gethFin() {
		return hFin;
	}
	
	public Double duracion() {
		return (double) (hFin.getHour() -  hInicio.getHour());
	}
}
