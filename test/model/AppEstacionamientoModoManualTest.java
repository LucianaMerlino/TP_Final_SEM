package model;

import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.time.LocalTime;

class AppEstacionamientoModoManualTest {

		ModoManual modoManual;
		SEM mockedSEM;
		Celular mockedCelular;
		String nroCelular;
		String patente;
		LocalTime finFranjaHoraria;
		LocalTime horaDeInicio;
	
	@BeforeEach
	void setUp() throws Exception {
		mockedSEM = mock(SEM.class);
		mockedCelular = mock(Celular.class);
		nroCelular = "1233444";
		patente = "pat666";
		modoManual = new ModoManual(mockedSEM, mockedCelular, patente);
		finFranjaHoraria = LocalTime.of(20, 0, 0);
		horaDeInicio = LocalTime.of(11, 0, 0);
		when(mockedSEM.getPrecioHora()).thenReturn(1.0);
		when(mockedSEM.getFinDeFranjaHoraria()).thenReturn(finFranjaHoraria);
	}
	
	@Test
	void testIniciarEstacionamientoCuandoNoTieneSuficienteCreditoParaQuedarseHataElFinDeFranjaHoraria() {
		when(mockedCelular.getCredito()).thenReturn(2.0);
		LocalTime horaFin = horaDeInicio.plusHours(mockedCelular.getCredito().longValue());
		assertEquals(modoManual.iniciarEstacionamiento(horaDeInicio),
				"Hora de comienzo de estacionamiento " + horaDeInicio + "\n" +
						"Hora estimada de fin de estacionamiento " + horaFin);
	}
	
	@Test
	void testIniciarEstacionamientoCuandoTieneSuficienteCreditoParaQuedarseHataElFinDeFranjaHoraria() {
		when(mockedCelular.getCredito()).thenReturn(10.0);
		assertEquals(modoManual.iniciarEstacionamiento(horaDeInicio),
				"Hora de comienzo de estacionamiento " + horaDeInicio + "\n" +
						"Hora estimada de fin de estacionamiento " + finFranjaHoraria);
	}
	
	

	@Test
	void testIniciarEstacionamientoCuandoNoTieneSuficienteCredito() {
		when(mockedCelular.getCredito()).thenReturn(0.0);
		assertEquals(modoManual.iniciarEstacionamiento(horaDeInicio),
				"Saldo insuficiente. Estacionamiento no permitido.");
	}
	
	@Test 
	void testFinalizarEstacionamiento() {
		LocalTime horaFin = LocalTime.of(12, 0, 0);
		double duracion = 1;
		double costo = 1;
		when(mockedSEM.finalizarEstacionamientoViaApp(nroCelular)).thenReturn(new InfoEstacionamiento(LocalTime.of(11, 0, 0), LocalTime.of(12, 0, 0)));
		assertEquals(modoManual.finalizarEstacionamiento(nroCelular),
				"Hora comienzo de estacionamiento: " + horaDeInicio+ "\n"+
				"Hora fin de estacionamiento: " + horaFin + "\n" +
				"Duración del estacionamiento: " + duracion + "\n" +
				"Costo total del estacionamiento: " + costo);
	}
	
	@Test 
	void testFinalizarEstacionamientoDebitoDeCredito() {
		Double duracion = 1.0;
		Double costo = 1.0;
		when(mockedSEM.finalizarEstacionamientoViaApp(nroCelular)).thenReturn(new InfoEstacionamiento(LocalTime.of(11, 0, 0), LocalTime.of(12, 0, 0)));
		modoManual.finalizarEstacionamiento(nroCelular);
		verify(mockedCelular).consumirCredito(duracion * costo);
	}
 

}
