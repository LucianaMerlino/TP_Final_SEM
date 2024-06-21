package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CelularTest {
	
	private Celular celular;

	@BeforeEach
	void setUp() throws Exception {
		this.celular = new Celular(12345678);
	}

	@Test
	void testConstructor() {
		assertNotNull(celular);
	}
	
	@Test
	void testGetNumero() {
		assertEquals(12345678, celular.getNumero());
	}
	
	@Test
	void testGetCredito() {
		assertEquals(0.0, celular.getCredito());
	}
	
	@Test
	void testCargarCredito() {
		celular.cargarCredito(1000.00);
		assertEquals(1000.00, celular.getCredito());
	}
	
	@Test
	void testConsumirCredito() {
		celular.cargarCredito(1000.00);
		celular.consumirCredito(500.00);
		assertEquals(500.00, celular.getCredito());
	}

}