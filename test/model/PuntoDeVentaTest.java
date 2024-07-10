package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PuntoDeVentaTest {
	
	private SEM semMocked;
	private CompraPuntual compraPuntual;
	private RecargaCredito recargaCredito;
	private Celular celularMocked;
	private PuntoDeVenta puntoDeVenta;

	@BeforeEach
	void setUp() throws Exception {
		semMocked = mock(SEM.class);
		celularMocked = mock(Celular.class);

		puntoDeVenta = new PuntoDeVenta(semMocked);
		
	}

	@Test
	void testConstructor() {
		assertNotNull(puntoDeVenta);
	}
	
	@Test
	void testCrearEstacionamiento() {
		puntoDeVenta.crearEstacionamiento(1, 2, "AAA");
		assertNotNull(compraPuntual);
	}
	
	@Test
	void testCrearRecargaCredito() {
		puntoDeVenta.recargarCredito(1, 2000.00, celularMocked);
		assertNotNull(recargaCredito);
	}

}