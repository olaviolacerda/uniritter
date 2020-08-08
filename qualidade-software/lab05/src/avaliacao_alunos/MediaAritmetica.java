package avaliacao_alunos;

import java.util.List;

public class MediaAritmetica implements Media {
	public Double calcula(List<Double> notas) {
		return notas.stream().reduce(0.0, Double::sum) / notas.size();
	}
}
