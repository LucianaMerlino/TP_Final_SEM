package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PuntoDeVentaTest {
	
	private CompraPuntual compraPuntual;
	private RecargaCredito recargaCredito;
	private Celular celular;
	private PuntoDeVenta puntoDeVenta;

	@BeforeEach
	void setUp() throws Exception {
		
	//	this.celular = new Celular(12345678);

		puntoDeVenta = new PuntoDeVenta();
		
	}

	@Test
	void testConstructor() {
		assertNotNull(puntoDeVenta);
	}
	
	@Test
	void testcrearCompraPuntual() {
		this.compraPuntual = puntoDeVenta.crearCompraPuntual(1, 2.0, "AAA");
		assertNotNull(compraPuntual);
	}
	
	@Test
	void testCrearRecargaCredito() {
		this.recargaCredito = puntoDeVenta.crearRecargaCredito(1, 2000.00, celular);
		assertNotNull(recargaCredito);
	}

}