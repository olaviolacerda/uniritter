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
	public void testaEricoEspa�oBDecodificado() {
		assertEquals(". .-. .. -.-. ---   -...", mensagem.codificaMorse("erico b"));
	}

	@Test
	public void testaOlavioEspa�oLacerdaDecodificado() {
		assertEquals("--- .-.. .- ...- .. ---   .-.. .- -.-. . .-. -.. .-", mensagem.codificaMorse("Olavio Lacerda"));
	}

	@Test
	public void testa23Espa�o5Espa�o4Codificado() {
		assertEquals("23 5 4", mensagem.decodificaMorse("..--- ...--   .....   ....-"));
	}
	
	@Test
	public void testaEricoEspa�oNetoCodificado() {
		assertEquals("erico neto", mensagem.decodificaMorse(". .-. .. -.-. ---   -. . - ---"));
	}
}
