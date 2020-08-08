package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Person.Gender;
import Person.Person;
import RightMeasureCalculator.PCalculator;

public class PCalculatorTest {

	PCalculator pValue;
	Person man;
	Person woman;

	@Before
	public void initialize() {
		pValue = new PCalculator();
		man = new Person(Gender.MALE, 60D, 1.8D, 20);
		woman = new Person(Gender.FEMALE, 50D, 1.6D, 70);
	}
	
	@Test
	public void testaCalculoPMulherIdosa() {
		assertEquals(55D, pValue.calculate(woman), 0.01);
	}
	
	@Test
	public void testaCalculoPHomemJovem() {
		assertEquals(72.5D, pValue.calculate(man), 0.01);
	}
	

	@Test 
	public void testHomemObesoPesoIdeal() {
		assertEquals("72.5KG", pValue.getPesoIdeal(man));
	}
}
