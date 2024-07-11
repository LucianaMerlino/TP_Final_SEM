package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.mockito.Mockito.*;

class EstadoDesplazamientoTest {
		AppEstacionamiento mockedApp;
		EstadoDesplazamiento estado;
		GPS mockedGps;
		ModoManual mockedModo;
		SEM mockedSem;
		Celular mockedCelular;
	
	@BeforeEach
	void setUp() throws Exception{
		mockedApp = mock(AppEstacionamiento.class);
		mockedGps = mock(GPS.class);
	}

	@Test
	void testEstadoActivadoWalking() {
		estado = new EstadoActivado(mockedApp, mockedGps);
		estado.walking();
		verify(mockedApp).setEstadoDesplazamiento(any(EstadoWalking.class));
	}
	
	@Test
	void testEstadoActivadoDriving() {
		estado = new EstadoActivado(mockedApp, mockedGps);
		estado.driving();
		verify(mockedApp).setEstadoDesplazamiento(any(EstadoDriving.class));
	}
	
	@Test
	void testEstadoDrivingWalking() {
		String ubicacion = "X;y";
		when(mockedGps.posicionUsuario()).thenReturn(ubicacion);
		estado = new EstadoDriving(mockedApp, mockedGps);
		estado.walking();
		verify(mockedApp).setEstadoDesplazamiento(any(EstadoWalking.class));
		verify(mockedApp).posibleInicioEstacionamiento(ubicacion);
	}
	
	@Test
	void testEstadoWalkingDriving() {
		String ubicacion = "X;y";
		when(mockedGps.posicionUsuario()).thenReturn(ubicacion);
		estado = new EstadoWalking(mockedApp, mockedGps);
		estado.driving();
		verify(mockedApp).setEstadoDesplazamiento(any(EstadoDriving.class));
		verify(mockedApp).posibleFinEstacionamiento(ubicacion);
	}
	
	@Test
	void testEstadoDesactivado() {
		mockedSem = mock(SEM.class);
		when(mockedApp.getSEM()).thenReturn(mockedSem);
		mockedCelular = mock(Celular.class);
		when(mockedApp.getCelular()).thenReturn(mockedCelular);
		String patente = "ad";
		when(mockedApp.getPatente()).thenReturn(patente);
		estado = new EstadoDesactivado(mockedApp, mockedGps);
		verify(mockedApp).setModo(any (ModoManual.class));
		verify(mockedApp).setAsistenciaAlUsuario(any(AlertaDesactivada.class));
		
	}
	


}
