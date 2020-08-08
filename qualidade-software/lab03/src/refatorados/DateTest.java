package refatorados;

import static org.junit.Assert.*;

import org.junit.Test;

public class DateTest {

	
	@Test
	public void testValidDate() {
		Date data = new Date(21, 03, 2010);
		assertEquals("21/3/2010", data.toString());
	}
	
	@Test
	public void testInvalidDayOnFebruary() {
		Date data = new Date(29, 02, 2011);
		assertNotEquals("29/2/2011", data.toString());
	}
	
	@Test
	public void testValidDayOnFebruary() {
		Date data = new Date(29, 02, 2012);
		assertEquals("29/2/2012", data.toString());
	}


}
