package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PuntoDeVentaTest {
	
	private CompraPuntual compraPuntual;
	private RecargaCredito recargaCredito;
	private Celular celularMocked;
	private PuntoDeVenta puntoDeVenta;

	@BeforeEach
	void setUp() throws Exception {
		
		celularMocked = mock(Celular.class);

		puntoDeVenta = new PuntoDeVenta();
		
	}

	@Test
	void testConstructor() {
		assertNotNull(puntoDeVenta);
	}
	
	@Test
	void testCrearCompraPuntual() {
		this.compraPuntual = puntoDeVenta.crearCompraPuntual(1, 2, "AAA");
		assertNotNull(compraPuntual);
	}
	
	@Test
	void testCrearRecargaCredito() {
		this.recargaCredito = puntoDeVenta.crearRecargaCredito(1, 2000.00, celularMocked);
		assertNotNull(recargaCredito);
	}

}