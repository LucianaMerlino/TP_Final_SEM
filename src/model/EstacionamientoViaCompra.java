package model;

import java.time.LocalTime;

public class EstacionamientoViaCompra extends Estacionamiento {
	
	
	
	public EstacionamientoViaCompra(CompraPuntual compraPuntual) {
		super(compraPuntual.getFechaHora().toLocalTime(), compraPuntual.getPatente());
		this.setHoraFin(calcularHoraFin(compraPuntual));
		
	}
	
	private LocalTime calcularHoraFin(CompraPuntual compra) {
		return compra.getFechaHora().toLocalTime().plusHours((long) compra.getHoras());
	}

	@Override
	public void setHoraFin(LocalTime horaFin) {
		
	}

}
