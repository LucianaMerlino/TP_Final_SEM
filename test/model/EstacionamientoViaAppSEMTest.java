package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.po2.unq.*;

class EstacionamientoViaAppTest {

	// setUp:
	
	EstacionamientoViaApp estacionamientoViaApp;
	String patenteEsperada;

	// Excercise

	@BeforeEach
	void setUp() throws Exception {
	
	// SUT: EstacionamientoViaApp
	estacionamientoViaApp = mock(EstacionamientoViaApp.class);
	patenteEsperada = "ABC123";
	
	when(estacionamientoViaApp.getPatente()).thenReturn(patenteEsperada);
	
	}
	
	//Verify:
	@Test
	void test() {
		assertEquals(estacionamientoViaApp.getPatente(), patenteEsperada);
	}
