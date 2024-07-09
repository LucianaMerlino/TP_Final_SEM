package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.po2.unq.*;

class registrarInfraccionTest {

	
	SEM sem;
	int precioPorHora;
	LocalTime inicioFranja;
	LocalTime finFranja;
	Infraccion infraccion;
	Inspector inspector;
	

	@BeforeEach
	void setUp() throws Exception {
	
	precioPorHora = 40;
	inicioFranja = LocalTime.of(7, 0);
	finFranja = LocalTime.of(20, 0);
	
	// SUT:
		
	sem = new SEM(precioPorHora, inicioFranja, finFranja);
	
	inspector = mock(Inspector.class);
	
	infraccion = new Infraccion("ABC", inspector);
	
	sem.registrarInfraccion(infraccion);
	
	}

	@Test
	void registrarInfraccionesTest() {
		assertEquals(sem.getInfracciones().stream().findFirst().get(), infraccion);
	}

}
