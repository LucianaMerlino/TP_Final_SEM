package model;

public class InfoEstacionamiento {
	
	private int hInicio;
	private int hFin;
	
	public InfoEstacionamiento(int horaInicio, int horaFin) {
		hInicio = horaInicio;
		hFin = horaFin;
	}

	public int gethInicio() {
		return hInicio;
	}

	public int gethFin() {
		return hFin;
	}
	
	public int duracion() {
		return hFin - hInicio;
	}
}
