package parser;
import java.io.FileInputStream;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

public class Numbers {
	public static void main(String[] args) {

		NumbersLexer lexer;
		Token tk;

		// Cria instancia do lexer criado pelo ANTLR

		try {
			lexer = new NumbersLexer(new ANTLRInputStream(System.in));
		} catch (Exception e) {
			// WOBBUFFET!
			System.out.println("Erro:" + e);
			System.exit(1);
			return;
		}
		// Le da entrada Padrao ateh chegar digitar CTRL-D (Linux/Mac)
		// ou CTRL-Z (Windows)

		do {
			tk = lexer.nextToken();
			switch (tk.getType()) {
			case NumbersLexer.BINARY:
				System.out.println("bin: " + tk.getText());
				break;
			case NumbersLexer.HEXADECIMAL:
				System.out.println("hex: " + tk.getText());
				break;
			case NumbersLexer.REAL:
				System.out.println("real: " + tk.getText());
				break;
			case NumbersLexer.DECIMAL:
				System.out.println("dec: " + tk.getText());
				break;
			default:
				break;
			}
		} while (tk != null && tk.getType() != Token.EOF);

		// // testando parser
		 JFileChooser chooser = new JFileChooser();
		 chooser.setFileFilter(new FileNameExtensionFilter(
		 "numbers source code", "num"));
		 int retval = chooser.showOpenDialog(null);
		 if (retval != JFileChooser.APPROVE_OPTION)
		 return;
		 try {
		 FileInputStream fin = new FileInputStream(chooser.getSelectedFile());
		 NumbersLexer n = new NumbersLexer(new ANTLRInputStream(fin));
		 CommonTokenStream tokens = new CommonTokenStream(n);
		 NumbersParser parser = new NumbersParser(tokens);
		 parser.exprtotal();
		 parser.operador();
		 parser.expr();
		 parser.pare();
		 System.out.println("Funcionou!!");
		 } catch (Exception e) {
		 // Blastoise!
		 System.out.println("Erro:" + e);
		 return;
		 }

	}
}