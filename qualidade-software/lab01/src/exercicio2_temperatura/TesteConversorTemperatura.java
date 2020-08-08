package exercicio2_temperatura;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TesteConversorTemperatura {
	private Temperatura temperatura;

	@Before
	public void inicializa() {
		temperatura = new Temperatura();
	}

	@Test
	public void testa0CelsiusIgual32Fahrenheit() {
		assertEquals(32, temperatura.converte_temperatura(0, Grau.CELSIUS, Grau.FAHRENHEIT), 0.001);
	}
	
	@Test
	public void testa0CelsiusIgual27315Kelvin() {
		assertEquals(273.15, temperatura.converte_temperatura(0, Grau.CELSIUS, Grau.KELVIN), 0.001);
	}
	
	@Test
	public void testa382NegativosFahrenheitIgual4315Kelvin() {
		assertEquals(43.15, temperatura.converte_temperatura(-382, Grau.FAHRENHEIT, Grau.KELVIN), 0.001);
	}
	
	@Test
	public void testa30KelvinIgual24315NegativosCelsius() {
		assertEquals(-243.15, temperatura.converte_temperatura(30, Grau.KELVIN, Grau.CELSIUS), 0.0001);
	}
	
	@Test
	public void testa25FahrenheitIgual388889NegativosCelsius() {
		assertEquals(-3.88889, temperatura.converte_temperatura(25, Grau.FAHRENHEIT, Grau.CELSIUS), 0.0001);
	}
}
