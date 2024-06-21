package tests;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.po2.unq.TPFinalSEM.Estacionamiento;
import ar.edu.po2.unq.TPFinalSEM.EstacionamientoViaApp;
import ar.edu.po2.unq.TPFinalSEM.SEM;


class SEMTest {
	
	// SetUp: inicializo las variables necesarias: 

	// Se inicializa un SEM, que es el SUT, con sus atributos correspondientes:
	
	SEM sem;
	int precioPorHora;
	LocalTime inicioFranja;
	LocalTime finFranja;
	List<Estacionamiento> estacionamientos;
	List<Estacionamiento> estacionamientosEsperados;
	
	EstacionamientoViaApp primerEstacionamientoViaApp;
	EstacionamientoViaApp segundoEstacionamientoViaApp;
	EstacionamientoViaApp tercerEstacionamientoViaApp;
	
	// Se inicializan los DOC que van a ser mockeados:
	
	// Excercise:

	@BeforeEach
	void setUp() throws Exception {
	
	// Se asignan instancias de SUT y DOCs a las variables inicializadas previamente:
	
	precioPorHora = 40;
	inicioFranja = LocalTime.of(7, 0);
	finFranja = LocalTime.of(20, 0);
	LocalTime horaInicioEst = LocalTime.of(8, 0);
	LocalDate diaInicioEst = LocalDate.of(2024, 6, 21);
	LocalDateTime diayFechaEst = LocalDateTime.of(diaInicioEst, horaInicioEst);
	
	LocalTime horaFinEst = LocalTime.of(9, 0);
	LocalDate diaFinEst = LocalDate.of(2024, 6, 21);
	LocalDateTime diayFechaFinEst = LocalDateTime.of(diaFinEst, horaFinEst);
	
	primerEstacionamientoViaApp = new EstacionamientoViaApp(diayFechaEst, diayFechaFinEst, "123", 12345);
	segundoEstacionamientoViaApp = new EstacionamientoViaApp(diayFechaEst, diayFechaFinEst, "1234", 1234);
	tercerEstacionamientoViaApp = new EstacionamientoViaApp(diayFechaEst, diayFechaFinEst, "12345", 123);
	
	estacionamientos = new ArrayList<Estacionamiento>();
	
	estacionamientos.add(primerEstacionamientoViaApp);
	estacionamientos.add(segundoEstacionamientoViaApp);
	estacionamientos.add(tercerEstacionamientoViaApp);	
	
	// SUT:
		
	sem = new SEM(precioPorHora, inicioFranja, finFranja, estacionamientos);

	}
	
	// Verify:

	@Test
	void finalizarEstacionamientoViaAppTest() {
		
		sem.finalizarEstacionamientoViaApp(1234);
		EstacionamientoViaApp estacionamientoFinalizado = sem.getEstacionamientos().stream()
															 .filter(estacionamiento -> estacionamiento instanceof EstacionamientoViaApp)
								  							 .map(estacionamiento -> (EstacionamientoViaApp) estacionamiento)
								  							 .filter(estacionamiento -> estacionamiento.getNumeroDeCelular() == 1234)
								  							 .findFirst().get();
		
		assertTrue(estacionamientoFinalizado.noEsVigente());
		
	}

}
