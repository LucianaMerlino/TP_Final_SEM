package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstacionamientoViaCompraTest {
	private CompraPuntual compraPuntualMocked;
	private EstacionamientoViaCompra estacionamientoViaCompra;

	@BeforeEach
	void setUp() throws Exception {
		compraPuntualMocked = mock(CompraPuntual.class);
		when(compraPuntualMocked.getFechaHora()).thenReturn(LocalDateTime.of(LocalDate.of(2024, 7, 4), LocalTime.of(10, 0)));
		when(compraPuntualMocked.getHoras()).thenReturn(2);
		estacionamientoViaCompra = new EstacionamientoViaCompra(compraPuntualMocked);
	}

	@Test
	void testConstructor() {
		assertNotNull(estacionamientoViaCompra);
	}
	
	@Test
	void getHoraFin() {
		assertEquals(LocalDateTime.of(LocalDate.of(2024, 7, 4), LocalTime.of(12, 0)), estacionamientoViaCompra.getHoraFin()); 
	}

}
