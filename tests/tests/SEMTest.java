package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.po2.unq.TPFinalSEM.CompraPuntual;
import ar.edu.po2.unq.TPFinalSEM.Estacionamiento;
import ar.edu.po2.unq.TPFinalSEM.EstacionamientoViaApp;
import ar.edu.po2.unq.TPFinalSEM.EstacionamientoViaCompra;
import ar.edu.po2.unq.TPFinalSEM.SEM;


class SEMTest {
	
	// SetUp: inicializo las variables necesarias: 

	// Se inicializa un SEM, que es el SUT, con sus atributos correspondientes:
	
	SEM sem;
	int precioPorHora;
	LocalTime inicioFranja;
	LocalTime finFranja;
	List<Estacionamiento> estacionamientos;
	List<Estacionamiento> estacionamientosEsperados;
	
	EstacionamientoViaApp primerEstacionamientoViaApp;
	EstacionamientoViaApp segundoEstacionamientoViaApp;
	EstacionamientoViaApp tercerEstacionamientoViaApp;
	
	
	// Se inicializan los DOC que van a ser mockeados:
	
	
	//CompraPuntual compraPuntual;
	//EstacionamientoViaCompra primerEstacionamientoViaCompra = new EstacionamientoViaCompra(compraPuntual); // TODO: solucionar el null pointer exception que devuelve que compraPuntual es null
	
	String patenteBuscada;
	
	// Excercise:

	@BeforeEach
	void setUp() throws Exception {
	
	// Se asignan instancias de SUT y DOCs a las variables inicializadas previamente:
	
	precioPorHora = 40;
	inicioFranja = LocalTime.of(7, 0);
	finFranja = LocalTime.of(20, 0);
	
	estacionamientos = new ArrayList<Estacionamiento>();
	//estacionamientos.add(primerEstacionamientoViaCompra);
	estacionamientos.add(primerEstacionamientoViaApp);
	estacionamientos.add(segundoEstacionamientoViaApp);
	estacionamientos.add(tercerEstacionamientoViaApp);
	
	estacionamientosEsperados = new ArrayList<Estacionamiento>();
	estacionamientosEsperados.add(tercerEstacionamientoViaApp);
	
		
	//compraPuntual = mock(CompraPuntual.class); 
	patenteBuscada = "ABC 123";
	//primerEstacionamientoViaCompra = mock(EstacionamientoViaCompra.class);
	primerEstacionamientoViaApp = mock(EstacionamientoViaApp.class);
	segundoEstacionamientoViaApp = mock(EstacionamientoViaApp.class);
	tercerEstacionamientoViaApp = mock(EstacionamientoViaApp.class);
	
	
	// SUT:
		
	sem = new SEM(precioPorHora, inicioFranja, finFranja, estacionamientos);
	
	// inicializacion de los mocks stubs con los comportamientos esperados:
	
	//when(primerEstacionamientoViaCompra.getEstaVigente()).thenReturn(true);
	when(primerEstacionamientoViaApp.getEstaVigente()).thenReturn(false);
	when(primerEstacionamientoViaApp.getPatente()).thenReturn("WRT444");
	
	when(segundoEstacionamientoViaApp.getEstaVigente()).thenReturn(true);
	when(segundoEstacionamientoViaApp.getPatente()).thenReturn("ASD222");
	
	when(tercerEstacionamientoViaApp.getEstaVigente()).thenReturn(true);
	when(tercerEstacionamientoViaApp.getPatente()).thenReturn(patenteBuscada);
	
	//when(compraPuntual.getFechaHora()).thenReturn(LocalDateTime.now());
	
	}
	
	
	// Verify:

	@Test
	void finalizarEstacionamientoViaAppTest() {
		
		assertEquals(sem.finalizarEstacionamientoViaApp(patenteBuscada), estacionamientosEsperados);
		
	}

}
