package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PuntoDeVentaTest {
	
	private CompraPuntual compraPuntual;
	private RecargaCredito recargaCredito;
	private Celular celularMocked;
	private PuntoDeVenta puntoDeVenta;
	private SEM sem; 

	@BeforeEach
	void setUp() throws Exception {
		sem = mock(SEM.class);
		
		celularMocked = mock(Celular.class);

		puntoDeVenta = new PuntoDeVenta(sem);
		
	}

	@Test
	void testConstructor() {
		assertNotNull(puntoDeVenta);
	}
	
	@Test
	void testCrearEstacionamiento() {
		int nroControl = 2344;
		int horas = 2;
		String patente = "AC4323";
		puntoDeVenta.crearEstacionamiento(nroControl, horas, patente);
		verify(sem).registrarCompraPuntual(any(CompraPuntual.class));
		verify(sem).iniciarEstacionamientoViaCompra(any(CompraPuntual.class));

	}
	
	@Test
	void testCrearRecargaCredito() {
		int nroControl = 2344;
		Double monto = 20.0;
		puntoDeVenta.recargarCredito(nroControl, monto, celularMocked);
		verify(sem).registrarRecargaCredito(any(RecargaCredito.class));
		
		
	}

}