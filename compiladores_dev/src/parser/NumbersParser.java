// Generated from src/Numbers.g4 by ANTLR 4.5.3


    package parser;


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class NumbersParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		NEWLINE=10, HEXADECIMAL=11, BINARY=12, REAL=13, DECIMAL=14, BIN_DIGIT=15;
	public static final int
		RULE_exprtotal = 0, RULE_operador = 1, RULE_expr = 2, RULE_pare = 3;
	public static final String[] ruleNames = {
		"exprtotal", "operador", "expr", "pare"
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

	@Override
	public String getGrammarFileName() { return "Numbers.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public NumbersParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ExprtotalContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public OperadorContext operador() {
			return getRuleContext(OperadorContext.class,0);
		}
		public ExprtotalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprtotal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumbersListener ) ((NumbersListener)listener).enterExprtotal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumbersListener ) ((NumbersListener)listener).exitExprtotal(this);
		}
	}

	public final ExprtotalContext exprtotal() throws RecognitionException {
		ExprtotalContext _localctx = new ExprtotalContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_exprtotal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			expr();
			setState(9);
			operador();
			setState(10);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperadorContext extends ParserRuleContext {
		public OperadorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operador; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumbersListener ) ((NumbersListener)listener).enterOperador(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumbersListener ) ((NumbersListener)listener).exitOperador(this);
		}
	}

	public final OperadorContext operador() throws RecognitionException {
		OperadorContext _localctx = new OperadorContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_operador);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public PareContext pare() {
			return getRuleContext(PareContext.class,0);
		}
		public TerminalNode DECIMAL() { return getToken(NumbersParser.DECIMAL, 0); }
		public TerminalNode HEXADECIMAL() { return getToken(NumbersParser.HEXADECIMAL, 0); }
		public TerminalNode REAL() { return getToken(NumbersParser.REAL, 0); }
		public TerminalNode BINARY() { return getToken(NumbersParser.BINARY, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumbersListener ) ((NumbersListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumbersListener ) ((NumbersListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expr);
		int _la;
		try {
			setState(16);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(14);
				pare();
				}
				break;
			case HEXADECIMAL:
			case BINARY:
			case REAL:
			case DECIMAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(15);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << HEXADECIMAL) | (1L << BINARY) | (1L << REAL) | (1L << DECIMAL))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PareContext extends ParserRuleContext {
		public ExprtotalContext exprtotal() {
			return getRuleContext(ExprtotalContext.class,0);
		}
		public PareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumbersListener ) ((NumbersListener)listener).enterPare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumbersListener ) ((NumbersListener)listener).exitPare(this);
		}
	}

	public final PareContext pare() throws RecognitionException {
		PareContext _localctx = new PareContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_pare);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			match(T__7);
			setState(19);
			exprtotal();
			setState(20);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\21\31\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\5\4\23\n\4\3\5\3"+
		"\5\3\5\3\5\3\5\2\2\6\2\4\6\b\2\4\3\2\3\t\3\2\r\20\25\2\n\3\2\2\2\4\16"+
		"\3\2\2\2\6\22\3\2\2\2\b\24\3\2\2\2\n\13\5\6\4\2\13\f\5\4\3\2\f\r\5\6\4"+
		"\2\r\3\3\2\2\2\16\17\t\2\2\2\17\5\3\2\2\2\20\23\5\b\5\2\21\23\t\3\2\2"+
		"\22\20\3\2\2\2\22\21\3\2\2\2\23\7\3\2\2\2\24\25\7\n\2\2\25\26\5\2\2\2"+
		"\26\27\7\13\2\2\27\t\3\2\2\2\3\22";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}