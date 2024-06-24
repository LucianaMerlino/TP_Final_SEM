package model;

import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AppEstacionamientoModosTest {

	ModoManual modoManual;
	SEM mockedSEM = mock(SEM.class);
	Celular mockedCelular = mock(Celular.class);
	int nroCelular = 0;
	String patente = "pat666";
	
	@BeforeEach
	void setUp() throws Exception {
	modoManual = new ModoManual(mockedSEM, mockedCelular, patente);
	when(mockedSEM.getPrecioHora()).thenReturn(1);
	when(mockedSEM.getFinDeFranjaHoraria()).thenReturn(20);
	}
	
	@Test
	void testIniciarEstacionamientoCuandoNoTieneSuficienteCreditoParaQuedarseHataElFinDeFranjaHoraria() {
		when(mockedCelular.getCredito()).thenReturn(2);
		int horaDeInicio = 11;
		int horaFin = horaDeInicio + mockedCelular.getCredito();
		assertEquals(modoManual.iniciarEstacionamiento(horaDeInicio),
				"Hora de comienzo de estacionamiento " + horaDeInicio + "\n" +
						"Hora estimada de fin de estacionamiento " + horaFin);
	}
	
	@Test
	void testIniciarEstacionamientoCuandoTieneSuficienteCreditoParaQuedarseHataElFinDeFranjaHoraria() {
		when(mockedCelular.getCredito()).thenReturn(50);
		int horaDeInicio = 11;
		int horaFin = mockedSEM.getFinDeFranjaHoraria();
		assertEquals(modoManual.iniciarEstacionamiento(horaDeInicio),
				"Hora de comienzo de estacionamiento " + horaDeInicio + "\n" +
						"Hora estimada de fin de estacionamiento " + horaFin);
	}
	
	
	
	@Test
	void testIniciarEstacionamientoCuandoNoTieneSuficienteCredito() {
		when(mockedCelular.getCredito()).thenReturn(0);
		int horaDeInicio = 11;
		assertEquals(modoManual.iniciarEstacionamiento(horaDeInicio),
				"Saldo insuficiente. Estacionamiento no permitido.");
	}
	
	@Test 
	void testFinalizarEstacionamiento() {
		int horaInicio= 11;
		int horaFin = 12;
		int duracion = 1;
		int costo = 1;
		when(mockedSEM.finalizarEstacionamientoViaApp(nroCelular)).thenReturn(new InfoEstacionamiento(11, 12));
		assertEquals(modoManual.finalizarEstacionamiento(nroCelular),
				"Hora comienzo de estacionamiento: " + horaInicio+ "\n"+
				"Hora fin de estacionamiento: " + horaFin + "\n" +
				"Duración del estacionamiento: " + duracion + "\n" +
				"Costo total del estacionamiento: " + costo);
	}
	
	@Test 
	void testFinalizarEstacionamientoDebitoDeCredito() {
		int duracion = 1;
		int costo = 1;
		when(mockedSEM.finalizarEstacionamientoViaApp(nroCelular)).thenReturn(new InfoEstacionamiento(11, 12));
		modoManual.finalizarEstacionamiento(nroCelular);
		verify(mockedCelular).descontarCredito(duracion * costo);
	}
 

}
