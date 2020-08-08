package avaliacao_alunos;

import java.util.ArrayList;
import java.util.List;

public class MediaPonderada implements Media {

	private List<Double> pesos;

	public MediaPonderada() {
		this.pesos = new ArrayList<>(0);
	}

	public MediaPonderada(List<Double> pesos) {
		this.pesos = pesos;
	}

	private void verificaPeso(List<Double> notas) {
		if (pesos.size() == 0)
			for (@SuppressWarnings("unused") Double nota : notas)
				pesos.add(1D);
	}

	public Double calcula(List<Double> notas) {
		verificaPeso(notas);
		Double somaNotasPesos = 0D;
		Double somaPesos = pesos.stream().reduce(0.0, Double::sum);

		for (Double nota : notas) {
			int indexNota = notas.indexOf(nota);
			somaNotasPesos += nota * pesos.get(indexNota);
		}

		return somaNotasPesos / somaPesos;
	}

}
