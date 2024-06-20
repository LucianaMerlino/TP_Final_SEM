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

import ar.edu.po2.unq.TPFinalSEM.Celular;
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
	
	CompraPuntual compraPuntual;
	
	// Se inicializan los DOC que van a ser mockeados:
	
	
	//CompraPuntual compraPuntual;
	
	String patenteBuscada;
	
	// Excercise:

	@BeforeEach
	void setUp() throws Exception {
	
	// Se asignan instancias de SUT y DOCs a las variables inicializadas previamente:
	
	precioPorHora = 40;
	inicioFranja = LocalTime.of(7, 0);
	finFranja = LocalTime.of(20, 0);
	
	estacionamientos = new ArrayList<Estacionamiento>();
	
	estacionamientos.add(primerEstacionamientoViaApp);
	estacionamientos.add(segundoEstacionamientoViaApp);
	estacionamientos.add(tercerEstacionamientoViaApp);	
	
	primerEstacionamientoViaApp = mock(EstacionamientoViaApp.class);
	segundoEstacionamientoViaApp = mock(EstacionamientoViaApp.class);
	tercerEstacionamientoViaApp = mock(EstacionamientoViaApp.class);
	
	
	// SUT:
		
	sem = new SEM(precioPorHora, inicioFranja, finFranja, estacionamientos);
	
	// inicializacion de los mocks stubs con los comportamientos esperados:
	
	when(primerEstacionamientoViaApp.esVigente(primerEstacionamientoViaApp)).thenReturn(false);
	when(primerEstacionamientoViaApp.getNumeroDeCelular()).thenReturn(1234567);
	
	when(segundoEstacionamientoViaApp.esVigente(segundoEstacionamientoViaApp)).thenReturn(true);
	when(segundoEstacionamientoViaApp.getNumeroDeCelular()).thenReturn(12345);
	
	when(tercerEstacionamientoViaApp.esVigente(tercerEstacionamientoViaApp)).thenReturn(true);
	when(tercerEstacionamientoViaApp.getNumeroDeCelular()).thenReturn(123);
	
	}
	
	// Verify:

	@Test
	void finalizarEstacionamientoViaAppTest() {
		
		sem.finalizarEstacionamientoViaApp(12345);
		
		assertFalse(segundoEstacionamientoViaApp.esVigente(segundoEstacionamientoViaApp));
		
	}

}
