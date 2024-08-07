package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppEstacionamientoModoAutomaticoTest {

	ModoAutomatico modoAutomatico;
	SEM mockedSEM;
	Celular mockedCelular;
	String nroCelular;
	String patente;
	LocalTime finFranjaHoraria;
	LocalTime horaDeInicio;
	AppEstacionamiento mockedApp;
	
	@BeforeEach
	void setUp() throws Exception {
		mockedSEM = mock(SEM.class);
		mockedCelular = mock(Celular.class);
		nroCelular = "1233444";
		patente = "pat666";
		modoAutomatico = new ModoAutomatico(mockedSEM, mockedCelular, patente);
		finFranjaHoraria = LocalTime.of(20, 0, 0);
		horaDeInicio = LocalTime.of(11, 0, 0);
		when(mockedSEM.getPrecioHora()).thenReturn(1.0);
		when(mockedSEM.getFinDeFranjaHoraria()).thenReturn(finFranjaHoraria);
	}
	
	@Test
	void testIniciarEstacionamientoCuandoNoTieneSuficienteCreditoParaQuedarseHataElFinDeFranjaHoraria() {
		when(mockedCelular.getCredito()).thenReturn(2.0);
		LocalTime horaFin = horaDeInicio.plusHours(mockedCelular.getCredito().longValue());
		assertEquals(modoAutomatico.iniciarEstacionamiento(horaDeInicio),
				"Hora de comienzo de estacionamiento automático :" + horaDeInicio + "\n" +
						"Su saldo le permitirá mantener el estacionamiento hasta: " + horaFin);
			
	}
	
	@Test
	void testIniciarEstacionamientoCuandoTieneSuficienteCreditoParaQuedarseHataElFinDeFranjaHoraria() {
		when(mockedCelular.getCredito()).thenReturn(10.0);
		assertEquals(modoAutomatico.iniciarEstacionamiento(horaDeInicio),
				"Hora de comienzo de estacionamiento automático :" + horaDeInicio + "\n" +
						"Su saldo le permitirá mantener el estacionamiento hasta: " + finFranjaHoraria);
	}
	
	@Test
	void testIniciarEstacionamientoCuandoNoTieneSuficienteCredito() {
		when(mockedCelular.getCredito()).thenReturn(0.0);
		assertEquals(modoAutomatico.iniciarEstacionamiento(horaDeInicio),
				"Saldo insuficiente. Estacionamiento no permitido.");
	}
	
	@Test 
	void testFinalizarEstacionamiento() {
		LocalTime horaFin = LocalTime.of(12, 0, 0);
		double duracion = 1;
		double costo = 1;
		when(mockedSEM.finalizarEstacionamientoViaApp(nroCelular)).thenReturn(new InfoEstacionamiento(LocalTime.of(11, 0, 0), LocalTime.of(12, 0, 0)));
		assertEquals(modoAutomatico.finalizarEstacionamiento(nroCelular),
				"El estacionamiento automatico ha comenzado a las " + horaDeInicio + "y ha finalizado a las " + horaFin + 
				"\n" + "Duración del estacionamiento: " + duracion + "\n" +
				"Costo total del estacionamiento: " + costo);
	}
	
	@Test 
	void testFinalizarEstacionamientoDebitoDeCredito() {
		Double duracion = 1.0;
		Double costo = 1.0;
		when(mockedSEM.finalizarEstacionamientoViaApp(nroCelular)).thenReturn(new InfoEstacionamiento(LocalTime.of(11, 0, 0), LocalTime.of(12, 0, 0)));
		modoAutomatico.finalizarEstacionamiento(nroCelular);
		verify(mockedCelular).consumirCredito(duracion * costo);
	}
	
	@Test
	void testConfigurarApp() {
		mockedApp = mock(AppEstacionamiento.class);
		GPS mockedGPS = mock(GPS.class);
		when(mockedApp.getCelular()).thenReturn(mockedCelular);
		when(mockedCelular.getGps()).thenReturn(mockedGPS);
		modoAutomatico.configurarApp(mockedApp);
		verify(mockedApp).setEstadoDesplazamiento(any(EstadoActivado.class));
		verify(mockedApp).setAsistenciaAlUsuario(any(AlertaDesactivada.class));

		
	}

}
