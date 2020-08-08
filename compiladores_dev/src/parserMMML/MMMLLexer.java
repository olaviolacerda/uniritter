// Generated from src/MMML.g4 by ANTLR 4.5.3

package parserMMML;	

import java.util.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MMMLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, WS=24, COMMENT=25, 
		TOK_ID=26, TOK_CONCAT=27, TOK_NEG=28, TOK_POWER=29, TOK_DIV_OR_MUL=30, 
		TOK_PLUS_OR_MINUS=31, TOK_CMP_GT_LT=32, TOK_CMP_EQ_DIFF=33, TOK_BOOL_AND_OR=34, 
		TOK_REL_OP=35, TOK_STR_LIT=36, TOK_CHAR_LIT=37, FLOAT=38, DECIMAL=39, 
		HEXADECIMAL=40, BINARY=41;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "WS", "COMMENT", 
		"TOK_ID", "TOK_CONCAT", "TOK_NEG", "TOK_POWER", "TOK_DIV_OR_MUL", "TOK_PLUS_OR_MINUS", 
		"TOK_CMP_GT_LT", "TOK_CMP_EQ_DIFF", "TOK_BOOL_AND_OR", "TOK_REL_OP", "TOK_STR_LIT", 
		"TOK_CHAR_LIT", "FLOAT", "DECIMAL", "HEXADECIMAL", "BINARY", "BIN_DIGIT", 
		"HEX_DIGIT", "DEC_DIGIT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'def'", "'main'", "'='", "','", "':'", "'int'", "'boolean'", "'str'", 
		"'float'", "'char'", "'[]'", "'if'", "'then'", "'else'", "'let'", "'in'", 
		"'_'", "'('", "')'", "'['", "']'", "'nil'", "'true'", null, null, null, 
		"'::'", "'!'", "'^'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"WS", "COMMENT", "TOK_ID", "TOK_CONCAT", "TOK_NEG", "TOK_POWER", "TOK_DIV_OR_MUL", 
		"TOK_PLUS_OR_MINUS", "TOK_CMP_GT_LT", "TOK_CMP_EQ_DIFF", "TOK_BOOL_AND_OR", 
		"TOK_REL_OP", "TOK_STR_LIT", "TOK_CHAR_LIT", "FLOAT", "DECIMAL", "HEXADECIMAL", 
		"BINARY"
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


	public MMMLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MMML.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2+\u0142\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3"+
		"\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3"+
		"\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\6\31\u00b1\n\31\r\31\16\31"+
		"\u00b2\3\31\3\31\3\32\3\32\3\32\3\32\7\32\u00bb\n\32\f\32\16\32\u00be"+
		"\13\32\3\32\5\32\u00c1\n\32\3\32\3\32\3\32\3\32\3\33\3\33\7\33\u00c9\n"+
		"\33\f\33\16\33\u00cc\13\33\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37"+
		"\3 \3 \3!\3!\3!\3!\3!\5!\u00de\n!\3\"\3\"\3\"\3\"\5\"\u00e4\n\"\3#\3#"+
		"\3#\3#\5#\u00ea\n#\3$\3$\3$\3$\3$\3$\3$\5$\u00f3\n$\3%\3%\3%\3%\3%\5%"+
		"\u00fa\n%\7%\u00fc\n%\f%\16%\u00ff\13%\3%\3%\3&\3&\3&\3&\3&\5&\u0108\n"+
		"&\5&\u010a\n&\3&\3&\3\'\5\'\u010f\n\'\3\'\6\'\u0112\n\'\r\'\16\'\u0113"+
		"\3\'\3\'\6\'\u0118\n\'\r\'\16\'\u0119\3\'\3\'\5\'\u011e\n\'\3\'\6\'\u0121"+
		"\n\'\r\'\16\'\u0122\5\'\u0125\n\'\3(\5(\u0128\n(\3(\6(\u012b\n(\r(\16"+
		"(\u012c\3)\3)\3)\6)\u0132\n)\r)\16)\u0133\3*\6*\u0137\n*\r*\16*\u0138"+
		"\3*\3*\3+\3+\3,\3,\3-\3-\2\2.\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U\2W\2Y\2\3\2\20"+
		"\5\2\13\f\16\17\"\"\4\2\f\f\17\17\4\2C\\c|\6\2\62;C\\aac|\4\2,,\61\61"+
		"\4\2--//\4\2>>@@\6\2\f\f\17\17$$^^\6\2\f\f\17\17))^^\4\2GGgg\5\2--//^"+
		"^\3\2\62\63\5\2\62;CHch\3\2\62;\u0158\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3"+
		"\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65"+
		"\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3"+
		"\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2"+
		"\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\3[\3\2\2\2\5_\3\2\2\2\7d\3\2\2\2\t"+
		"f\3\2\2\2\13h\3\2\2\2\rj\3\2\2\2\17n\3\2\2\2\21v\3\2\2\2\23z\3\2\2\2\25"+
		"\u0080\3\2\2\2\27\u0085\3\2\2\2\31\u0088\3\2\2\2\33\u008b\3\2\2\2\35\u0090"+
		"\3\2\2\2\37\u0095\3\2\2\2!\u0099\3\2\2\2#\u009c\3\2\2\2%\u009e\3\2\2\2"+
		"\'\u00a0\3\2\2\2)\u00a2\3\2\2\2+\u00a4\3\2\2\2-\u00a6\3\2\2\2/\u00aa\3"+
		"\2\2\2\61\u00b0\3\2\2\2\63\u00b6\3\2\2\2\65\u00c6\3\2\2\2\67\u00cd\3\2"+
		"\2\29\u00d0\3\2\2\2;\u00d2\3\2\2\2=\u00d4\3\2\2\2?\u00d6\3\2\2\2A\u00dd"+
		"\3\2\2\2C\u00e3\3\2\2\2E\u00e9\3\2\2\2G\u00f2\3\2\2\2I\u00f4\3\2\2\2K"+
		"\u0102\3\2\2\2M\u010e\3\2\2\2O\u0127\3\2\2\2Q\u012e\3\2\2\2S\u0136\3\2"+
		"\2\2U\u013c\3\2\2\2W\u013e\3\2\2\2Y\u0140\3\2\2\2[\\\7f\2\2\\]\7g\2\2"+
		"]^\7h\2\2^\4\3\2\2\2_`\7o\2\2`a\7c\2\2ab\7k\2\2bc\7p\2\2c\6\3\2\2\2de"+
		"\7?\2\2e\b\3\2\2\2fg\7.\2\2g\n\3\2\2\2hi\7<\2\2i\f\3\2\2\2jk\7k\2\2kl"+
		"\7p\2\2lm\7v\2\2m\16\3\2\2\2no\7d\2\2op\7q\2\2pq\7q\2\2qr\7n\2\2rs\7g"+
		"\2\2st\7c\2\2tu\7p\2\2u\20\3\2\2\2vw\7u\2\2wx\7v\2\2xy\7t\2\2y\22\3\2"+
		"\2\2z{\7h\2\2{|\7n\2\2|}\7q\2\2}~\7c\2\2~\177\7v\2\2\177\24\3\2\2\2\u0080"+
		"\u0081\7e\2\2\u0081\u0082\7j\2\2\u0082\u0083\7c\2\2\u0083\u0084\7t\2\2"+
		"\u0084\26\3\2\2\2\u0085\u0086\7]\2\2\u0086\u0087\7_\2\2\u0087\30\3\2\2"+
		"\2\u0088\u0089\7k\2\2\u0089\u008a\7h\2\2\u008a\32\3\2\2\2\u008b\u008c"+
		"\7v\2\2\u008c\u008d\7j\2\2\u008d\u008e\7g\2\2\u008e\u008f\7p\2\2\u008f"+
		"\34\3\2\2\2\u0090\u0091\7g\2\2\u0091\u0092\7n\2\2\u0092\u0093\7u\2\2\u0093"+
		"\u0094\7g\2\2\u0094\36\3\2\2\2\u0095\u0096\7n\2\2\u0096\u0097\7g\2\2\u0097"+
		"\u0098\7v\2\2\u0098 \3\2\2\2\u0099\u009a\7k\2\2\u009a\u009b\7p\2\2\u009b"+
		"\"\3\2\2\2\u009c\u009d\7a\2\2\u009d$\3\2\2\2\u009e\u009f\7*\2\2\u009f"+
		"&\3\2\2\2\u00a0\u00a1\7+\2\2\u00a1(\3\2\2\2\u00a2\u00a3\7]\2\2\u00a3*"+
		"\3\2\2\2\u00a4\u00a5\7_\2\2\u00a5,\3\2\2\2\u00a6\u00a7\7p\2\2\u00a7\u00a8"+
		"\7k\2\2\u00a8\u00a9\7n\2\2\u00a9.\3\2\2\2\u00aa\u00ab\7v\2\2\u00ab\u00ac"+
		"\7t\2\2\u00ac\u00ad\7w\2\2\u00ad\u00ae\7g\2\2\u00ae\60\3\2\2\2\u00af\u00b1"+
		"\t\2\2\2\u00b0\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2"+
		"\u00b3\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\b\31\2\2\u00b5\62\3\2\2"+
		"\2\u00b6\u00b7\7\61\2\2\u00b7\u00b8\7\61\2\2\u00b8\u00bc\3\2\2\2\u00b9"+
		"\u00bb\n\3\2\2\u00ba\u00b9\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2"+
		"\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf"+
		"\u00c1\7\17\2\2\u00c0\u00bf\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\3"+
		"\2\2\2\u00c2\u00c3\7\f\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\b\32\2\2\u00c5"+
		"\64\3\2\2\2\u00c6\u00ca\t\4\2\2\u00c7\u00c9\t\5\2\2\u00c8\u00c7\3\2\2"+
		"\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\66"+
		"\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd\u00ce\7<\2\2\u00ce\u00cf\7<\2\2\u00cf"+
		"8\3\2\2\2\u00d0\u00d1\7#\2\2\u00d1:\3\2\2\2\u00d2\u00d3\7`\2\2\u00d3<"+
		"\3\2\2\2\u00d4\u00d5\t\6\2\2\u00d5>\3\2\2\2\u00d6\u00d7\t\7\2\2\u00d7"+
		"@\3\2\2\2\u00d8\u00d9\7>\2\2\u00d9\u00de\7?\2\2\u00da\u00db\7@\2\2\u00db"+
		"\u00de\7?\2\2\u00dc\u00de\t\b\2\2\u00dd\u00d8\3\2\2\2\u00dd\u00da\3\2"+
		"\2\2\u00dd\u00dc\3\2\2\2\u00deB\3\2\2\2\u00df\u00e0\7?\2\2\u00e0\u00e4"+
		"\7?\2\2\u00e1\u00e2\7#\2\2\u00e2\u00e4\7?\2\2\u00e3\u00df\3\2\2\2\u00e3"+
		"\u00e1\3\2\2\2\u00e4D\3\2\2\2\u00e5\u00e6\7(\2\2\u00e6\u00ea\7(\2\2\u00e7"+
		"\u00e8\7~\2\2\u00e8\u00ea\7~\2\2\u00e9\u00e5\3\2\2\2\u00e9\u00e7\3\2\2"+
		"\2\u00eaF\3\2\2\2\u00eb\u00f3\t\b\2\2\u00ec\u00ed\7?\2\2\u00ed\u00f3\7"+
		"?\2\2\u00ee\u00ef\7@\2\2\u00ef\u00f3\7?\2\2\u00f0\u00f1\7>\2\2\u00f1\u00f3"+
		"\7?\2\2\u00f2\u00eb\3\2\2\2\u00f2\u00ec\3\2\2\2\u00f2\u00ee\3\2\2\2\u00f2"+
		"\u00f0\3\2\2\2\u00f3H\3\2\2\2\u00f4\u00fd\7$\2\2\u00f5\u00fc\n\t\2\2\u00f6"+
		"\u00f9\7^\2\2\u00f7\u00fa\13\2\2\2\u00f8\u00fa\7\2\2\3\u00f9\u00f7\3\2"+
		"\2\2\u00f9\u00f8\3\2\2\2\u00fa\u00fc\3\2\2\2\u00fb\u00f5\3\2\2\2\u00fb"+
		"\u00f6\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe\3\2"+
		"\2\2\u00fe\u0100\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100\u0101\7$\2\2\u0101"+
		"J\3\2\2\2\u0102\u0109\7)\2\2\u0103\u010a\n\n\2\2\u0104\u0107\7^\2\2\u0105"+
		"\u0108\13\2\2\2\u0106\u0108\7\2\2\3\u0107\u0105\3\2\2\2\u0107\u0106\3"+
		"\2\2\2\u0108\u010a\3\2\2\2\u0109\u0103\3\2\2\2\u0109\u0104\3\2\2\2\u010a"+
		"\u010b\3\2\2\2\u010b\u010c\7)\2\2\u010cL\3\2\2\2\u010d\u010f\7/\2\2\u010e"+
		"\u010d\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0111\3\2\2\2\u0110\u0112\5Y"+
		"-\2\u0111\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0111\3\2\2\2\u0113"+
		"\u0114\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0117\7\60\2\2\u0116\u0118\5"+
		"Y-\2\u0117\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u0117\3\2\2\2\u0119"+
		"\u011a\3\2\2\2\u011a\u0124\3\2\2\2\u011b\u011d\t\13\2\2\u011c\u011e\t"+
		"\f\2\2\u011d\u011c\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u0120\3\2\2\2\u011f"+
		"\u0121\5Y-\2\u0120\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0120\3\2\2"+
		"\2\u0122\u0123\3\2\2\2\u0123\u0125\3\2\2\2\u0124\u011b\3\2\2\2\u0124\u0125"+
		"\3\2\2\2\u0125N\3\2\2\2\u0126\u0128\7/\2\2\u0127\u0126\3\2\2\2\u0127\u0128"+
		"\3\2\2\2\u0128\u012a\3\2\2\2\u0129\u012b\5Y-\2\u012a\u0129\3\2\2\2\u012b"+
		"\u012c\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012dP\3\2\2\2"+
		"\u012e\u012f\7\62\2\2\u012f\u0131\7z\2\2\u0130\u0132\5W,\2\u0131\u0130"+
		"\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134"+
		"R\3\2\2\2\u0135\u0137\5U+\2\u0136\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138"+
		"\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013b\7d"+
		"\2\2\u013bT\3\2\2\2\u013c\u013d\t\r\2\2\u013dV\3\2\2\2\u013e\u013f\t\16"+
		"\2\2\u013fX\3\2\2\2\u0140\u0141\t\17\2\2\u0141Z\3\2\2\2\32\2\u00b2\u00bc"+
		"\u00c0\u00ca\u00dd\u00e3\u00e9\u00f2\u00f9\u00fb\u00fd\u0107\u0109\u010e"+
		"\u0113\u0119\u011d\u0122\u0124\u0127\u012c\u0133\u0138\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}