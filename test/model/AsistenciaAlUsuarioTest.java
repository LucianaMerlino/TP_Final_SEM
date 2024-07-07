package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AsistenciaAlUsuarioTest {
	
	AsistenciaAlUsuario asistencia;

	@Test
	void testAlertaActivadaDeInicio() {
		asistencia = new AlertaActivada();
		assertEquals(asistencia.alertaDeInicio(), "Alerta de inicio de estacionamiento, por favor inicie su estacionamineto Medido.");
	}
	
	@Test
	void testAlertaActivadaDeFin() {
		asistencia = new AlertaActivada();
		assertEquals(asistencia.alertaDeFin(), "Alerta de fin de estacionamiento, por favor finalice su estacionamineto Medido.");
	}
	
	@Test
	void testAlertaDesctivadaDeInicio() {
		asistencia = new AlertaDesactivada();
		assertEquals(asistencia.alertaDeInicio(), null);
	}
	
	@Test
	void testAlertaDesctivadaDeFin() {
		asistencia = new AlertaDesactivada();
		assertEquals(asistencia.alertaDeFin(), null);
	}

}
