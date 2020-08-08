package avaliacao_alunos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Aluno {
	private List<Double> notas;
	
	public boolean validaNota(Double nota) {
		if (nota >= 0D && nota <= 10D)
			return true;
		else
			return false;
	}

	public boolean validaNotas(Double[] notas) {
		int validaNotas = 0;

		for (int indexNota = 0; indexNota < notas.length; indexNota++) {
			if (validaNota(notas[indexNota]))
				validaNotas++;
		}
		return (validaNotas == notas.length);

	}

	public void incluirNotas(Double... notas) {
		if (validaNotas(notas))
			this.notas = Arrays.asList(notas);
		else
			this.notas = new ArrayList<Double>(0);
	}

	public List<Double> getNotas() {
			return this.notas;
	}

	public List<Double> incluirPesos(Double... pesos) {
		return Arrays.asList(pesos);
	}
}
