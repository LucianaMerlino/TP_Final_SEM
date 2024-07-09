package model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstacionamientoViaAppTest {
	private Celular celular;
	private EstacionamientoViaApp estacionamientoViaApp;

	@BeforeEach
	void setUp() throws Exception {
		estacionamientoViaApp = new EstacionamientoViaApp(LocalDateTime.now(), "AAA", celular);
	}

	@Test
	void test() {
		assertNotNull(estacionamientoViaApp);
	}

}
