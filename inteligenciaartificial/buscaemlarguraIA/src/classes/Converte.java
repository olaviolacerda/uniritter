package classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Converte {
	public List<String> transforma(String File) {
		ArrayList<String> conteudo = new ArrayList<String>();
		BufferedReader br = null;
		try {
			String s;
			br = new BufferedReader(new FileReader(File));
			while ((s = br.readLine()) != null) {
				conteudo.add(s);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		return conteudo;
	}

	public String[][] Criamatriz(List<String> conteudo) {
		int linha = conteudo.size();
		int coluna = conteudo.size();
		String[][] matriz = new String[linha][coluna];
		for (int i = 0; i < linha; i++) {
			for (int j = 0; j < coluna; j++) {
				matriz[i][j] = "";
				String s = conteudo.get(i);
				for (int x = 0; x < s.length(); x++) {
					Character caracter = s.charAt(x);
					if (!caracter.equals('|')) {
						matriz[i][j] += caracter.toString();
					} else if (x != 0 && j < coluna-1) {
						j++;
						matriz[i][j] = "";
					}
				}
			}
		}

		return matriz;
	}

	public int[][] IntTransforma(String[][] conteudo) {
		int[][] matriz = new int[conteudo.length][conteudo.length];
		int aux;
		for (int i = 0; i < conteudo.length; i++) {
			for (int j = 0; j < conteudo.length; j++) {
				matriz[i][j] = Integer.valueOf(conteudo[i][j]);
				
			}
		}

		return matriz;
	}

}
