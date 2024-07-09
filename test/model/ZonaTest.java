package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ZonaTest {
	
	private Zona zona;
	private PuntoDeVenta puntoDeVentaMocked1;
	private PuntoDeVenta puntoDeVentaMocked2;
	private PuntoDeVenta puntoDeVentaMocked3;
	private Inspector inspector;

	@BeforeEach
	void setUp() throws Exception {
		
		//DOCs
		this.puntoDeVentaMocked1 = mock(PuntoDeVenta.class);
		this.puntoDeVentaMocked2 = mock(PuntoDeVenta.class);
		this.puntoDeVentaMocked3 = mock(PuntoDeVenta.class);
		//SUT
		this.zona = new Zona();
	}

	@Test
	void testConstructor() {
		assertNotNull(this.zona);
	}
	
	@Test
	void testGetPuntosDeVenta() {
		zona.agregarPuntoDeVenta(puntoDeVentaMocked1);
		zona.agregarPuntoDeVenta(puntoDeVentaMocked2);
		zona.agregarPuntoDeVenta(puntoDeVentaMocked3);
		assertEquals(3, zona.getPuntosDeVenta().size());
	}
	
	@Test
	void testRemovePuntosDeVenta() {
		zona.agregarPuntoDeVenta(puntoDeVentaMocked1);
		zona.agregarPuntoDeVenta(puntoDeVentaMocked2);
		zona.quitarPuntoDeVenta(puntoDeVentaMocked1);
		assertEquals(1, zona.getPuntosDeVenta().size());
		assertFalse(zona.getPuntosDeVenta().contains(puntoDeVentaMocked1));
	}
	
	@Test
	void testAgregarPuntoDeVenta() {
		zona.agregarPuntoDeVenta(puntoDeVentaMocked1);
		zona.agregarPuntoDeVenta(puntoDeVentaMocked2);
		zona.agregarPuntoDeVenta(puntoDeVentaMocked3);
		assertEquals(puntoDeVentaMocked1, zona.getPuntosDeVenta().get(0));
		assertEquals(puntoDeVentaMocked2, zona.getPuntosDeVenta().get(1));
		assertEquals(puntoDeVentaMocked3, zona.getPuntosDeVenta().get(2));
	}

}