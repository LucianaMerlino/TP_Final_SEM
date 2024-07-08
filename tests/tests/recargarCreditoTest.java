package tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.po2.unq.TPFinalSEM.Celular;
import ar.edu.po2.unq.TPFinalSEM.RecargaCredito;
import ar.edu.po2.unq.TPFinalSEM.SEM;

class recargarCreditoTest {

	SEM sem;
	int precioPorHora;
	LocalTime inicioFranja;
	LocalTime finFranja;
	
	Celular primerCelular; 
	Celular segundoCelular;
	Celular tercerCelular;
	
	RecargaCredito recarga;

	@BeforeEach
	void setUp() throws Exception {
	
	precioPorHora = 40;
	inicioFranja = LocalTime.of(7, 0);
	finFranja = LocalTime.of(20, 0);
	
	// SUT:
		
	sem = new SEM(precioPorHora, inicioFranja, finFranja);
	
	primerCelular = new Celular(111, 0.0);
	segundoCelular = new Celular(222, 400.0);
	tercerCelular = new Celular(333, 500.0);
	
	sem.registrarCelular(primerCelular);
	sem.registrarCelular(segundoCelular);
	sem.registrarCelular(tercerCelular);
	
	recarga = new RecargaCredito(1234, 500.0, primerCelular);
	
	}

	@Test
	void test() {
		sem.recargarCredito(recarga);
		
		Double saldoCargado = sem.getCelulares().stream().findFirst().get().getCredito();
		
		assertEquals(saldoCargado, 500.0);
	}

}
