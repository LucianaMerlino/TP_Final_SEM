package model;

//import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppEstacionamientoTest {

	AppEstacionamiento appEstacionamiento;
	SEM mockedSEM;
	Celular mockedCelular;
	String nroCelular;
	String patente;
	LocalTime finFranjaHoraria;
	LocalTime horaDeInicio;
	ModoEstacionamiento mockedModo;
	EstadoDesplazamiento mockedEstado;
	AsistenciaAlUsuario mockedAlerta;
	
	@BeforeEach
	void setUp() throws Exception {
		mockedSEM = mock(SEM.class);
		mockedCelular = mock(Celular.class);
		nroCelular = "13-2256-5432";
		patente = "pat666";
		mockedModo = mock(ModoEstacionamiento.class);
		mockedEstado = mock(EstadoDesplazamiento.class);
		mockedAlerta = mock(AsistenciaAlUsuario.class);
		appEstacionamiento = new AppEstacionamiento(mockedSEM, mockedCelular, patente, mockedModo);
		finFranjaHoraria = LocalTime.of(20, 0, 0);
		horaDeInicio = LocalTime.of(11, 0, 0);
		when(mockedSEM.getPrecioHora()).thenReturn((double)1);
		when(mockedSEM.getFinDeFranjaHoraria()).thenReturn(finFranjaHoraria);
	}
	
	@Test
	void testIniciarEstacionamiento() {
		appEstacionamiento.iniciarEstacionamiento(horaDeInicio);
		verify(mockedModo).iniciarEstacionamiento(horaDeInicio);
	}
	
	@Test
	void testFinalizarEstacionamiento() {
		appEstacionamiento.finalizarEstacionamiento(patente);
		verify(mockedModo).finalizarEstacionamiento(patente);
	}
	

	@Test
	void testSaldoDisponible() {
		appEstacionamiento.saldoDisponible();
		verify(mockedCelular).getCredito();
	}
	
	@Test
	void testWalking() {
		appEstacionamiento.setEstadoDesplazamiento(mockedEstado);
		appEstacionamiento.walking();
		verify(mockedEstado).walking();
	}
	
	@Test
	void testDriving() {
		appEstacionamiento.setEstadoDesplazamiento(mockedEstado);
		appEstacionamiento.driving();
		verify(mockedEstado).driving();
	}

	@Test
	void testPosibleInicioEstacionamiento() {
		String posicionUsuario = "x;y";
		when((!(mockedSEM.esVigente(patente))) && (mockedSEM.esZonaMedida(posicionUsuario))).thenReturn(true);
		appEstacionamiento.setAsistenciaAlUsuario(mockedAlerta);
		appEstacionamiento.posibleInicioEstacionamiento(posicionUsuario);
		verify(mockedModo).darInicio();
		verify(mockedAlerta).alertaDeInicio();
	}
	
	@Test
	void testPosibleFinEstacionamiento() {
		String posicionUsuario = "x;y";
		when((!(mockedSEM.esVigente(patente))) && (mockedSEM.esZonaMedida(posicionUsuario))).thenReturn(true);
		appEstacionamiento.setAsistenciaAlUsuario(mockedAlerta);
		appEstacionamiento.posibleInicioEstacionamiento(posicionUsuario);
		appEstacionamiento.posibleInicioEstacionamiento(posicionUsuario);
		when(mockedSEM.esVigente(patente)).thenReturn(true);
		appEstacionamiento.setModo(mockedModo);
		appEstacionamiento.posibleFinEstacionamiento(posicionUsuario);
		verify(mockedModo).darFin();
		verify(mockedAlerta).alertaDeFin();
	}
	
	


}
