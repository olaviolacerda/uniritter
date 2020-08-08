package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.Calculadora;

public class CalculadoraTest {
	private Calculadora hp12c;
	
	@Before
	public void inicializa(){
		hp12c = new Calculadora();
	}
	
	
	@Test
	public void testaSoma7Mais5Igual12() {
		assertEquals(12, hp12c.soma(7, 5), 0.001);
	}
	
	@Test
	public void testaSubtrai2Menos4Igual2Negativo() {
		assertEquals(-2, hp12c.subtrai(2, 4), 0.001);
	}
	
	@Test
	public void testaMultiplica3Por5Igual15(){
		assertEquals(15, hp12c.multiplica(3, 5), 0.001);
	}
	
	@Test
	public void testaDivide6Por3Igual2(){
		assertEquals(2, hp12c.divide(6, 3), 0.001);
	}
	
	@Test
	public void testaFatorial5Igual120(){
		assertEquals(120, hp12c.fatorial(5), 0.001);
	}
	
	
	
}
