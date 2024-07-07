package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CelularTest {
	
	private Celular celular;

	@BeforeEach
	void setUp() throws Exception {
		
	//	this.celular = new Celular(12345678);
		
	}

	@Test
	void testConstructor() {
		
		assertNotNull(celular);
	}
	
	@Test
	void testGetNumero() {
		
		assertEquals(12345678, celular.getNumero());
	}

}