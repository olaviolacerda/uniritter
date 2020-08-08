package dicionarios;

public class Conversor {

	private Leet dicionarioLeet;
	private Morse dicionarioMorse;

	public Conversor() {
		this.dicionarioLeet = new Leet();
		this.dicionarioMorse = new Morse();
	}

	public String decodifica(Tipo tipo, String codigo) {
		if (tipo.equals(Tipo.MORSE)) {
			return dicionarioMorse.decodificaMorse(codigo);
		} else {
			return dicionarioLeet.decodificaLeet(codigo);
		}
	}

	public String codifica(Tipo tipo, String frase) {
		if (tipo.equals(Tipo.MORSE)) {
			return dicionarioMorse.codificaMorse(frase);
		} else {
			return dicionarioLeet.codificaLeet(frase);
		}
	}
}
