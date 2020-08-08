package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Person.Gender;
import Person.Person;
import RightMeasureCalculator.IMCCalculator;
import RightMeasureCalculator.IMCStatus;

public class IMCCalculatorTest {

	IMCCalculator imc;
	Person man;
	Person woman;
	

	@Before
	public void initialize() {
		imc = new IMCCalculator();
		man = new Person(Gender.MALE, 160D, 1.90D, 30);
		woman = new Person(Gender.FEMALE, 50D, 1.60D, 20);
	} 
	
	@Test
	public void testIMCHomemObeso() {
		assertEquals(44.32D, imc.calculate(man), 0.01);
	}
	
	
	@Test
	public void testIMCMulherPesoIdeal() {
		assertEquals(19.53D, imc.calculate(woman), 0.01);
	}
	
	@Test
	public void testMulher50KG160HPesoIdeal(){
		assertEquals(IMCStatus.IDEAL, imc.getSituation(woman));
	}
	
	@Test
	public void testHomem160KG190HObeso() {
		assertEquals(IMCStatus.OBESO, imc.getSituation(man));
	}
	
	
}

