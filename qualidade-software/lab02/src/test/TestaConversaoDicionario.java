package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dicionario.Dicionario;

public class TestaConversaoDicionario {

	static Dicionario mensagem;

	@Before
	public void inicializa() {
		mensagem = new Dicionario();
	}

	@Test
	public void testaEricoEspaçoBDecodificado() {
		assertEquals(". .-. .. -.-. ---   -...", mensagem.codificaMorse("erico b"));
	}

	@Test
	public void testaOlavioEspaçoLacerdaDecodificado() {
		assertEquals("--- .-.. .- ...- .. ---   .-.. .- -.-. . .-. -.. .-", mensagem.codificaMorse("Olavio Lacerda"));
	}

	@Test
	public void testa23Espaço5Espaço4Codificado() {
		assertEquals("23 5 4", mensagem.decodificaMorse("..--- ...--   .....   ....-"));
	}
	
	@Test
	public void testaEricoEspaçoNetoCodificado() {
		assertEquals("erico neto", mensagem.decodificaMorse(". .-. .. -.-. ---   -. . - ---"));
	}
}
