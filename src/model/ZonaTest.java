package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ZonaTest {
	
	private Zona zona;
	private PuntoDeVenta puntoDeVenta1;
	private PuntoDeVenta puntoDeVenta2;
	private PuntoDeVenta puntoDeVenta3;
	private Inspector inspector;

	@BeforeEach
	void setUp() throws Exception {
		
		//DOCs
		this.puntoDeVenta1 = new PuntoDeVenta();
		this.puntoDeVenta2 = new PuntoDeVenta();
		this.puntoDeVenta3 = new PuntoDeVenta();
		//SUT
		this.zona = new Zona();
	}

	@Test
	void testConstructor() {
		assertNotNull(this.zona);
	}
	
	@Test
	void testGetPuntosDeVenta() {
		zona.agregarPuntoDeVenta(puntoDeVenta1);
		zona.agregarPuntoDeVenta(puntoDeVenta1);
		zona.agregarPuntoDeVenta(puntoDeVenta1);
		assertEquals(3, zona.getPuntosDeVenta().size());
	}
	
	@Test
	void testRemovePuntosDeVenta() {
		zona.agregarPuntoDeVenta(puntoDeVenta1);
		zona.agregarPuntoDeVenta(puntoDeVenta2);
		zona.quitarPuntoDeVenta(puntoDeVenta1);
		assertEquals(1, zona.getPuntosDeVenta().size());
		assertFalse(zona.getPuntosDeVenta().contains(puntoDeVenta1));
	}
	
	@Test
	void testAgregarPuntoDeVenta() {
		zona.agregarPuntoDeVenta(puntoDeVenta1);
		zona.agregarPuntoDeVenta(puntoDeVenta2);
		zona.agregarPuntoDeVenta(puntoDeVenta3);
		assertEquals(puntoDeVenta1, zona.getPuntosDeVenta().get(0));
		assertEquals(puntoDeVenta2, zona.getPuntosDeVenta().get(1));
		assertEquals(puntoDeVenta3, zona.getPuntosDeVenta().get(2));
	}

}