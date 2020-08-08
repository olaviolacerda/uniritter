package tests;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

import Person.Gender;
import Person.Person;
import RightMeasureCalculator.TGCCalculator;
import RightMeasureCalculator.TGCStatus;


public class TGCCalculatorTest {
	
	TGCCalculator tgc;
	Person man;
	Person woman;
	Person woman_old;
	
	@Before
	public void initialize() {
		tgc = new TGCCalculator();
		man = new Person(Gender.MALE, 160D, 1.9D, 30);
		woman = new Person(Gender.FEMALE, 50D, 1.6D, 20);
		woman_old = new Person(Gender.FEMALE, 30D, 1.6D,50);
	}
	
	
	@Test
	public void testTGCHomem30AnosIMC44() {
		assertEquals(43.884D, tgc.calculate(man), 0.01);
	}
	
	@Test 
	public void testTGCMulher20AnosIMC19() {
		assertEquals(22.636D, tgc.calculate(woman), 0.01);
	}
	
	@Test 
	public void testTGCtoPercentage() {
		Double tgcValue = tgc.calculate(woman);
		assertEquals("22.63%", tgc.evaluatePercentage(tgcValue));
	}
	
	@Test
	public void testTGCAceitavelHomem(){
		assertEquals(TGCStatus.FORA_DA_FAIXA, tgc.getSituation(man));
	}

	@Test
	public void testTGCIdealMulher(){
		assertEquals(TGCStatus.IDEAL, tgc.getSituation(woman_old));
	}
	
}
