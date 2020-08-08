package exercicio2_temperatura;

public class Temperatura {
	public double converte_temperatura(double temperatura, Grau grau_atual, Grau grau_objetivo) {
		if (grau_atual.equals(Grau.CELSIUS)) {
			return converte_de_celsius(temperatura, grau_objetivo);
		} else if (grau_atual.equals(Grau.FAHRENHEIT)) {
			return converte_de_fahrenheit(temperatura, grau_objetivo);
		} else if (grau_atual.equals(Grau.KELVIN)) {
			return converte_de_kelvin(temperatura, grau_objetivo);
		} else {
			return temperatura;
		}
	}

	public double converte_de_celsius(double temperatura, Grau grau_objetivo) {
		double resultado = 0;
		if (grau_objetivo.equals(Grau.KELVIN)) {
			resultado = temperatura + 273.15;
		} else if (grau_objetivo.equals(Grau.FAHRENHEIT)) {
			resultado = (temperatura * 1.8) + 32;
		}
		return resultado;
	}

	public double converte_de_kelvin(double temperatura, Grau grau_objetivo) {
		double resultado = 0;
		if (grau_objetivo.equals(Grau.CELSIUS)) {
			resultado = temperatura - 273.15;
		} else if (grau_objetivo.equals(Grau.FAHRENHEIT)) {
			resultado = (temperatura * 1.8) - 459.67;
		}
		return resultado;
	}

	public double converte_de_fahrenheit(double temperatura, Grau grau_objetivo) {
		double resultado = 0;
		if (grau_objetivo.equals(Grau.KELVIN)) {
			resultado = (temperatura + 459.67) / 1.8;
		} else if (grau_objetivo.equals(Grau.CELSIUS)) {
			resultado = (temperatura - 32) / 1.8;
		}
		return resultado;
	}
}
