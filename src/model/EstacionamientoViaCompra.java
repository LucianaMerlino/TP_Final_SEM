package model;

import java.time.LocalDateTime;

public class EstacionamientoViaCompra extends Estacionamiento {
	
	private CompraPuntual compraPuntual;
	
	public EstacionamientoViaCompra(CompraPuntual compraPuntual) {
		super(compraPuntual.getFechaHora(), LocalDateTime.of(compraPuntual.getFechaHora().toLocalDate(), 
				compraPuntual.getFechaHora().toLocalTime().plusHours((long) compraPuntual.getHoras())), compraPuntual.getPatente());
		this.compraPuntual = compraPuntual;
	}
	
	@Override
	public Celular getCelular() {
		return null; //por polimorfismo
	}

}
