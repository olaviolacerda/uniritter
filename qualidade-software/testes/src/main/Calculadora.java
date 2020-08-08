package main;

public class Calculadora {

	public double soma(double a, double b) {
		return a + b;
	}

	public double subtrai(double a, double b) {
		return a - b;
	}

	public double multiplica(double a, double b) {
		return a * b;
	}

	public double divide(double a, double b) {
		return a / b;
	}

	public double fatorial(double n) {
		double resp = 0;
		int i = 0;
		while (i < n) {
			if (n <= 1) {
				resp = 1;
			} else {
				resp += fatorial(n - 1);
			}
			i++;
		}
		return resp;
	}
	
	public int exponencial(int a, int b){
		return (a ^ b);
	}
}
