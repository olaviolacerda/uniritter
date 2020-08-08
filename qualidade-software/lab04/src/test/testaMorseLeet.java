package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dicionarios.Conversor;
import dicionarios.Tipo;

public class testaMorseLeet {
	static Conversor conversor;

	@Before
	public void inicializa() {
		conversor = new Conversor();
	}

	@Test
	public void testaEricoEspaçoNetoCodificaMorse() {
		assertEquals(". .-. .. -.-. ---   -. . - ---", conversor.codifica(Tipo.MORSE, "erico neto"));
	}
	
	@Test
	public void testaNetoCodificaLeet(){
		assertEquals("/V & + ()", conversor.codifica(Tipo.LEET, "neto"));
	}
	
	@Test 
	public void testaEricoEspaçoAmaranteEspaçoNetoDecodificaLeet(){
		assertEquals("erico amarante neto", conversor.decodifica(Tipo.LEET, "& 12 ! [ ()    @ lVl @ 12 @ /V + &    /V & + ()"));
	}
	
	@Test
	public void testaEricoEspaçoAmaranteEspaçoNetoCodificaLeet(){
		assertEquals("& 12 ! [ ()    @ lVl @ 12 @ /V + &", conversor.codifica(Tipo.LEET, "erico amarante"));
	}
}
