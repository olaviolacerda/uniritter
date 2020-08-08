package avaliacao_alunos;

public class Avaliacao {

	private Media tipoMedia;
	private Aluno aluno;
	private static Double FALSE = -1D;

	public Avaliacao(Aluno aluno, Media tipoMedia) {
		this.aluno = aluno;
		this.tipoMedia = tipoMedia;
	}

	public Double calculaMedia() {
		if (!aluno.getNotas().isEmpty())
			return tipoMedia.calcula(aluno.getNotas());
		else
			return FALSE;
	}

	public Status verificaSituacaoAluno() {
		Double media = calculaMedia();

		if (media == FALSE)
			return Status.ENTRADAS_INVALIDAS;
		if (media >= 7D)
			return Status.APROVADO;
		if (media >= 5D && media <= 6.9D)
			return Status.EM_EXAME;
		else
			return Status.REPROVADO;

	}
}
