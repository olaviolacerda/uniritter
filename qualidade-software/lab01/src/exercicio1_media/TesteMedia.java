package exercicio1_media;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteMedia {
	
		private Aluno  aluno_desleixado;
		private Aluno  aluno_estudioso;
		private Aluno  aluno_preguicoso;
		
		@Before
		public void inicializa(){
			aluno_desleixado = new Aluno(7,5,6);
			aluno_estudioso = new Aluno(7,8,9);
			aluno_preguicoso = new Aluno(6.8,3,5);
		}
		
	
		@Test
		public void testaAlunoDesleixadoAprovado() {
			assertEquals("aprovado!", aluno_desleixado.verificaSituacao());
		}
		
		@Test
		public void testaAlunoDesleixadoReprovado() {
			assertEquals("reprovado!", aluno_desleixado.verificaSituacao());
		}
		
		@Test
		public void testaAlunoEstudiosoEmExame() {
			assertEquals("em exame!", aluno_estudioso.verificaSituacao());
		}
		@Test
		public void testaAlunoEstudiosoAprovado() {
			assertEquals("aprovado!", aluno_estudioso.verificaSituacao());
		}
		
		@Test
		public void testaAlunoPreguicosoReprovado() {
			assertEquals("reprovado!", aluno_preguicoso.verificaSituacao());
		}
}
