package dicionarios;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Leet {

	static Map<String, String> oxford = new HashMap<String, String>();

	public Leet() {
		oxford.put("a", "@");
		oxford.put("b", "|:");
		oxford.put("c", "[");
		oxford.put("d", "|>");
		oxford.put("e", "&");
		oxford.put("f", "Ph");
		oxford.put("g", "C-");
		oxford.put("h", "#");
		oxford.put("i", "!");
		oxford.put("j", "(/");
		oxford.put("K", "X");
		oxford.put("l", "1_");
		oxford.put("m", "lVl");
		oxford.put("n", "/V");
		oxford.put("o", "()");
		oxford.put("p", "|*");
		oxford.put("q", "(_,)");
		oxford.put("r", "12");
		oxford.put("s", "$");
		oxford.put("t", "+");
		oxford.put("u", "|_|");
		oxford.put("v", "\\/");
		oxford.put("w", "VV");
		oxford.put("x", ")(");
		oxford.put("y", "`/");
		oxford.put("z", "%");
	}

	public String pegaCodigo(String caracter) {
		return oxford.get(caracter.toLowerCase());
	}

	public String pegaLetra(String codigo) {
		Iterator<java.util.Map.Entry<String, String>> it = oxford.entrySet().iterator();
		while (it.hasNext()) {
			java.util.Map.Entry<String, String> pares = it.next();
			if (pares.getValue().equals(codigo)) {
				codigo = (String) pares.getKey();
			}
		}
		return codigo;

	}

	public String decodificaLeet(String mensagem) {
		String[] mensagemSplit = mensagem.split(" ");
		StringBuilder mensagem_decodificada = new StringBuilder();

		for (int i = 0; i < mensagemSplit.length; i++) {
			if (mensagemSplit[i].equals("") && mensagemSplit[i + 1].equals("") && mensagemSplit[i + 2].equals("")) {
				mensagem_decodificada.append(" ");
			} else {
				mensagem_decodificada.append(pegaLetra(mensagemSplit[i]));
			}
		}
		return mensagem_decodificada.toString();
	}

	public String codificaLeet(String palavra) {
		String[] letras = palavra.split("");
		StringBuilder mensagem_codificada = new StringBuilder();
		for (int i = 0; i < letras.length; i++) {
			if (letras[i].equals(" ")) {
				mensagem_codificada.append("   ");
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
