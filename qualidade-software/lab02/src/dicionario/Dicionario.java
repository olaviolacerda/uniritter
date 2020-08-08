package dicionario;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Dicionario {

	static Map<String, String> aurelio = new HashMap<String, String>();

	public Dicionario() {
		aurelio.put("a", ".-");
		aurelio.put("b", "-...");
		aurelio.put("c", "-.-.");
		aurelio.put("d", "-..");
		aurelio.put("e", ".");
		aurelio.put("f", "..-.");
		aurelio.put("g", "--.");
		aurelio.put("h", "....");
		aurelio.put("i", "..");
		aurelio.put("j", ".---");
		aurelio.put("K", "-.-");
		aurelio.put("l", ".-..");
		aurelio.put("m", "--");
		aurelio.put("n", "-.");
		aurelio.put("o", "---");
		aurelio.put("p", ".--.");
		aurelio.put("q", "--.-");
		aurelio.put("r", ".-.");
		aurelio.put("s", "...");
		aurelio.put("t", "-");
		aurelio.put("u", "..-");
		aurelio.put("v", "...-");
		aurelio.put("w", ".--");
		aurelio.put("x", "-..-");
		aurelio.put("y", "-.--");
		aurelio.put("z", "--..");
		aurelio.put("1", ".----");
		aurelio.put("2", "..---");
		aurelio.put("3", "...--");
		aurelio.put("4", "....-");
		aurelio.put("5", ".....");
		aurelio.put("6", "-....");
		aurelio.put("7", "--...");
		aurelio.put("8", "---..");
		aurelio.put("9", "----.");
		aurelio.put("0", "-----");
	}

	public String pegaCodigo(String caracter) {
		return aurelio.get(caracter.toLowerCase());
	}

	public String pegaLetra(String codigo) {
		Iterator<java.util.Map.Entry<String, String>> it = aurelio.entrySet().iterator();
		while (it.hasNext()) {
			java.util.Map.Entry<String, String> pares = it.next();
			if (pares.getValue().equals(codigo)) {
				codigo = (String) pares.getKey();
			}
		}
		return codigo;

	}

	public String decodificaMorse(String mensagem) {
		String[] mensagemSplit = mensagem.split(" ");
		StringBuilder mensagem_decodificada = new StringBuilder();

		for (int i = 0; i < mensagemSplit.length; i++) {
			if (mensagemSplit[i].equals("") && mensagemSplit[i+1].equals("") ) {
				mensagem_decodificada.append(" ");
			} else {
				mensagem_decodificada.append(pegaLetra(mensagemSplit[i]));
			}
		}
		return mensagem_decodificada.toString();
	}

	public String codificaMorse(String palavra) {
		String[] letras = palavra.split("");
		StringBuilder mensagem_codificada = new StringBuilder();
		for (int i = 0; i < letras.length; i++) {
			if (letras[i].equals(" ")) {
				mensagem_codificada.append("  ");
			} else {
				if (i == letras.length - 1) {
					mensagem_codificada.append(pegaCodigo(letras[i]));
				} else {
					mensagem_codificada.append(pegaCodigo(letras[i])).append(" ");
				}
			}
		}

		return mensagem_codificada.toString();
	}

}
