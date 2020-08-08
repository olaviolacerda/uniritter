package parserMMML;

import org.antlr.v4.gui.TestRig;

public class RunRig {
	public static void main(String[] args) throws Exception {
		String[] rargs = new String[4];
		rargs[0] = "MMML"; // nome da gramatica
		rargs[1] = "funcbody"; // regra inicial
		rargs[2] = "-gui"; // abre a janela
		rargs[3] = "test.mmm"; // arquivo a parsear
		TestRig.main(rargs);
	}

}
