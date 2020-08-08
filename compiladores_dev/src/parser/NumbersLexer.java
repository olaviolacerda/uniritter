// Generated from src/Numbers.g4 by ANTLR 4.5.3


    package parser;


import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class NumbersLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		NEWLINE=10, HEXADECIMAL=11, BINARY=12, REAL=13, DECIMAL=14, BIN_DIGIT=15;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"NEWLINE", "HEXADECIMAL", "BINARY", "REAL", "DECIMAL", "BIN_DIGIT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'^'", "'*'", "'/'", "'+'", "'-'", "'÷'", "'x'", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "NEWLINE", 
		"HEXADECIMAL", "BINARY", "REAL", "DECIMAL", "BIN_DIGIT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public NumbersLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Numbers.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\21k\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\6\13\65\n\13"+
		"\r\13\16\13\66\3\13\3\13\3\f\3\f\3\f\6\f>\n\f\r\f\16\f?\3\r\6\rC\n\r\r"+
		"\r\16\rD\3\r\3\r\3\16\5\16J\n\16\3\16\6\16M\n\16\r\16\16\16N\3\16\3\16"+
		"\6\16S\n\16\r\16\16\16T\3\16\3\16\5\16Y\n\16\3\16\6\16\\\n\16\r\16\16"+
		"\16]\5\16`\n\16\3\17\5\17c\n\17\3\17\6\17f\n\17\r\17\16\17g\3\20\3\20"+
		"\2\2\21\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\21\3\2\n\5\2\13\f\16\17\"\"\3\2\62\62\3\2zz\5\2\62;CHch\3\2"+
		"\62;\4\2GGgg\4\2--//\3\2\62\63u\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\3!\3\2\2\2\5#\3\2\2\2\7%\3\2\2\2\t\'\3\2\2\2\13)\3\2\2\2"+
		"\r+\3\2\2\2\17-\3\2\2\2\21/\3\2\2\2\23\61\3\2\2\2\25\64\3\2\2\2\27:\3"+
		"\2\2\2\31B\3\2\2\2\33I\3\2\2\2\35b\3\2\2\2\37i\3\2\2\2!\"\7`\2\2\"\4\3"+
		"\2\2\2#$\7,\2\2$\6\3\2\2\2%&\7\61\2\2&\b\3\2\2\2\'(\7-\2\2(\n\3\2\2\2"+
		")*\7/\2\2*\f\3\2\2\2+,\7\u00f9\2\2,\16\3\2\2\2-.\7z\2\2.\20\3\2\2\2/\60"+
		"\7*\2\2\60\22\3\2\2\2\61\62\7+\2\2\62\24\3\2\2\2\63\65\t\2\2\2\64\63\3"+
		"\2\2\2\65\66\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\678\3\2\2\289\b\13\2"+
		"\29\26\3\2\2\2:;\t\3\2\2;=\t\4\2\2<>\t\5\2\2=<\3\2\2\2>?\3\2\2\2?=\3\2"+
		"\2\2?@\3\2\2\2@\30\3\2\2\2AC\5\37\20\2BA\3\2\2\2CD\3\2\2\2DB\3\2\2\2D"+
		"E\3\2\2\2EF\3\2\2\2FG\7d\2\2G\32\3\2\2\2HJ\7/\2\2IH\3\2\2\2IJ\3\2\2\2"+
		"JL\3\2\2\2KM\t\6\2\2LK\3\2\2\2MN\3\2\2\2NL\3\2\2\2NO\3\2\2\2OP\3\2\2\2"+
		"PR\7\60\2\2QS\t\6\2\2RQ\3\2\2\2ST\3\2\2\2TR\3\2\2\2TU\3\2\2\2U_\3\2\2"+
		"\2VX\t\7\2\2WY\t\b\2\2XW\3\2\2\2XY\3\2\2\2Y[\3\2\2\2Z\\\t\6\2\2[Z\3\2"+
		"\2\2\\]\3\2\2\2][\3\2\2\2]^\3\2\2\2^`\3\2\2\2_V\3\2\2\2_`\3\2\2\2`\34"+
		"\3\2\2\2ac\7/\2\2ba\3\2\2\2bc\3\2\2\2ce\3\2\2\2df\t\6\2\2ed\3\2\2\2fg"+
		"\3\2\2\2ge\3\2\2\2gh\3\2\2\2h\36\3\2\2\2ij\t\t\2\2j \3\2\2\2\16\2\66?"+
		"DINTX]_bg\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}