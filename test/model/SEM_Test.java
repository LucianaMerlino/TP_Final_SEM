package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SEM_Test {

	SEM sem;
	LocalTime inicioFranjaHoraria; 
	LocalTime finFranjaHoraria;
	Double precioHora;
	Zona mockedZona;
	CompraPuntual mockedCompra;
	Observador mockedObservador;
	Estacionamiento mockedEstacionamiento;
	Estacionamiento mockedEstVigente;
	Estacionamiento mockedEstNoVigente;
	InfoEstacionamiento info;
	
	@BeforeEach
	void setUp() throws Exception {
		inicioFranjaHoraria = LocalTime.of(7, 0);
		finFranjaHoraria = LocalTime.of(20, 0);
		precioHora = 2.0;
		sem = new SEM(inicioFranjaHoraria, finFranjaHoraria, precioHora);
		mockedObservador = mock(Observador.class);
		sem.suscribirObservador(mockedObservador);
	}
	
	@Test
	void TestEsZonaMedida() {
		mockedZona = mock(Zona.class);
		String ubicacion = "X;Y";
		sem.nuevaZonaMedida(mockedZona);
		when(mockedZona.pertenece(ubicacion)).thenReturn(true);
		assertTrue(sem.esZonaMedida(ubicacion));
	}
	
	@Test
	void testIniciarEstacionamientoViaCompraPuntual() {
		mockedCompra = mock(CompraPuntual.class);
		when(mockedCompra.getFechaHora()).thenReturn(LocalDateTime.of(2024, 2, 2, 14, 0));
		when(mockedCompra.getPatente()).thenReturn("Patente");
		sem.iniciarEstacionamientoViaCompra(mockedCompra);
		assertFalse(sem.getEstacionamientos().isEmpty());
		assertFalse(sem.getCompras().isEmpty());
		verify(mockedObservador).notificacionInicioEstacionamiento();
		
	}
	
	@Test
	void testIniciarEstacionamientoViaApp() {
		LocalTime horaInicio = LocalTime.of(11, 0);
		String patente  = "AB6754";
		String nroCelular = "+12-3445-3322";
		sem.iniciarEstacionamientoViaApp(horaInicio, patente, nroCelular);
		assertFalse(sem.getEstacionamientos().isEmpty());
		verify(mockedObservador).notificacionInicioEstacionamiento();
	}
	
	@Test
	void testFinalizarestacionamientoViaApp() {
		LocalTime horaInicio = LocalTime.of(11, 0);
		String patente  = "AB6754";
		mockedEstacionamiento = mock(Estacionamiento.class);
		when(mockedEstacionamiento.getHoraInicio()).thenReturn(horaInicio);
		when(mockedEstacionamiento.getPatente()).thenReturn(patente);
		when(mockedEstacionamiento.esVigente()).thenReturn(true);
		when(mockedEstacionamiento.getFecha()).thenReturn(LocalDate.now());
		when(mockedEstacionamiento.getHoraFin()).thenReturn(LocalTime.now());
		sem.getEstacionamientos().add(mockedEstacionamiento);
		sem.finalizarEstacionamientoViaApp(patente);
		verify(mockedEstacionamiento).setHoraFin(any(LocalTime.class));
		verify(mockedObservador).notificacionFinEstacionamiento();
	}
	
	@Test
	void testEsVigente() {
		String patenteVigente  = "AB6754";
		mockedEstVigente = mock(Estacionamiento.class);
		when(mockedEstVigente.getFecha()).thenReturn(LocalDate.now());
		when(mockedEstVigente.esVigente()).thenReturn(true);
		when(mockedEstVigente.getPatente()).thenReturn(patenteVigente);
		
		String patenteNoVigente  = "AB675hh";
		mockedEstNoVigente = mock(Estacionamiento.class);
		when(mockedEstNoVigente.getFecha()).thenReturn(LocalDate.now());
		when(mockedEstNoVigente.esVigente()).thenReturn(false);
		when(mockedEstNoVigente.getPatente()).thenReturn(patenteNoVigente);
		
		sem.getEstacionamientos().add(mockedEstVigente);
		sem.getEstacionamientos().add(mockedEstNoVigente);
		assertTrue(sem.esVigente(patenteVigente));
		assertFalse(sem.esVigente(patenteNoVigente));
		
	}
	
	@Test
	void testFinalizarTodosLosEstacionamientosVigentes() {
		mockedEstVigente = mock(Estacionamiento.class);
		when(mockedEstVigente.getFecha()).thenReturn(LocalDate.now());
		when(mockedEstVigente.esVigente()).thenReturn(true);
	
		mockedEstNoVigente = mock(Estacionamiento.class);
		when(mockedEstNoVigente.getFecha()).thenReturn(LocalDate.now());
		when(mockedEstNoVigente.esVigente()).thenReturn(false);
	
		sem.getEstacionamientos().add(mockedEstVigente);
		sem.getEstacionamientos().add(mockedEstNoVigente);
		sem.finalizarTodosLosEstacionamientosVigentes();
		verify(mockedEstVigente).setHoraFin(finFranjaHoraria);
	}
	
	@Test
	void testRegistrarInfraccion() {
		Infraccion infraccion = mock(Infraccion.class);
		sem.registrarInfraccion(infraccion);
		assertFalse(sem.getInfracciones().isEmpty());
	}


}
