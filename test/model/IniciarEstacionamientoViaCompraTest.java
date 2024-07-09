package model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

// import ar.edu.po2.unq.*;


class iniciarEstacionamientoViaCompraTest {

	SEM sem;
	int precioPorHora;
	LocalTime inicioFranja;
	LocalTime finFranja;
	EstacionamientoViaCompra primerEstacionamientoViaCompra;
	CompraPuntual compraPuntual;
	LocalTime horaInicioCompraPuntual;
	LocalTime horaFinCompraPuntual;
	PuntoDeVenta puntoDeVenta;

	@BeforeEach
	void setUp() throws Exception {
	
	// Se asignan instancias de SUT y DOCs a las variables inicializadas previamente:
	
	precioPorHora = 40;
	inicioFranja = LocalTime.of(7, 0);
	finFranja = LocalTime.of(20, 0);
	
	puntoDeVenta = mock(PuntoDeVenta.class);
	
	compraPuntual = new CompraPuntual(777, puntoDeVenta, 3, "ABC 123");
	
	horaInicioCompraPuntual = LocalTime.of(8, 0);
	
	horaFinCompraPuntual = LocalTime.of(11, 0);
	
	primerEstacionamientoViaCompra = new EstacionamientoViaCompra(compraPuntual);
																  
	// SUT:
		
	sem = new SEM(precioPorHora, inicioFranja, finFranja);
	
	}



	@Test
	void iniciarEstacionamientoViaCompraSEMTest() {
	
		sem.iniciarEstacionamientoViaCompra(compraPuntual);
		
		boolean existeUnEstacionamientoViaCompra = sem.getEstacionamientos().stream()
																	  		 .anyMatch(estacionamiento -> estacionamiento instanceof EstacionamientoViaCompra);
	
		assertTrue(existeUnEstacionamientoViaCompra);
	
	}
}