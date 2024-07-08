package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InfraccionTest {
	private Inspector inspectorMocked;
	private Infraccion infraccion;

	@BeforeEach
	void setUp() throws Exception {
		inspectorMocked = mock(Inspector.class) ;
		
		infraccion = new Infraccion("AAA", inspectorMocked);
	}

	@Test
	void testConstructor() {
		assertNotNull(infraccion);
	}
	
	@Test
	void testGetPatente() {
		assertEquals("AAA", infraccion.getPatente());
	}
	
	@Test
	void testGetInspector() {
		assertEquals(inspectorMocked, infraccion.getInspector());
	}

}
