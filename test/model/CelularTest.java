package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CelularTest {
	
	Celular celular;
	GPS gps;
	

	@BeforeEach
	void setUp() throws Exception {
		this.celular = new Celular("+12-4567-9876", 0.0, gps);
	}

	@Test
	void testConstructor() {
		assertNotNull(celular);
	}
	
	@Test
	void testGetNumero() {
		assertEquals("+12-4567-9876", celular.getNumero());
	}
	
	@Test
	void testGetCredito() {
		assertEquals(0.0, celular.getCredito());
	}
	
	@Test
	void testCargarCredito() {
		celular.cargarCredito(10.0);
		assertEquals(10.0, celular.getCredito());
	}
	
	@Test
	void testConsumirCredito() {
		celular.cargarCredito(1000.00);
		celular.consumirCredito(500.00);
		assertEquals(500.00, celular.getCredito());
	}

}