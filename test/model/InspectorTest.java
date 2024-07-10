package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InspectorTest {
	
	private List<Estacionamiento> estacionamientos;
	private EstacionamientoViaCompra estacionamientoMocked1;
	private EstacionamientoViaCompra estacionamientoMocked2;
	private EstacionamientoViaCompra estacionamientoMocked3;
	private Infraccion infraccion;
	private Inspector inspector;
	
	@BeforeEach
	void setUp() throws Exception {
		
		this.estacionamientos = new ArrayList<Estacionamiento>();
		this.estacionamientoMocked1 = mock(EstacionamientoViaCompra.class);
		this.estacionamientoMocked2 = mock(EstacionamientoViaCompra.class);
		this.estacionamientoMocked3 = mock(EstacionamientoViaCompra.class);
		when(estacionamientoMocked1.getPatente()).thenReturn("AAA");
		when(estacionamientoMocked2.getPatente()).thenReturn("BBB");
		when(estacionamientoMocked3.getPatente()).thenReturn("CCC");
		when(estacionamientoMocked2.estaVigente()).thenReturn(true);
		
		this.inspector = new Inspector();
		
	}

	@Test
	void testConstructor() {
		assertNotNull(inspector);
	}
	
	@Test
	void testTieneEstacionamientoVigente() {
		this.estacionamientos.add(estacionamientoMocked1);
		this.estacionamientos.add(estacionamientoMocked2);
		this.estacionamientos.add(estacionamientoMocked3);
		assertTrue(inspector.tieneEstacionamientoVigente("BBB", estacionamientos));
		assertFalse(inspector.tieneEstacionamientoVigente("AAC", estacionamientos));
	}
	
	@Test
	void testAltaInfraccion() {
		inspector.altaInfraccion("AAC");
		assertNotNull(infraccion);
		assertEquals("AAC", infraccion.getPatente());
		assertEquals(inspector, infraccion.getInspector());
		
	}
	
}
