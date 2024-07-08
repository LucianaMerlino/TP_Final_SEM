package tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.po2.unq.TPFinalSEM.Celular;
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
	
	LocalTime horaInicioPrimerEstacionamiento;
	LocalTime horaFinPrimerEstacionamiento;
	
	LocalTime horaInicioSegundoEstacionamiento;
	LocalTime horaFinSegundoEstacionamiento;
	
	LocalTime horaInicioTercerEstacionamiento;
	LocalTime horaFinTercerEstacionamiento;
	
	
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
	
	Celular celularPrimerCliente;
	Celular celularSegundoCliente;
	Celular celularTercerCliente;
	
	// Se inicializan los DOC que van a ser mockeados:
	
	// Excercise:

	@BeforeEach
	void setUp() throws Exception {
	
	// Se asignan instancias de SUT y DOCs a las variables inicializadas previamente:
	
	precioPorHora = 40;
	inicioFranja = LocalTime.of(7, 0);
	finFranja = LocalTime.of(20, 0);
	
	// dia y horas de inicio y fin para los estacionamientos via app:
	
	horaInicioPrimerEstacionamiento = LocalTime.of(8, 0);
	horaFinPrimerEstacionamiento = LocalTime.of(9, 0);
	
	horaInicioSegundoEstacionamiento = LocalTime.of(10, 0);
	horaFinSegundoEstacionamiento = LocalTime.of(11, 0);
	
	horaInicioTercerEstacionamiento = LocalTime.of(12, 0);
	horaFinTercerEstacionamiento = LocalTime.of(13, 0);
	
	// dia y horas de inicio y fin para los estacionamientos via compra puntual:
	
	horaInicioCompraPuntual = LocalTime.of(8, 0);
	
	horaFinCompraPuntual = LocalTime.of(11, 0);
	
	celularPrimerCliente = mock(Celular.class);
	celularSegundoCliente = mock(Celular.class);
	celularTercerCliente = mock(Celular.class);
	
	primerEstacionamientoViaApp = new EstacionamientoViaApp(horaInicioPrimerEstacionamiento, 
															horaFinPrimerEstacionamiento, "123",
														    celularPrimerCliente);
														    
	segundoEstacionamientoViaApp = new EstacionamientoViaApp(horaInicioSegundoEstacionamiento, 
															 horaFinSegundoEstacionamiento, "1234",
															 celularSegundoCliente);
															 
	tercerEstacionamientoViaApp = new EstacionamientoViaApp(horaInicioTercerEstacionamiento, 
															horaFinTercerEstacionamiento, "12345", 
															celularTercerCliente);
															
	
	
	compraPuntual = new CompraPuntual(777, 3, "ABC 123");
	
	primerEstacionamientoViaCompra = new EstacionamientoViaCompra(compraPuntual, horaInicioCompraPuntual,
																  horaFinCompraPuntual, "ABCD");
	
	// SUT:
		
	sem = new SEM(precioPorHora, inicioFranja, finFranja);
	
	sem.iniciarEstacionamientoViaApp(primerEstacionamientoViaApp);
	sem.iniciarEstacionamientoViaApp(segundoEstacionamientoViaApp);
	sem.iniciarEstacionamientoViaApp(tercerEstacionamientoViaApp);
	
	sem.iniciarEstacionamientoViaCompra(compraPuntual, 
										horaInicioCompraPuntual,
										horaFinCompraPuntual);
	
	
	when(celularPrimerCliente.getNumero()).thenReturn(12345);
	when(celularPrimerCliente.getCredito()).thenReturn(100.0);
	
	when(celularSegundoCliente.getNumero()).thenReturn(1234);
	when(celularSegundoCliente.getCredito()).thenReturn(200.0);
	
	when(celularTercerCliente.getNumero()).thenReturn(123);
	when(celularTercerCliente.getCredito()).thenReturn(300.0);

	}
	
	// Verify:

	@Test
	void finalizarEstacionamientoViaAppTest() {
	
		/**
		 * Se llama aparte al metodo finalizarEstacionamientoViaApp(celular), para finalizar un estacionamiento
		 * via app, que tiene el numero de celular del celular dado, 
		 * */
		
		List<EstacionamientoViaApp> estacionamientosViaAppFiltrados = sem.getEstacionamientos().stream()
															   			 .filter(estacionamiento -> estacionamiento instanceof EstacionamientoViaApp)
								  							   			 .map(estacionamiento -> (EstacionamientoViaApp) estacionamiento)
								  							   			 .collect(Collectors.toList());
		// este metodo ni siquiera filtra y se queda con los estacionamientos de tipo via app
		
		EstacionamientoViaApp estacionamientoFinalizado = estacionamientosViaAppFiltrados.stream()
								  							 							 .filter(estacionamiento -> estacionamiento.getCelular().getNumero() ==
								  							 						    							celularSegundoCliente.getNumero())
								  							 							 .findFirst().get();
		// y este metodo ni siquiera encuentra al que le decís, no hace nada, empezó a fallar cuando agregue el via compra a la lista
		assertTrue(estacionamientoFinalizado.noEsVigente());
		
	}
	/*
	
	@Test
	void finalizarTodosLosEstacionamientosVigentesTest() {
		
		sem.finalizarTodosLosEstacionamientosVigentes();
		
		boolean estanLosEstacionamientosFinalizados = sem.getEstacionamientos().stream()
																			   .allMatch(estacionamiento -> estacionamiento.noEsVigente());	
		
		assertTrue(estanLosEstacionamientosFinalizados);
	}
	
	@Test
	void iniciarEstacionamientoViaCompraTest() {
	
		sem.iniciarEstacionamientoViaCompra(compraPuntual, 
											horaInicioCompraPuntual,
											horaFinCompraPuntual);
		
		boolean existeUnEstacionamientoViaCompra = sem.getEstacionamientos().stream()
																	  		 .anyMatch(estacionamiento -> estacionamiento instanceof EstacionamientoViaCompra);
	
		assertTrue(existeUnEstacionamientoViaCompra);
	
	}*/
	
	

}
