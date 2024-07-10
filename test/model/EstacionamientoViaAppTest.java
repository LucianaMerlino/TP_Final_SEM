package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstacionamientoViaAppTest {
	private Celular celularMocked;
	private EstacionamientoViaApp estacionamientoViaApp;

	@BeforeEach
	void setUp() throws Exception {
		celularMocked = mock(Celular.class);

		estacionamientoViaApp = new EstacionamientoViaApp(LocalDateTime.now(), "AAA", celularMocked);
	}

	@Test
	void testConstructor() {
		assertNotNull(estacionamientoViaApp);
	}
	
	@Test
	void testGetNroCelular() {
		assertEquals("12345678", estacionamientoViaApp.getNroCelular());
	}

}
