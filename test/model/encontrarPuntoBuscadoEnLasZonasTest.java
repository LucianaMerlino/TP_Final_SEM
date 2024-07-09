package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.po2.unq.*;

class encontrarPuntoBuscadoEnLasZonasTest {

	SEM sem;
	int precioPorHora;
	
	LocalTime inicioFranja;
	LocalTime finFranja;
	
	Zona primeraZona;
	Zona segundaZona;
	
	Inspector inspector;
	
	List<PuntoDeVenta> puntosDeVentasPrimeraZona;
	List<PuntoDeVenta> puntosDeVentasSegundaZona;
	
	PuntoDeVenta primerPunto;
	PuntoDeVenta segundoPunto;
	PuntoDeVenta tercerPunto;
	PuntoDeVenta cuartoPunto;

	@BeforeEach
	void setUp() throws Exception {
	
	
	
	// SUT:
		
	sem = new SEM(precioPorHora, inicioFranja, finFranja);
	
	inspector = mock(Inspector.class);
	
	primerPunto = new PuntoDeVenta();
	segundoPunto = new PuntoDeVenta();
	tercerPunto = new PuntoDeVenta();
	cuartoPunto = new PuntoDeVenta();
	
	puntosDeVentasPrimeraZona = new ArrayList<PuntoDeVenta>();
	puntosDeVentasSegundaZona = new ArrayList<PuntoDeVenta>();
	
	puntosDeVentasPrimeraZona.add(primerPunto);
	puntosDeVentasPrimeraZona.add(segundoPunto);
	
	puntosDeVentasSegundaZona.add(tercerPunto);
	puntosDeVentasSegundaZona.add(cuartoPunto);
	
	primeraZona = new Zona(puntosDeVentasPrimeraZona, inspector);
	segundaZona = new Zona(puntosDeVentasSegundaZona, inspector);
	
	sem.registrarZona(primeraZona);
	sem.registrarZona(segundaZona);
	
	}

	@Test
	void zonasBuscadasTest() {
		
		assertEquals(sem.encontrarPuntoBuscadoEnLasZonas(tercerPunto),
					 tercerPunto);
		
	}
