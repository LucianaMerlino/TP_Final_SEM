package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InspectorTest {
	
	private List<Estacionamiento> estacionamientos;
	private CompraPuntual compraPuntual1;
	private CompraPuntual compraPuntual2;
	private CompraPuntual compraPuntual3;
	private EstacionamientoViaCompra estacionamiento1;
	private EstacionamientoViaCompra estacionamiento2;
	private EstacionamientoViaCompra estacionamiento3;
	private Inspector inspector;
	
	@BeforeEach
	void setUp() throws Exception {
		
		this.estacionamientos = new ArrayList<Estacionamiento>();
		this.compraPuntual1 = new CompraPuntual(1, 2.0, "AAA");
		this.compraPuntual2 = new CompraPuntual(2, 1.5, "BBB");
		this.compraPuntual3 = new CompraPuntual(3, 1.0, "CCC");
		this.estacionamiento1 = new EstacionamientoViaCompra(compraPuntual1);
		this.estacionamiento2 = new EstacionamientoViaCompra(compraPuntual2);
		this.estacionamiento3 = new EstacionamientoViaCompra(compraPuntual3);
		
		this.inspector = new Inspector();
		
	}

	@Test
	void testConstructor() {
		assertNotNull(inspector);
	}
	
	@Test
	void testTieneEstacionamientoVigente() {
		this.estacionamientos.add(estacionamiento1);
		this.estacionamientos.add(estacionamiento2);
		this.estacionamientos.add(estacionamiento3);
		assertTrue(inspector.tieneEstacionamientoVigente("BBB", estacionamientos));
		assertFalse(inspector.tieneEstacionamientoVigente("AAC", estacionamientos));
	}
	
	@Test
	void testAltaInfraccion() {
		Infraccion infraccion = inspector.altaInfraccion("AAC");
		assertNotNull(infraccion);
		assertEquals("AAC", infraccion.getPatente());
		assertEquals(inspector, infraccion.getInspector());
		
	}
	
}
