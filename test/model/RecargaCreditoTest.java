package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RecargaCreditoTest {
	private Celular celularMocked;
	private PuntoDeVenta puntoDeVentaMocked;
	private RecargaCredito recargaCredito;

	@BeforeEach
	void setUp() throws Exception {
		celularMocked = mock(Celular.class);
		puntoDeVentaMocked = mock(PuntoDeVenta.class);
		
		recargaCredito = new RecargaCredito(1, puntoDeVentaMocked, 1000.0, celularMocked);
	}

	@Test
	void testConstructor() {
		assertNotNull(recargaCredito);
	}

}
