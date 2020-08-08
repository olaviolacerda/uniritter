package parserMMML;

import java.io.File;
import java.io.FileInputStream;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import parserMMML.MMMLParser.FuncbodyContext;

public class RunParser {
	public static void main(String[] args) throws Exception {
		MMMLLexer lexer;
		MMMLParser parser;
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"mimimil source code", "mmm");
		chooser.setFileFilter(filter);
		chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
		int retval = chooser.showOpenDialog(null);
		if (retval != JFileChooser.APPROVE_OPTION)
			return;

		File input = chooser.getSelectedFile();

		try {
			FileInputStream fin = new FileInputStream(input);
			lexer = new MMMLLexer(new ANTLRInputStream(fin));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			parser = new MMMLParser(tokens);
			System.out.println(parser.funcbody().ofb);
		} catch (Exception e) {
			// Snorlax!!
			System.out.println("Errado:" + e);
			System.exit(1);
			return;
		}
	}

}
