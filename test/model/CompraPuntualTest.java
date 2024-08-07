package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CompraPuntualTest {
	private SEM semMocked;
	private PuntoDeVenta puntoDeVentaMocked;
	private CompraPuntual compraPuntual;
	
	@BeforeEach
	void setUp() throws Exception {
		semMocked = mock(SEM.class);
		puntoDeVentaMocked = mock(PuntoDeVenta.class);
		compraPuntual = new CompraPuntual(1, semMocked, puntoDeVentaMocked, 2, "AAA");
		
	}

	@Test
	void testConstructor() {
		assertNotNull(compraPuntual);
	}
	
 	void testGetFechaHora() {
  		assertEquals(LocalDateTime.now(), compraPuntual.getFechaHora());
  	}
	
	void testGetPatente() {
		assertEquals("AAA", compraPuntual.getPatente());
	}
	
	void testGetHoras() {
		assertEquals(2, compraPuntual.getHoras());
	}

}
