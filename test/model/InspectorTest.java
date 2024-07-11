package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
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
	private Inspector inspector;
	private SEM sem;
	
	@BeforeEach
	void setUp() throws Exception {
		
		this.estacionamientos = new ArrayList<Estacionamiento>();
		this.estacionamientoMocked1 = mock(EstacionamientoViaCompra.class);
		this.estacionamientoMocked2 = mock(EstacionamientoViaCompra.class);
		this.estacionamientoMocked3 = mock(EstacionamientoViaCompra.class);
		this.sem = mock(SEM.class);
		when(estacionamientoMocked1.getPatente()).thenReturn("AAA");
		when(estacionamientoMocked2.getPatente()).thenReturn("BBB");
		when(estacionamientoMocked3.getPatente()).thenReturn("CCC");
		when(estacionamientoMocked2.esVigente()).thenReturn(true);
		
		this.inspector = new Inspector(sem);
		
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
		verify(sem).registrarInfraccion(any(Infraccion.class));
		
	}
	
}
