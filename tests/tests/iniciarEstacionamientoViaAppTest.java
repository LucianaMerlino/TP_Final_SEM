package tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.po2.unq.TPFinalSEM.Celular;
import ar.edu.po2.unq.TPFinalSEM.EstacionamientoViaApp;
import ar.edu.po2.unq.TPFinalSEM.SEM;


class iniciarEstacionamientoViaAppTest {

	SEM sem;
	int precioPorHora;
	LocalTime inicioFranja;
	LocalTime finFranja;

	EstacionamientoViaApp primerEstacionamientoViaApp;
	
	LocalTime horaInicioPrimerEstacionamiento;
	LocalTime horaFinPrimerEstacionamiento;
	
	Celular celularPrimerCliente;
	
	@BeforeEach
	void setUp() throws Exception {
	
		precioPorHora = 40;
		inicioFranja = LocalTime.of(7, 0);
		finFranja = LocalTime.of(20, 0);
	
		horaInicioPrimerEstacionamiento = LocalTime.of(8, 0);
		horaFinPrimerEstacionamiento = LocalTime.of(9, 0);
		
		celularPrimerCliente = mock(Celular.class);
		
		primerEstacionamientoViaApp = new EstacionamientoViaApp(horaInicioPrimerEstacionamiento, 
															horaFinPrimerEstacionamiento, "123",
														    celularPrimerCliente);
														    
		when(celularPrimerCliente.getNumero()).thenReturn(12345);
		when(celularPrimerCliente.getCredito()).thenReturn(100.0);		
		
		sem = new SEM(precioPorHora, inicioFranja, finFranja);											    
	
	}

	@Test
	void test() {
	
		sem.iniciarEstacionamientoViaApp(primerEstacionamientoViaApp);
		
		assertEquals(sem.getEstacionamientos().stream().findFirst().get(),
					 primerEstacionamientoViaApp);
	}

}
