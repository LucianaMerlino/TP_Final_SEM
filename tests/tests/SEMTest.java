package tests;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.po2.unq.TPFinalSEM.CompraPuntual;
import ar.edu.po2.unq.TPFinalSEM.Estacionamiento;
import ar.edu.po2.unq.TPFinalSEM.EstacionamientoViaApp;
import ar.edu.po2.unq.TPFinalSEM.EstacionamientoViaCompra;
import ar.edu.po2.unq.TPFinalSEM.SEM;


class SEMTest {
	
	// SetUp: inicializo las variables necesarias: 

	// Se inicializa un SEM, que es el SUT, con sus atributos correspondientes:
	
	SEM sem;
	int precioPorHora;
	LocalTime inicioFranja;
	LocalTime finFranja;
	List<Estacionamiento> estacionamientos;
	
	LocalTime horaInicioEstacionamiento;
	LocalDate diaInicioEstacionamiento;
	LocalDateTime diaYfechaEstacionamiento;
	
	LocalTime horaFinEstacionamiento;
	LocalDate diaFinEstacionamiento;
	LocalDateTime diaYfechaFinEstacionamiento;
	
	LocalTime horaInicioCompraPuntual;
	LocalDate diaInicioCompraPuntual;
	LocalDateTime diaYfechaEstacionamientoPorCompra;
	
	LocalTime horaFinCompraPuntual;
	LocalDate diaFinCompraPuntual;
	LocalDateTime diaYfechaFinEstacionamientoPorCompra;
	
	LocalDate diaInicioYFinFranjaDelSem;
	
	LocalDateTime diaYhoraInicioFranjaSem;
	LocalDateTime diaYhoraFinFranjaSem;
	
	EstacionamientoViaApp primerEstacionamientoViaApp;
	EstacionamientoViaApp segundoEstacionamientoViaApp;
	EstacionamientoViaApp tercerEstacionamientoViaApp;
	EstacionamientoViaCompra primerEstacionamientoViaCompra;
	CompraPuntual compraPuntual;
	
	// Se inicializan los DOC que van a ser mockeados:
	
	// Excercise:

	@BeforeEach
	void setUp() throws Exception {
	
	// Se asignan instancias de SUT y DOCs a las variables inicializadas previamente:
	
	precioPorHora = 40;
	inicioFranja = LocalTime.of(7, 0);
	finFranja = LocalTime.of(20, 0);
	diaInicioYFinFranjaDelSem = LocalDate.of(2024, 6, 21);
	diaYhoraInicioFranjaSem = LocalDateTime.of(diaInicioYFinFranjaDelSem, inicioFranja);
	diaYhoraFinFranjaSem = LocalDateTime.of(diaInicioYFinFranjaDelSem, finFranja);
	
	// dia y horas de inicio y fin para los estacionamientos via app:
	
	horaInicioEstacionamiento = LocalTime.of(8, 0);
	diaInicioEstacionamiento = LocalDate.of(2024, 6, 21);
	diaYfechaEstacionamiento = LocalDateTime.of(diaInicioEstacionamiento, horaInicioEstacionamiento);
	
	horaFinEstacionamiento = LocalTime.of(9, 0);
	diaFinEstacionamiento = LocalDate.of(2024, 6, 21);
	diaYfechaFinEstacionamiento = LocalDateTime.of(diaFinEstacionamiento, horaFinEstacionamiento);
	
	// dia y horas de inicio y fin para los estacionamientos via compra puntual:
	
	horaInicioCompraPuntual = LocalTime.of(8, 0);
	diaInicioCompraPuntual = LocalDate.of(2024, 6, 21);
	diaYfechaEstacionamientoPorCompra = LocalDateTime.of(diaInicioEstacionamiento, horaInicioEstacionamiento);
	
	horaFinCompraPuntual = LocalTime.of(11, 0);
	diaFinCompraPuntual = LocalDate.of(2024, 6, 21);
	diaYfechaFinEstacionamientoPorCompra = LocalDateTime.of(diaFinEstacionamiento, horaFinEstacionamiento);
	
	primerEstacionamientoViaApp = new EstacionamientoViaApp(diaYfechaEstacionamiento, diaYfechaFinEstacionamiento, "123", 12345);
	segundoEstacionamientoViaApp = new EstacionamientoViaApp(diaYfechaEstacionamiento, diaYfechaFinEstacionamiento, "1234", 1234);
	tercerEstacionamientoViaApp = new EstacionamientoViaApp(diaYfechaEstacionamiento, diaYfechaFinEstacionamiento, "12345", 123);
	
	compraPuntual = new CompraPuntual(777, 3, "ABC 123");
	primerEstacionamientoViaCompra = new EstacionamientoViaCompra(compraPuntual, diaYfechaEstacionamientoPorCompra, diaYfechaFinEstacionamientoPorCompra, "ABC 123");
	
	estacionamientos = new ArrayList<Estacionamiento>();
	
	estacionamientos.add(primerEstacionamientoViaApp);
	estacionamientos.add(segundoEstacionamientoViaApp);
	estacionamientos.add(tercerEstacionamientoViaApp);	
	estacionamientos.add(primerEstacionamientoViaCompra);
	
	// SUT:
		
	sem = new SEM(precioPorHora, diaYhoraInicioFranjaSem, diaYhoraFinFranjaSem, estacionamientos);

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
	
	@Test
	void finalizarTodosLosEstacionamientosVigentes() {
		
		sem.finalizarTodosLosEstacionamientosVigentes();
		
		boolean estanLosEstacionamientosFinalizados = sem.getEstacionamientos().stream()
																			   .allMatch(estacionamiento -> estacionamiento.esVigente());	
		
		assertTrue(estanLosEstacionamientosFinalizados);
	}

}
