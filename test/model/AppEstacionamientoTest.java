package model;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.*;


class AppEstacionamientoTest {
	AppEstacionamiento appEstacionamiento;
	SEM mockedSEM = mock(SEM.class);
	Celular mockedCelular = mock(Celular.class);
	int nroCelular = 0;
	
	@BeforeEach
	void setUp() throws Exception {
	appEstacionamiento = new AppEstacionamiento(mockedSEM, mockedCelular);
	when(mockedSEM.getPrecioHora()).thenReturn(1);
	when(mockedSEM.getFinDeFranjaHoraria()).thenReturn(20);
	

	}
	
	@Test
	void testIniciarestacionamientoCuandoNoTieneSuficienteCredito() {
		when(mockedCelular.getCredito()).thenReturn(2);
		int horaDeInicio = 11;
		int horaFin = horaDeInicio + mockedCelular.getCredito();
		appEstacionamiento.iniciarEstacionamiento(horaDeInicio);
		verify(this.mockedSEM).iniciarEstacionamientoViaApp(horaDeInicio, horaFin, nroCelular);
	}
	
	@Test
	void testIniciarestacionamientoCuandoTieneSuficienteCredito() {
		when(mockedCelular.getCredito()).thenReturn(50);
		int horaDeInicio = 11;
		int horaFin = mockedSEM.getFinDeFranjaHoraria();
		appEstacionamiento.iniciarEstacionamiento(horaDeInicio);
		verify(this.mockedSEM).iniciarEstacionamientoViaApp(horaDeInicio, horaFin, nroCelular);
	}
	
	

}
