package Tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import avaliacao_alunos.Aluno;
import avaliacao_alunos.Avaliacao;
import avaliacao_alunos.MediaAritmetica;
import avaliacao_alunos.MediaPonderada;
import avaliacao_alunos.Status;

public class TesteAvaliacoes {

	static Aluno aluno;
	static Avaliacao avaliacao;
	static List<Double> pesos;

	@Before
	public void inicializa() {
		aluno = new Aluno();
		pesos = new ArrayList<>(0);
	}

	@Test
	public void testaMediaAritmeticaCom3NotasReprovado() {
		aluno.incluirNotas(4D, 5D, 3D);
		avaliacao = new Avaliacao(aluno, new MediaAritmetica());
		assertEquals(Status.REPROVADO, avaliacao.verificaSituacaoAluno());
	}

	@Test
	public void testaEntradaInvalida() {
		aluno.incluirNotas(4D, 15D, 16D, 2D, 3D, 10D, 3D);
		avaliacao = new Avaliacao(aluno, new MediaAritmetica());
		assertEquals(Status.ENTRADAS_INVALIDAS, avaliacao.verificaSituacaoAluno());
	}

	@Test
	public void testaMediaPonderadaCom5NotasAprovado() {
		aluno.incluirNotas(5D, 6D, 7D, 8D, 10D);
		pesos = aluno.incluirPesos(2D, 3D, 4D, 5D, 2D);
		avaliacao = new Avaliacao(aluno, new MediaPonderada(pesos));
		assertEquals(Status.APROVADO, avaliacao.verificaSituacaoAluno());
	}

	@Test
	public void testaMediaPonderadaCom5NotasSemPesosAprovado() {
		aluno.incluirNotas(5D, 6D, 7D, 8D, 10D);
		avaliacao = new Avaliacao(aluno, new MediaPonderada());
		assertEquals(Status.APROVADO, avaliacao.verificaSituacaoAluno());
	}

	@Test
	public void testaMediaAritmeticaCom3NotasEmExame() {
		aluno.incluirNotas(3D, 6D, 7D);
		avaliacao = new Avaliacao(aluno, new MediaAritmetica());
		assertEquals(Status.EM_EXAME, avaliacao.verificaSituacaoAluno());
	}
}
