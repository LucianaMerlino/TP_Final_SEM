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
	
	primerCelular = mock(Celular.class);
	segundoCelular = mock(Celular.class);
	tercerCelular = mock(Celular.class);
	
	sem.registrarCelular(primerCelular);
	sem.registrarCelular(segundoCelular);
	sem.registrarCelular(tercerCelular);
	
	recarga = new RecargaCredito(1234, 500.0, primerCelular);
	
	}

	@Test
	void test() {
		sem.recargarCredito(recarga);
		
		assertEquals(sem.getCelulares().stream().findFirst().get().getCredito(), 
					 500.0);
	}

}
