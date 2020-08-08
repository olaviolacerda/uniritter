// Generated from src/MMML.g4 by ANTLR 4.5.3

package parserMMML;	

import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MMMLParser extends Parser {
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
	public static final int
		RULE_program = 0, RULE_fdecls = 1, RULE_maindecl = 2, RULE_fdecl = 3, 
		RULE_fdeclparams = 4, RULE_fdeclparams_cont = 5, RULE_fdeclparam = 6, 
		RULE_functionname = 7, RULE_type = 8, RULE_basic_type = 9, RULE_sequence_type = 10, 
		RULE_funcbody = 11, RULE_ifexpr = 12, RULE_letexpr = 13, RULE_letlist = 14, 
		RULE_letlist_cont = 15, RULE_letvarexpr = 16, RULE_metaexpr = 17, RULE_sequence_expr = 18, 
		RULE_funcall = 19, RULE_cast = 20, RULE_funcall_params = 21, RULE_funcall_params_cont = 22, 
		RULE_literal = 23, RULE_strlit = 24, RULE_charlit = 25, RULE_number = 26, 
		RULE_symbol = 27;
	public static final String[] ruleNames = {
		"program", "fdecls", "maindecl", "fdecl", "fdeclparams", "fdeclparams_cont", 
		"fdeclparam", "functionname", "type", "basic_type", "sequence_type", "funcbody", 
		"ifexpr", "letexpr", "letlist", "letlist_cont", "letvarexpr", "metaexpr", 
		"sequence_expr", "funcall", "cast", "funcall_params", "funcall_params_cont", 
		"literal", "strlit", "charlit", "number", "symbol"
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

	@Override
	public String getGrammarFileName() { return "MMML.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		public NestedSymbolTable<Object> simbolos = new NestedSymbolTable<Object>();
		public Stack<Object> pilha = new Stack<Object>();
		
		NestedSymbolTable<String> tabela = new NestedSymbolTable<String>();
		private void imprimirTabela() {
			int i= 1;
		for (SymbolEntry<String> entry : tabela.getEntries()) {
	                System.out.println(i +"º simbolo= "+ entry);
	                i++;
	            }
	   }

	public MMMLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public FdeclsContext fdecls() {
			return getRuleContext(FdeclsContext.class,0);
		}
		public MaindeclContext maindecl() {
			return getRuleContext(MaindeclContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			fdecls();
			setState(57);
			maindecl();
			System.out.println("Parseou um programa!");
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

	public static class FdeclsContext extends ParserRuleContext {
		public FdeclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fdecls; }
	 
		public FdeclsContext() { }
		public void copyFrom(FdeclsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Fdecls_end_ruleContext extends FdeclsContext {
		public Fdecls_end_ruleContext(FdeclsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterFdecls_end_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitFdecls_end_rule(this);
		}
	}
	public static class Fdecls_one_decl_ruleContext extends FdeclsContext {
		public FdeclContext fdecl() {
			return getRuleContext(FdeclContext.class,0);
		}
		public FdeclsContext fdecls() {
			return getRuleContext(FdeclsContext.class,0);
		}
		public Fdecls_one_decl_ruleContext(FdeclsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterFdecls_one_decl_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitFdecls_one_decl_rule(this);
		}
	}

	public final FdeclsContext fdecls() throws RecognitionException {
		FdeclsContext _localctx = new FdeclsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_fdecls);
		try {
			setState(64);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new Fdecls_one_decl_ruleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				fdecl();
				setState(61);
				fdecls();
				}
				break;
			case 2:
				_localctx = new Fdecls_end_ruleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
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

	public static class MaindeclContext extends ParserRuleContext {
		public MaindeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_maindecl; }
	 
		public MaindeclContext() { }
		public void copyFrom(MaindeclContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Programmain_ruleContext extends MaindeclContext {
		public FuncbodyContext funcbody() {
			return getRuleContext(FuncbodyContext.class,0);
		}
		public Programmain_ruleContext(MaindeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterProgrammain_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitProgrammain_rule(this);
		}
	}

	public final MaindeclContext maindecl() throws RecognitionException {
		MaindeclContext _localctx = new MaindeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_maindecl);
		try {
			_localctx = new Programmain_ruleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(T__0);
			setState(67);
			match(T__1);
			setState(68);
			match(T__2);
			setState(69);
			funcbody();
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

	public static class FdeclContext extends ParserRuleContext {
		public FdeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fdecl; }
	 
		public FdeclContext() { }
		public void copyFrom(FdeclContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Funcdef_ruleContext extends FdeclContext {
		public FunctionnameContext functionname() {
			return getRuleContext(FunctionnameContext.class,0);
		}
		public FdeclparamsContext fdeclparams() {
			return getRuleContext(FdeclparamsContext.class,0);
		}
		public FuncbodyContext funcbody() {
			return getRuleContext(FuncbodyContext.class,0);
		}
		public Funcdef_ruleContext(FdeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterFuncdef_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitFuncdef_rule(this);
		}
	}

	public final FdeclContext fdecl() throws RecognitionException {
		FdeclContext _localctx = new FdeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_fdecl);
		try {
			_localctx = new Funcdef_ruleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(T__0);
			setState(72);
			functionname();
			setState(73);
			fdeclparams();
			setState(74);
			match(T__2);
			setState(75);
			funcbody();
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

	public static class FdeclparamsContext extends ParserRuleContext {
		public List<String> plist;
		public FdeclparamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fdeclparams; }
	 
		public FdeclparamsContext() { }
		public void copyFrom(FdeclparamsContext ctx) {
			super.copyFrom(ctx);
			this.plist = ctx.plist;
		}
	}
	public static class Fdeclparams_no_paramsContext extends FdeclparamsContext {
		public Fdeclparams_no_paramsContext(FdeclparamsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterFdeclparams_no_params(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitFdeclparams_no_params(this);
		}
	}
	public static class Fdeclparams_one_param_ruleContext extends FdeclparamsContext {
		public FdeclparamContext fdeclparam;
		public FdeclparamContext fdeclparam() {
			return getRuleContext(FdeclparamContext.class,0);
		}
		public Fdeclparams_contContext fdeclparams_cont() {
			return getRuleContext(Fdeclparams_contContext.class,0);
		}
		public Fdeclparams_one_param_ruleContext(FdeclparamsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterFdeclparams_one_param_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitFdeclparams_one_param_rule(this);
		}
	}

	public final FdeclparamsContext fdeclparams() throws RecognitionException {
		FdeclparamsContext _localctx = new FdeclparamsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fdeclparams);

		    ((FdeclparamsContext)_localctx).plist =  new ArrayList<String>();

		try {
			setState(82);
			switch (_input.LA(1)) {
			case TOK_ID:
				_localctx = new Fdeclparams_one_param_ruleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				((Fdeclparams_one_param_ruleContext)_localctx).fdeclparam = fdeclparam();

				            _localctx.plist.add(((Fdeclparams_one_param_ruleContext)_localctx).fdeclparam.pname);
				        
				setState(79);
				fdeclparams_cont(_localctx.plist);
				}
				break;
			case T__2:
				_localctx = new Fdeclparams_no_paramsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);

			    for (String s : _localctx.plist) {
			        System.out.println("Parametro: " + s);
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

	public static class Fdeclparams_contContext extends ParserRuleContext {
		public List<String> plist;
		public Fdeclparams_contContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Fdeclparams_contContext(ParserRuleContext parent, int invokingState, List<String> plist) {
			super(parent, invokingState);
			this.plist = plist;
		}
		@Override public int getRuleIndex() { return RULE_fdeclparams_cont; }
	 
		public Fdeclparams_contContext() { }
		public void copyFrom(Fdeclparams_contContext ctx) {
			super.copyFrom(ctx);
			this.plist = ctx.plist;
		}
	}
	public static class Fdeclparams_end_ruleContext extends Fdeclparams_contContext {
		public Fdeclparams_end_ruleContext(Fdeclparams_contContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterFdeclparams_end_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitFdeclparams_end_rule(this);
		}
	}
	public static class Fdeclparams_cont_ruleContext extends Fdeclparams_contContext {
		public FdeclparamContext fdeclparam;
		public FdeclparamContext fdeclparam() {
			return getRuleContext(FdeclparamContext.class,0);
		}
		public Fdeclparams_contContext fdeclparams_cont() {
			return getRuleContext(Fdeclparams_contContext.class,0);
		}
		public Fdeclparams_cont_ruleContext(Fdeclparams_contContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterFdeclparams_cont_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitFdeclparams_cont_rule(this);
		}
	}

	public final Fdeclparams_contContext fdeclparams_cont(List<String> plist) throws RecognitionException {
		Fdeclparams_contContext _localctx = new Fdeclparams_contContext(_ctx, getState(), plist);
		enterRule(_localctx, 10, RULE_fdeclparams_cont);
		try {
			setState(90);
			switch (_input.LA(1)) {
			case T__3:
				_localctx = new Fdeclparams_cont_ruleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				match(T__3);
				setState(85);
				((Fdeclparams_cont_ruleContext)_localctx).fdeclparam = fdeclparam();

				            _localctx.plist.add(((Fdeclparams_cont_ruleContext)_localctx).fdeclparam.pname);
				        
				setState(87);
				fdeclparams_cont(_localctx.plist);
				}
				break;
			case T__2:
				_localctx = new Fdeclparams_end_ruleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
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

	public static class FdeclparamContext extends ParserRuleContext {
		public String pname;
		public String ptype;
		public FdeclparamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fdeclparam; }
	 
		public FdeclparamContext() { }
		public void copyFrom(FdeclparamContext ctx) {
			super.copyFrom(ctx);
			this.pname = ctx.pname;
			this.ptype = ctx.ptype;
		}
	}
	public static class Fdecl_param_ruleContext extends FdeclparamContext {
		public SymbolContext symbol;
		public TypeContext type;
		public SymbolContext symbol() {
			return getRuleContext(SymbolContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Fdecl_param_ruleContext(FdeclparamContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterFdecl_param_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitFdecl_param_rule(this);
		}
	}

	public final FdeclparamContext fdeclparam() throws RecognitionException {
		FdeclparamContext _localctx = new FdeclparamContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_fdeclparam);
		try {
			_localctx = new Fdecl_param_ruleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			((Fdecl_param_ruleContext)_localctx).symbol = symbol();
			setState(93);
			match(T__4);
			setState(94);
			((Fdecl_param_ruleContext)_localctx).type = type();

			            ((Fdecl_param_ruleContext)_localctx).pname =  (((Fdecl_param_ruleContext)_localctx).symbol!=null?_input.getText(((Fdecl_param_ruleContext)_localctx).symbol.start,((Fdecl_param_ruleContext)_localctx).symbol.stop):null);
			            ((Fdecl_param_ruleContext)_localctx).ptype =  (((Fdecl_param_ruleContext)_localctx).type!=null?_input.getText(((Fdecl_param_ruleContext)_localctx).type.start,((Fdecl_param_ruleContext)_localctx).type.stop):null);
			        
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

	public static class FunctionnameContext extends ParserRuleContext {
		public FunctionnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionname; }
	 
		public FunctionnameContext() { }
		public void copyFrom(FunctionnameContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Fdecl_funcname_ruleContext extends FunctionnameContext {
		public TerminalNode TOK_ID() { return getToken(MMMLParser.TOK_ID, 0); }
		public Fdecl_funcname_ruleContext(FunctionnameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterFdecl_funcname_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitFdecl_funcname_rule(this);
		}
	}

	public final FunctionnameContext functionname() throws RecognitionException {
		FunctionnameContext _localctx = new FunctionnameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_functionname);
		try {
			_localctx = new Fdecl_funcname_ruleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(TOK_ID);
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

	public static class TypeContext extends ParserRuleContext {
		public String tipovar;
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
			this.tipovar = ctx.tipovar;
		}
	}
	public static class Basictype_ruleContext extends TypeContext {
		public Basic_typeContext tipo_regra;
		public Basic_typeContext basic_type() {
			return getRuleContext(Basic_typeContext.class,0);
		}
		public Basictype_ruleContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterBasictype_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitBasictype_rule(this);
		}
	}
	public static class Sequencetype_ruleContext extends TypeContext {
		public Sequence_typeContext sequence_type;
		public Sequence_typeContext sequence_type() {
			return getRuleContext(Sequence_typeContext.class,0);
		}
		public Sequencetype_ruleContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterSequencetype_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitSequencetype_rule(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_type);
		try {
			setState(105);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new Basictype_ruleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				((Basictype_ruleContext)_localctx).tipo_regra = basic_type();
				((Basictype_ruleContext)_localctx).tipovar =  ((Basictype_ruleContext)_localctx).tipo_regra.tipovar;
				}
				break;
			case 2:
				_localctx = new Sequencetype_ruleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				((Sequencetype_ruleContext)_localctx).sequence_type = sequence_type(0);

				            System.out.println("Variavel do tipo " + ((Sequencetype_ruleContext)_localctx).sequence_type.base + " dimensao "+ ((Sequencetype_ruleContext)_localctx).sequence_type.dimension);
				        
				}
				break;
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

	public static class Basic_typeContext extends ParserRuleContext {
		public String tipovar;
		public Basic_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basic_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterBasic_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitBasic_type(this);
		}
	}

	public final Basic_typeContext basic_type() throws RecognitionException {
		Basic_typeContext _localctx = new Basic_typeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_basic_type);
		try {
			setState(117);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				match(T__5);
				((Basic_typeContext)_localctx).tipovar =  "int";
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				match(T__6);
				((Basic_typeContext)_localctx).tipovar =  "boolean";
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(111);
				match(T__7);
				((Basic_typeContext)_localctx).tipovar =  "string";
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 4);
				{
				setState(113);
				match(T__8);
				((Basic_typeContext)_localctx).tipovar =  "float";
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 5);
				{
				setState(115);
				match(T__9);
				((Basic_typeContext)_localctx).tipovar =  "char";
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

	public static class Sequence_typeContext extends ParserRuleContext {
		public int dimension = 0;
		public String base;
		public Sequence_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequence_type; }
	 
		public Sequence_typeContext() { }
		public void copyFrom(Sequence_typeContext ctx) {
			super.copyFrom(ctx);
			this.dimension = ctx.dimension;
			this.base = ctx.base;
		}
	}
	public static class Sequencetype_sequence_ruleContext extends Sequence_typeContext {
		public Sequence_typeContext s;
		public Sequence_typeContext sequence_type() {
			return getRuleContext(Sequence_typeContext.class,0);
		}
		public Sequencetype_sequence_ruleContext(Sequence_typeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterSequencetype_sequence_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitSequencetype_sequence_rule(this);
		}
	}
	public static class Sequencetype_basetype_ruleContext extends Sequence_typeContext {
		public Basic_typeContext basic_type;
		public Basic_typeContext basic_type() {
			return getRuleContext(Basic_typeContext.class,0);
		}
		public Sequencetype_basetype_ruleContext(Sequence_typeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterSequencetype_basetype_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitSequencetype_basetype_rule(this);
		}
	}

	public final Sequence_typeContext sequence_type() throws RecognitionException {
		return sequence_type(0);
	}

	private Sequence_typeContext sequence_type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Sequence_typeContext _localctx = new Sequence_typeContext(_ctx, _parentState);
		Sequence_typeContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_sequence_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new Sequencetype_basetype_ruleContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(120);
			((Sequencetype_basetype_ruleContext)_localctx).basic_type = basic_type();
			setState(121);
			match(T__10);

			            ((Sequencetype_basetype_ruleContext)_localctx).dimension =  1;
			            ((Sequencetype_basetype_ruleContext)_localctx).base =  (((Sequencetype_basetype_ruleContext)_localctx).basic_type!=null?_input.getText(((Sequencetype_basetype_ruleContext)_localctx).basic_type.start,((Sequencetype_basetype_ruleContext)_localctx).basic_type.stop):null);
			        
			}
			_ctx.stop = _input.LT(-1);
			setState(129);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Sequencetype_sequence_ruleContext(new Sequence_typeContext(_parentctx, _parentState));
					((Sequencetype_sequence_ruleContext)_localctx).s = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_sequence_type);
					setState(124);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(125);
					match(T__10);

					                      ((Sequencetype_sequence_ruleContext)_localctx).dimension =  ((Sequencetype_sequence_ruleContext)_localctx).s.dimension + 1;
					                      ((Sequencetype_sequence_ruleContext)_localctx).base =  ((Sequencetype_sequence_ruleContext)_localctx).s.base;
					                  
					}
					} 
				}
				setState(131);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FuncbodyContext extends ParserRuleContext {
		public String fb;
		public Object ofb;
		public FuncbodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcbody; }
	 
		public FuncbodyContext() { }
		public void copyFrom(FuncbodyContext ctx) {
			super.copyFrom(ctx);
			this.fb = ctx.fb;
			this.ofb = ctx.ofb;
		}
	}
	public static class Fbody_let_ruleContext extends FuncbodyContext {
		public LetexprContext letexpr;
		public LetexprContext letexpr() {
			return getRuleContext(LetexprContext.class,0);
		}
		public Fbody_let_ruleContext(FuncbodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterFbody_let_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitFbody_let_rule(this);
		}
	}
	public static class Fbody_if_ruleContext extends FuncbodyContext {
		public IfexprContext ifexpr() {
			return getRuleContext(IfexprContext.class,0);
		}
		public Fbody_if_ruleContext(FuncbodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterFbody_if_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitFbody_if_rule(this);
		}
	}
	public static class Fbody_expr_ruleContext extends FuncbodyContext {
		public MetaexprContext m;
		public MetaexprContext metaexpr;
		public MetaexprContext metaexpr() {
			return getRuleContext(MetaexprContext.class,0);
		}
		public Fbody_expr_ruleContext(FuncbodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterFbody_expr_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitFbody_expr_rule(this);
		}
	}

	public final FuncbodyContext funcbody() throws RecognitionException {
		FuncbodyContext _localctx = new FuncbodyContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_funcbody);
		try {
			setState(139);
			switch (_input.LA(1)) {
			case T__11:
				_localctx = new Fbody_if_ruleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(132);
				ifexpr();
				}
				break;
			case T__14:
				_localctx = new Fbody_let_ruleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(133);
				((Fbody_let_ruleContext)_localctx).letexpr = letexpr();

				    		((Fbody_let_ruleContext)_localctx).fb =  ((Fbody_let_ruleContext)_localctx).letexpr.retorno;
				    		((Fbody_let_ruleContext)_localctx).ofb =  ((Fbody_let_ruleContext)_localctx).letexpr.ole;
				    	
				}
				break;
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__17:
			case T__19:
			case T__21:
			case T__22:
			case TOK_ID:
			case TOK_NEG:
			case TOK_STR_LIT:
			case TOK_CHAR_LIT:
			case FLOAT:
			case DECIMAL:
			case HEXADECIMAL:
			case BINARY:
				_localctx = new Fbody_expr_ruleContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(136);
				((Fbody_expr_ruleContext)_localctx).m = ((Fbody_expr_ruleContext)_localctx).metaexpr = metaexpr(0);

				    		((Fbody_expr_ruleContext)_localctx).ofb =  ((Fbody_expr_ruleContext)_localctx).metaexpr.ome;
							((Fbody_expr_ruleContext)_localctx).fb =  ((Fbody_expr_ruleContext)_localctx).m.tipovar; //imprimirTabela();
					
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

	public static class IfexprContext extends ParserRuleContext {
		public IfexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifexpr; }
	 
		public IfexprContext() { }
		public void copyFrom(IfexprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Ifexpression_ruleContext extends IfexprContext {
		public List<FuncbodyContext> funcbody() {
			return getRuleContexts(FuncbodyContext.class);
		}
		public FuncbodyContext funcbody(int i) {
			return getRuleContext(FuncbodyContext.class,i);
		}
		public Ifexpression_ruleContext(IfexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterIfexpression_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitIfexpression_rule(this);
		}
	}

	public final IfexprContext ifexpr() throws RecognitionException {
		IfexprContext _localctx = new IfexprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ifexpr);
		try {
			_localctx = new Ifexpression_ruleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(T__11);
			setState(142);
			funcbody();
			setState(143);
			match(T__12);
			setState(144);
			funcbody();
			setState(145);
			match(T__13);
			setState(146);
			funcbody();
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

	public static class LetexprContext extends ParserRuleContext {
		public NestedSymbolTable<String> tabela;
		public String retorno;
		public Object ole;
		public LetexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letexpr; }
	 
		public LetexprContext() { }
		public void copyFrom(LetexprContext ctx) {
			super.copyFrom(ctx);
			this.tabela = ctx.tabela;
			this.retorno = ctx.retorno;
			this.ole = ctx.ole;
		}
	}
	public static class Letexpression_ruleContext extends LetexprContext {
		public LetlistContext letlist;
		public FuncbodyContext funcbody;
		public LetlistContext letlist() {
			return getRuleContext(LetlistContext.class,0);
		}
		public FuncbodyContext funcbody() {
			return getRuleContext(FuncbodyContext.class,0);
		}
		public Letexpression_ruleContext(LetexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterLetexpression_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitLetexpression_rule(this);
		}
	}

	public final LetexprContext letexpr() throws RecognitionException {
		LetexprContext _localctx = new LetexprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_letexpr);
		try {
			_localctx = new Letexpression_ruleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(T__14);
			setState(149);
			((Letexpression_ruleContext)_localctx).letlist = letlist();
			setState(150);
			match(T__15);
			tabela = ((Letexpression_ruleContext)_localctx).letlist.tabela;
				simbolos = ((Letexpression_ruleContext)_localctx).letlist.olist;
				
			setState(152);
			((Letexpression_ruleContext)_localctx).funcbody = funcbody();
			tabela = tabela.getParent(); ((Letexpression_ruleContext)_localctx).retorno =  ((Letexpression_ruleContext)_localctx).funcbody.fb;
					simbolos = simbolos.getParent();
					((Letexpression_ruleContext)_localctx).retorno =  ((Letexpression_ruleContext)_localctx).funcbody.fb;
					((Letexpression_ruleContext)_localctx).ole =   ((Letexpression_ruleContext)_localctx).funcbody.ofb;
				
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

	public static class LetlistContext extends ParserRuleContext {
		public NestedSymbolTable<String> tabela;
		public NestedSymbolTable<Object> olist;
		public LetlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letlist; }
	 
		public LetlistContext() { }
		public void copyFrom(LetlistContext ctx) {
			super.copyFrom(ctx);
			this.tabela = ctx.tabela;
			this.olist = ctx.olist;
		}
	}
	public static class Letlist_ruleContext extends LetlistContext {
		public LetvarexprContext letvarexpr;
		public LetvarexprContext letvarexpr() {
			return getRuleContext(LetvarexprContext.class,0);
		}
		public Letlist_contContext letlist_cont() {
			return getRuleContext(Letlist_contContext.class,0);
		}
		public Letlist_ruleContext(LetlistContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterLetlist_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitLetlist_rule(this);
		}
	}

	public final LetlistContext letlist() throws RecognitionException {
		LetlistContext _localctx = new LetlistContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_letlist);

				((LetlistContext)_localctx).tabela =  new NestedSymbolTable<String>();
				((LetlistContext)_localctx).olist =  new  NestedSymbolTable<Object>(simbolos);
				simbolos = _localctx.olist;
			
		try {
			_localctx = new Letlist_ruleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			((Letlist_ruleContext)_localctx).letvarexpr = letvarexpr();
			_localctx.tabela.store(((Letlist_ruleContext)_localctx).letvarexpr.nome, ((Letlist_ruleContext)_localctx).letvarexpr.tipo);
					_localctx.olist.store(((Letlist_ruleContext)_localctx).letvarexpr.nome, ((Letlist_ruleContext)_localctx).letvarexpr.oletvar);
				
			setState(157);
			letlist_cont(_localctx.tabela, _localctx.olist);
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

	public static class Letlist_contContext extends ParserRuleContext {
		public NestedSymbolTable<String> tabela;
		public NestedSymbolTable<Object> ocont;
		public Letlist_contContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Letlist_contContext(ParserRuleContext parent, int invokingState, NestedSymbolTable<String> tabela, NestedSymbolTable<Object> ocont) {
			super(parent, invokingState);
			this.tabela = tabela;
			this.ocont = ocont;
		}
		@Override public int getRuleIndex() { return RULE_letlist_cont; }
	 
		public Letlist_contContext() { }
		public void copyFrom(Letlist_contContext ctx) {
			super.copyFrom(ctx);
			this.tabela = ctx.tabela;
			this.ocont = ctx.ocont;
		}
	}
	public static class Letlist_cont_endContext extends Letlist_contContext {
		public Letlist_cont_endContext(Letlist_contContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterLetlist_cont_end(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitLetlist_cont_end(this);
		}
	}
	public static class Letlist_cont_ruleContext extends Letlist_contContext {
		public LetvarexprContext letvarexpr;
		public LetvarexprContext letvarexpr() {
			return getRuleContext(LetvarexprContext.class,0);
		}
		public Letlist_contContext letlist_cont() {
			return getRuleContext(Letlist_contContext.class,0);
		}
		public Letlist_cont_ruleContext(Letlist_contContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterLetlist_cont_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitLetlist_cont_rule(this);
		}
	}

	public final Letlist_contContext letlist_cont(NestedSymbolTable<String> tabela,NestedSymbolTable<Object> ocont) throws RecognitionException {
		Letlist_contContext _localctx = new Letlist_contContext(_ctx, getState(), tabela, ocont);
		enterRule(_localctx, 30, RULE_letlist_cont);
		try {
			setState(165);
			switch (_input.LA(1)) {
			case T__3:
				_localctx = new Letlist_cont_ruleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				match(T__3);
				setState(160);
				((Letlist_cont_ruleContext)_localctx).letvarexpr = letvarexpr();
				_localctx.tabela.store(((Letlist_cont_ruleContext)_localctx).letvarexpr.nome, ((Letlist_cont_ruleContext)_localctx).letvarexpr.tipo);
						_localctx.ocont.store(((Letlist_cont_ruleContext)_localctx).letvarexpr.nome, ((Letlist_cont_ruleContext)_localctx).letvarexpr.oletvar);
					
				setState(162);
				letlist_cont(_localctx.tabela, _localctx.ocont);
				}
				break;
			case T__15:
				_localctx = new Letlist_cont_endContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
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

	public static class LetvarexprContext extends ParserRuleContext {
		public String nome;
		public String tipo;
		public Object oletvar;
		public LetvarexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letvarexpr; }
	 
		public LetvarexprContext() { }
		public void copyFrom(LetvarexprContext ctx) {
			super.copyFrom(ctx);
			this.nome = ctx.nome;
			this.tipo = ctx.tipo;
			this.oletvar = ctx.oletvar;
		}
	}
	public static class Letunpack_ruleContext extends LetvarexprContext {
		public SymbolContext sym1;
		public SymbolContext sym2;
		public FuncbodyContext fb;
		public List<SymbolContext> symbol() {
			return getRuleContexts(SymbolContext.class);
		}
		public SymbolContext symbol(int i) {
			return getRuleContext(SymbolContext.class,i);
		}
		public FuncbodyContext funcbody() {
			return getRuleContext(FuncbodyContext.class,0);
		}
		public Letunpack_ruleContext(LetvarexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterLetunpack_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitLetunpack_rule(this);
		}
	}
	public static class Letvarresult_ignore_ruleContext extends LetvarexprContext {
		public FuncbodyContext fb;
		public FuncbodyContext funcbody() {
			return getRuleContext(FuncbodyContext.class,0);
		}
		public Letvarresult_ignore_ruleContext(LetvarexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterLetvarresult_ignore_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitLetvarresult_ignore_rule(this);
		}
	}
	public static class Letvarattr_ruleContext extends LetvarexprContext {
		public SymbolContext sym;
		public FuncbodyContext fb;
		public SymbolContext symbol() {
			return getRuleContext(SymbolContext.class,0);
		}
		public FuncbodyContext funcbody() {
			return getRuleContext(FuncbodyContext.class,0);
		}
		public Letvarattr_ruleContext(LetvarexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterLetvarattr_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitLetvarattr_rule(this);
		}
	}

	public final LetvarexprContext letvarexpr() throws RecognitionException {
		LetvarexprContext _localctx = new LetvarexprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_letvarexpr);
		try {
			setState(186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new Letvarattr_ruleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				((Letvarattr_ruleContext)_localctx).sym = symbol();
				((Letvarattr_ruleContext)_localctx).nome =  (((Letvarattr_ruleContext)_localctx).sym!=null?_input.getText(((Letvarattr_ruleContext)_localctx).sym.start,((Letvarattr_ruleContext)_localctx).sym.stop):null);
					
				setState(169);
				match(T__2);
				setState(170);
				((Letvarattr_ruleContext)_localctx).fb = funcbody();
				//$tipo = $fb.fb;
						((Letvarattr_ruleContext)_localctx).oletvar =  ((Letvarattr_ruleContext)_localctx).fb.ofb;
					
				}
				break;
			case 2:
				_localctx = new Letvarresult_ignore_ruleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				match(T__16);
				setState(174);
				match(T__2);
				setState(175);
				((Letvarresult_ignore_ruleContext)_localctx).fb = funcbody();
				((Letvarresult_ignore_ruleContext)_localctx).nome =  "_"; ((Letvarresult_ignore_ruleContext)_localctx).tipo =  ((Letvarresult_ignore_ruleContext)_localctx).fb.fb; 
						((Letvarresult_ignore_ruleContext)_localctx).oletvar =  ((Letvarresult_ignore_ruleContext)_localctx).fb.ofb;
					
				}
				break;
			case 3:
				_localctx = new Letunpack_ruleContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(178);
				((Letunpack_ruleContext)_localctx).sym1 = symbol();
				setState(179);
				match(TOK_CONCAT);
				setState(180);
				((Letunpack_ruleContext)_localctx).sym2 = symbol();
				((Letunpack_ruleContext)_localctx).nome =  (((Letunpack_ruleContext)_localctx).sym1!=null?_input.getText(((Letunpack_ruleContext)_localctx).sym1.start,((Letunpack_ruleContext)_localctx).sym1.stop):null) + (((Letunpack_ruleContext)_localctx).sym2!=null?_input.getText(((Letunpack_ruleContext)_localctx).sym2.start,((Letunpack_ruleContext)_localctx).sym2.stop):null);
						((Letunpack_ruleContext)_localctx).oletvar =  (((Letunpack_ruleContext)_localctx).sym1!=null?_input.getText(((Letunpack_ruleContext)_localctx).sym1.start,((Letunpack_ruleContext)_localctx).sym1.stop):null) + (((Letunpack_ruleContext)_localctx).sym2!=null?_input.getText(((Letunpack_ruleContext)_localctx).sym2.start,((Letunpack_ruleContext)_localctx).sym2.stop):null);
					
				setState(182);
				match(T__2);
				setState(183);
				((Letunpack_ruleContext)_localctx).fb = funcbody();
				((Letunpack_ruleContext)_localctx).tipo =  ((Letunpack_ruleContext)_localctx).fb.fb;
						((Letunpack_ruleContext)_localctx).oletvar =  ((Letunpack_ruleContext)_localctx).fb.ofb;
					
				}
				break;
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

	public static class MetaexprContext extends ParserRuleContext {
		public String tipovar;
		public Object ome;
		public MetaexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metaexpr; }
	 
		public MetaexprContext() { }
		public void copyFrom(MetaexprContext ctx) {
			super.copyFrom(ctx);
			this.tipovar = ctx.tipovar;
			this.ome = ctx.ome;
		}
	}
	public static class Me_exprplusminus_ruleContext extends MetaexprContext {
		public MetaexprContext a;
		public Token op;
		public MetaexprContext b;
		public List<MetaexprContext> metaexpr() {
			return getRuleContexts(MetaexprContext.class);
		}
		public MetaexprContext metaexpr(int i) {
			return getRuleContext(MetaexprContext.class,i);
		}
		public TerminalNode TOK_PLUS_OR_MINUS() { return getToken(MMMLParser.TOK_PLUS_OR_MINUS, 0); }
		public Me_exprplusminus_ruleContext(MetaexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterMe_exprplusminus_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitMe_exprplusminus_rule(this);
		}
	}
	public static class Me_boolneg_ruleContext extends MetaexprContext {
		public SymbolContext sym;
		public TerminalNode TOK_NEG() { return getToken(MMMLParser.TOK_NEG, 0); }
		public SymbolContext symbol() {
			return getRuleContext(SymbolContext.class,0);
		}
		public Me_boolneg_ruleContext(MetaexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterMe_boolneg_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitMe_boolneg_rule(this);
		}
	}
	public static class Me_exprliteral_ruleContext extends MetaexprContext {
		public LiteralContext lit;
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public Me_exprliteral_ruleContext(MetaexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterMe_exprliteral_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitMe_exprliteral_rule(this);
		}
	}
	public static class Me_listconcat_ruleContext extends MetaexprContext {
		public MetaexprContext a;
		public MetaexprContext b;
		public TerminalNode TOK_CONCAT() { return getToken(MMMLParser.TOK_CONCAT, 0); }
		public List<MetaexprContext> metaexpr() {
			return getRuleContexts(MetaexprContext.class);
		}
		public MetaexprContext metaexpr(int i) {
			return getRuleContext(MetaexprContext.class,i);
		}
		public Me_listconcat_ruleContext(MetaexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterMe_listconcat_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitMe_listconcat_rule(this);
		}
	}
	public static class Me_list_create_ruleContext extends MetaexprContext {
		public Sequence_exprContext sequence_expr() {
			return getRuleContext(Sequence_exprContext.class,0);
		}
		public Me_list_create_ruleContext(MetaexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterMe_list_create_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitMe_list_create_rule(this);
		}
	}
	public static class Me_exprmuldiv_ruleContext extends MetaexprContext {
		public MetaexprContext a;
		public Token op;
		public MetaexprContext b;
		public List<MetaexprContext> metaexpr() {
			return getRuleContexts(MetaexprContext.class);
		}
		public MetaexprContext metaexpr(int i) {
			return getRuleContext(MetaexprContext.class,i);
		}
		public TerminalNode TOK_DIV_OR_MUL() { return getToken(MMMLParser.TOK_DIV_OR_MUL, 0); }
		public Me_exprmuldiv_ruleContext(MetaexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterMe_exprmuldiv_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitMe_exprmuldiv_rule(this);
		}
	}
	public static class Me_exprcast_ruleContext extends MetaexprContext {
		public CastContext c;
		public CastContext cast() {
			return getRuleContext(CastContext.class,0);
		}
		public Me_exprcast_ruleContext(MetaexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterMe_exprcast_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitMe_exprcast_rule(this);
		}
	}
	public static class Me_exprparens_ruleContext extends MetaexprContext {
		public FuncbodyContext fb;
		public FuncbodyContext funcbody() {
			return getRuleContext(FuncbodyContext.class,0);
		}
		public Me_exprparens_ruleContext(MetaexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterMe_exprparens_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitMe_exprparens_rule(this);
		}
	}
	public static class Me_boolandor_ruleContext extends MetaexprContext {
		public List<MetaexprContext> metaexpr() {
			return getRuleContexts(MetaexprContext.class);
		}
		public MetaexprContext metaexpr(int i) {
			return getRuleContext(MetaexprContext.class,i);
		}
		public TerminalNode TOK_BOOL_AND_OR() { return getToken(MMMLParser.TOK_BOOL_AND_OR, 0); }
		public Me_boolandor_ruleContext(MetaexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterMe_boolandor_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitMe_boolandor_rule(this);
		}
	}
	public static class Me_exprsymbol_ruleContext extends MetaexprContext {
		public SymbolContext sym;
		public SymbolContext symbol() {
			return getRuleContext(SymbolContext.class,0);
		}
		public Me_exprsymbol_ruleContext(MetaexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterMe_exprsymbol_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitMe_exprsymbol_rule(this);
		}
	}
	public static class Me_exprfuncall_ruleContext extends MetaexprContext {
		public FuncallContext funcall() {
			return getRuleContext(FuncallContext.class,0);
		}
		public Me_exprfuncall_ruleContext(MetaexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterMe_exprfuncall_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitMe_exprfuncall_rule(this);
		}
	}
	public static class Me_boolgtlt_ruleContext extends MetaexprContext {
		public MetaexprContext a;
		public MetaexprContext b;
		public TerminalNode TOK_CMP_GT_LT() { return getToken(MMMLParser.TOK_CMP_GT_LT, 0); }
		public List<MetaexprContext> metaexpr() {
			return getRuleContexts(MetaexprContext.class);
		}
		public MetaexprContext metaexpr(int i) {
			return getRuleContext(MetaexprContext.class,i);
		}
		public Me_boolgtlt_ruleContext(MetaexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterMe_boolgtlt_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitMe_boolgtlt_rule(this);
		}
	}
	public static class Me_boolnegparens_ruleContext extends MetaexprContext {
		public TerminalNode TOK_NEG() { return getToken(MMMLParser.TOK_NEG, 0); }
		public FuncbodyContext funcbody() {
			return getRuleContext(FuncbodyContext.class,0);
		}
		public Me_boolnegparens_ruleContext(MetaexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterMe_boolnegparens_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitMe_boolnegparens_rule(this);
		}
	}
	public static class Me_exprpower_ruleContext extends MetaexprContext {
		public MetaexprContext a;
		public MetaexprContext b;
		public TerminalNode TOK_POWER() { return getToken(MMMLParser.TOK_POWER, 0); }
		public List<MetaexprContext> metaexpr() {
			return getRuleContexts(MetaexprContext.class);
		}
		public MetaexprContext metaexpr(int i) {
			return getRuleContext(MetaexprContext.class,i);
		}
		public Me_exprpower_ruleContext(MetaexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterMe_exprpower_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitMe_exprpower_rule(this);
		}
	}
	public static class Me_booleqdiff_ruleContext extends MetaexprContext {
		public List<MetaexprContext> metaexpr() {
			return getRuleContexts(MetaexprContext.class);
		}
		public MetaexprContext metaexpr(int i) {
			return getRuleContext(MetaexprContext.class,i);
		}
		public TerminalNode TOK_CMP_EQ_DIFF() { return getToken(MMMLParser.TOK_CMP_EQ_DIFF, 0); }
		public Me_booleqdiff_ruleContext(MetaexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterMe_booleqdiff_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitMe_booleqdiff_rule(this);
		}
	}

	public final MetaexprContext metaexpr() throws RecognitionException {
		return metaexpr(0);
	}

	private MetaexprContext metaexpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MetaexprContext _localctx = new MetaexprContext(_ctx, _parentState);
		MetaexprContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_metaexpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				_localctx = new Me_exprparens_ruleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(189);
				match(T__17);
				setState(190);
				((Me_exprparens_ruleContext)_localctx).fb = funcbody();
				setState(191);
				match(T__18);

						((Me_exprparens_ruleContext)_localctx).tipovar =  ((Me_exprparens_ruleContext)_localctx).fb.fb;
						((Me_exprparens_ruleContext)_localctx).ome =  ((Me_exprparens_ruleContext)_localctx).fb.ofb;
					
				}
				break;
			case 2:
				{
				_localctx = new Me_list_create_ruleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(194);
				sequence_expr();
				}
				break;
			case 3:
				{
				_localctx = new Me_boolneg_ruleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(195);
				match(TOK_NEG);
				setState(196);
				((Me_boolneg_ruleContext)_localctx).sym = symbol();

				    	if( ((Me_boolneg_ruleContext)_localctx).sym.tiposym == "string")
				    	{
				    		((Me_boolneg_ruleContext)_localctx).tipovar =  "string";
				    	}
				    	else
				    	{
				    		((Me_boolneg_ruleContext)_localctx).tipovar =  "int";
				    	}
				    	
				}
				break;
			case 4:
				{
				_localctx = new Me_boolnegparens_ruleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(199);
				match(TOK_NEG);
				setState(200);
				match(T__17);
				setState(201);
				funcbody();
				setState(202);
				match(T__18);

				    		//((Me_boolnegparens_ruleContext)_localctx).tipovar =  "boolean";
				    
				}
				break;
			case 5:
				{
				_localctx = new Me_exprsymbol_ruleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(205);
				((Me_exprsymbol_ruleContext)_localctx).sym = symbol();

							if(tabela.lookup((((Me_exprsymbol_ruleContext)_localctx).sym!=null?_input.getText(((Me_exprsymbol_ruleContext)_localctx).sym.start,((Me_exprsymbol_ruleContext)_localctx).sym.stop):null)) != null) {
								
								SymbolEntry se = tabela.lookup((((Me_exprsymbol_ruleContext)_localctx).sym!=null?_input.getText(((Me_exprsymbol_ruleContext)_localctx).sym.start,((Me_exprsymbol_ruleContext)_localctx).sym.stop):null));
								((Me_exprsymbol_ruleContext)_localctx).tipovar =  (String) se.symbol;
				//   ((Me_exprsymbol_ruleContext)_localctx).tipovar =  tabela.lookup((((Me_exprsymbol_ruleContext)_localctx).sym!=null?_input.getText(((Me_exprsymbol_ruleContext)_localctx).sym.start,((Me_exprsymbol_ruleContext)_localctx).sym.stop):null)).symbol;
						}
						if(simbolos.lookup((((Me_exprsymbol_ruleContext)_localctx).sym!=null?_input.getText(((Me_exprsymbol_ruleContext)_localctx).sym.start,((Me_exprsymbol_ruleContext)_localctx).sym.stop):null)) != null) {
						SymbolEntry ss = simbolos.lookup((((Me_exprsymbol_ruleContext)_localctx).sym!=null?_input.getText(((Me_exprsymbol_ruleContext)_localctx).sym.start,((Me_exprsymbol_ruleContext)_localctx).sym.stop):null));
							   ((Me_exprsymbol_ruleContext)_localctx).ome =  ss.symbol;
							   pilha.push(String.valueOf(_localctx.ome).replaceAll("\"", ""));
							   }
					
				}
				break;
			case 6:
				{
				_localctx = new Me_exprliteral_ruleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(208);
				((Me_exprliteral_ruleContext)_localctx).lit = literal();
				((Me_exprliteral_ruleContext)_localctx).tipovar =  ((Me_exprliteral_ruleContext)_localctx).lit.tipoliteral;
						((Me_exprliteral_ruleContext)_localctx).ome =  ((Me_exprliteral_ruleContext)_localctx).lit.olite;
					
				}
				break;
			case 7:
				{
				_localctx = new Me_exprfuncall_ruleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(211);
				funcall();
				}
				break;
			case 8:
				{
				_localctx = new Me_exprcast_ruleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(212);
				((Me_exprcast_ruleContext)_localctx).c = cast();
					((Me_exprcast_ruleContext)_localctx).tipovar =  ((Me_exprcast_ruleContext)_localctx).c.tipo;
						((Me_exprcast_ruleContext)_localctx).ome =  ((Me_exprcast_ruleContext)_localctx).c.ocast;
						pilha.push(String.valueOf(_localctx.ome).replaceAll("\"",""));
					
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(254);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(252);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new Me_exprpower_ruleContext(new MetaexprContext(_parentctx, _parentState));
						((Me_exprpower_ruleContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_metaexpr);
						setState(217);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(218);
						match(TOK_POWER);
						setState(219);
						((Me_exprpower_ruleContext)_localctx).b = metaexpr(12);

						          		if (((Me_exprpower_ruleContext)_localctx).a.tipovar == "int" && ((Me_exprpower_ruleContext)_localctx).b.tipovar == "int") {
						          		   ((Me_exprpower_ruleContext)_localctx).tipovar =  "int";
						          		} else if (((Me_exprpower_ruleContext)_localctx).a.tipovar == "float" && ((Me_exprpower_ruleContext)_localctx).b.tipovar == "float") {
						          		   ((Me_exprpower_ruleContext)_localctx).tipovar =  "float";
						          		}
						          		else if ((((Me_exprpower_ruleContext)_localctx).a.tipovar == "int" && ((Me_exprpower_ruleContext)_localctx).b.tipovar == "float") || (((Me_exprpower_ruleContext)_localctx).a.tipovar == "float" && ((Me_exprpower_ruleContext)_localctx).b.tipovar == "int"))
						          		{
						          			((Me_exprpower_ruleContext)_localctx).tipovar =  "float";
						          		}
						          		else {
						          			System.out.println("Errooooou");
						          		} 
						              
						}
						break;
					case 2:
						{
						_localctx = new Me_listconcat_ruleContext(new MetaexprContext(_parentctx, _parentState));
						((Me_listconcat_ruleContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_metaexpr);
						setState(222);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(223);
						match(TOK_CONCAT);
						setState(224);
						((Me_listconcat_ruleContext)_localctx).b = metaexpr(11);

						          		if((((Me_listconcat_ruleContext)_localctx).a.tipovar == "string" || ((Me_listconcat_ruleContext)_localctx).b.tipovar == "string"))
						          		{
						          			((Me_listconcat_ruleContext)_localctx).tipovar =  "string";
						          			((Me_listconcat_ruleContext)_localctx).ome =  String.valueOf(((Me_listconcat_ruleContext)_localctx).a.ome).replaceAll("\"", "");
						          			((Me_listconcat_ruleContext)_localctx).ome =  _localctx.ome + String.valueOf(((Me_listconcat_ruleContext)_localctx).b.ome).replaceAll("\"", "");
						              		Object o1 = pilha.pop();
						              		Object o2 = pilha.pop();
						              		pilha.push(String.valueOf(_localctx.ome).replaceAll("\"", ""));
						              		
						          		}
						          		else {
						          			System.out.println("Errooooou");
						          		}      
						            
						}
						break;
					case 3:
						{
						_localctx = new Me_exprmuldiv_ruleContext(new MetaexprContext(_parentctx, _parentState));
						((Me_exprmuldiv_ruleContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_metaexpr);
						setState(227);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(228);
						((Me_exprmuldiv_ruleContext)_localctx).op = match(TOK_DIV_OR_MUL);
						setState(229);
						((Me_exprmuldiv_ruleContext)_localctx).b = metaexpr(10);

						          		if (((Me_exprmuldiv_ruleContext)_localctx).a.tipovar == "int" && ((Me_exprmuldiv_ruleContext)_localctx).b.tipovar == "int") {
						          		   ((Me_exprmuldiv_ruleContext)_localctx).tipovar =  "int";
						          		   if((((Me_exprmuldiv_ruleContext)_localctx).op!=null?((Me_exprmuldiv_ruleContext)_localctx).op.getText():null).equals("*")) {
						              			Object o1 = pilha.pop();
						              			Object o2 = pilha.pop();
						              			((Me_exprmuldiv_ruleContext)_localctx).ome =  Integer.parseInt(String.valueOf(((Me_exprmuldiv_ruleContext)_localctx).a.ome)) * Integer.parseInt(String.valueOf(((Me_exprmuldiv_ruleContext)_localctx).b.ome));
						              			pilha.push(String.valueOf(_localctx.ome).replaceAll("\"", ""));
						              		} else {
						              			Object o1 = pilha.pop();
						              			Object o2 = pilha.pop();
						              			((Me_exprmuldiv_ruleContext)_localctx).ome =  Integer.parseInt(String.valueOf(((Me_exprmuldiv_ruleContext)_localctx).a.ome)) / Integer.parseInt(String.valueOf(((Me_exprmuldiv_ruleContext)_localctx).b.ome));
						              			pilha.push(String.valueOf(_localctx.ome).replaceAll("\"", ""));
						              		}
						          		} else if (((Me_exprmuldiv_ruleContext)_localctx).a.tipovar == "float" && ((Me_exprmuldiv_ruleContext)_localctx).b.tipovar == "float") {
						          		   ((Me_exprmuldiv_ruleContext)_localctx).tipovar =  "float";
						          		   if((((Me_exprmuldiv_ruleContext)_localctx).op!=null?((Me_exprmuldiv_ruleContext)_localctx).op.getText():null).equals("*")) {
						              			Object o1 = pilha.pop();
						              			Object o2 = pilha.pop();
						              			((Me_exprmuldiv_ruleContext)_localctx).ome =  Integer.parseInt(String.valueOf(((Me_exprmuldiv_ruleContext)_localctx).a.ome)) * Integer.parseInt(String.valueOf(((Me_exprmuldiv_ruleContext)_localctx).b.ome));
						              			pilha.push(String.valueOf(_localctx.ome).replaceAll("\"", ""));
						              		} else {
						              			Object o1 = pilha.pop();
						              			Object o2 = pilha.pop();
						              			((Me_exprmuldiv_ruleContext)_localctx).ome =  Integer.parseInt(String.valueOf(((Me_exprmuldiv_ruleContext)_localctx).a.ome)) / Integer.parseInt(String.valueOf(((Me_exprmuldiv_ruleContext)_localctx).b.ome));
						              			pilha.push(String.valueOf(_localctx.ome).replaceAll("\"", ""));
						              		}
						          		}
						          		else if ((((Me_exprmuldiv_ruleContext)_localctx).a.tipovar == "int" && ((Me_exprmuldiv_ruleContext)_localctx).b.tipovar == "float") || (((Me_exprmuldiv_ruleContext)_localctx).a.tipovar == "float" && ((Me_exprmuldiv_ruleContext)_localctx).b.tipovar == "int"))
						          		{
						          			((Me_exprmuldiv_ruleContext)_localctx).tipovar =  "float";
						          			if((((Me_exprmuldiv_ruleContext)_localctx).op!=null?((Me_exprmuldiv_ruleContext)_localctx).op.getText():null).equals("*")) {
						              			Object o1 = pilha.pop();
						              			Object o2 = pilha.pop();
						              			((Me_exprmuldiv_ruleContext)_localctx).ome =  Integer.parseInt(String.valueOf(((Me_exprmuldiv_ruleContext)_localctx).a.ome)) * Integer.parseInt(String.valueOf(((Me_exprmuldiv_ruleContext)_localctx).b.ome));
						              			pilha.push(String.valueOf(_localctx.ome).replaceAll("\"", ""));
						              		} else {
						              			Object o1 = pilha.pop();
						              			Object o2 = pilha.pop();
						              			((Me_exprmuldiv_ruleContext)_localctx).ome =  Integer.parseInt(String.valueOf(((Me_exprmuldiv_ruleContext)_localctx).a.ome)) / Integer.parseInt(String.valueOf(((Me_exprmuldiv_ruleContext)_localctx).b.ome));
						              			pilha.push(String.valueOf(_localctx.ome).replaceAll("\"", ""));
						              		}
						          		}
						          		else {
						          			System.out.println("Errooooou");
						          		} 
						          	
						}
						break;
					case 4:
						{
						_localctx = new Me_exprplusminus_ruleContext(new MetaexprContext(_parentctx, _parentState));
						((Me_exprplusminus_ruleContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_metaexpr);
						setState(232);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(233);
						((Me_exprplusminus_ruleContext)_localctx).op = match(TOK_PLUS_OR_MINUS);
						setState(234);
						((Me_exprplusminus_ruleContext)_localctx).b = metaexpr(9);

						          		if (((Me_exprplusminus_ruleContext)_localctx).a.tipovar == "int" && ((Me_exprplusminus_ruleContext)_localctx).b.tipovar == "int") {
						          		   ((Me_exprplusminus_ruleContext)_localctx).tipovar =  "int";
						          		   if((((Me_exprplusminus_ruleContext)_localctx).op!=null?((Me_exprplusminus_ruleContext)_localctx).op.getText():null).equals("+")) {
						              			Object o1 = pilha.pop();
						              			Object o2 = pilha.pop();
						              			((Me_exprplusminus_ruleContext)_localctx).ome =  Integer.parseInt(String.valueOf(((Me_exprplusminus_ruleContext)_localctx).a.ome)) + Integer.parseInt(String.valueOf(((Me_exprplusminus_ruleContext)_localctx).b.ome));
						              			pilha.push(String.valueOf(_localctx.ome).replaceAll("\"", ""));
						              		} else {
						              			Object o1 = pilha.pop();
						              			Object o2 = pilha.pop();
						              			((Me_exprplusminus_ruleContext)_localctx).ome =  Integer.parseInt(String.valueOf(((Me_exprplusminus_ruleContext)_localctx).a.ome)) - Integer.parseInt(String.valueOf(((Me_exprplusminus_ruleContext)_localctx).b.ome));
						              			pilha.push(String.valueOf(_localctx.ome).replaceAll("\"", ""));
						              		}
						          		} else if (((Me_exprplusminus_ruleContext)_localctx).a.tipovar == "float" && ((Me_exprplusminus_ruleContext)_localctx).b.tipovar == "float") {
						          		   ((Me_exprplusminus_ruleContext)_localctx).tipovar =  "float";
						          		   if((((Me_exprplusminus_ruleContext)_localctx).op!=null?((Me_exprplusminus_ruleContext)_localctx).op.getText():null).equals("+")) {
						              			Object o1 = pilha.pop();
						              			Object o2 = pilha.pop();
						              			((Me_exprplusminus_ruleContext)_localctx).ome =  Integer.parseInt(String.valueOf(((Me_exprplusminus_ruleContext)_localctx).a.ome)) + Integer.parseInt(String.valueOf(((Me_exprplusminus_ruleContext)_localctx).b.ome));
						              			pilha.push(String.valueOf(_localctx.ome).replaceAll("\"", ""));
						              		} else {
						              			Object o1 = pilha.pop();
						              			Object o2 = pilha.pop();
						              			((Me_exprplusminus_ruleContext)_localctx).ome =  Integer.parseInt(String.valueOf(((Me_exprplusminus_ruleContext)_localctx).a.ome)) - Integer.parseInt(String.valueOf(((Me_exprplusminus_ruleContext)_localctx).b.ome));
						              			pilha.push(String.valueOf(_localctx.ome).replaceAll("\"", ""));
						              		}
						          		}
						          		else if ((((Me_exprplusminus_ruleContext)_localctx).a.tipovar == "int" && ((Me_exprplusminus_ruleContext)_localctx).b.tipovar == "float") || (((Me_exprplusminus_ruleContext)_localctx).a.tipovar == "float" && ((Me_exprplusminus_ruleContext)_localctx).b.tipovar == "int"))
						          		{
						          			((Me_exprplusminus_ruleContext)_localctx).tipovar =  "float";
						          			if((((Me_exprplusminus_ruleContext)_localctx).op!=null?((Me_exprplusminus_ruleContext)_localctx).op.getText():null).equals("+")) {
						              			Object o1 = pilha.pop();
						              			Object o2 = pilha.pop();
						              			((Me_exprplusminus_ruleContext)_localctx).ome =  Integer.parseInt(String.valueOf(((Me_exprplusminus_ruleContext)_localctx).a.ome)) + Integer.parseInt(String.valueOf(((Me_exprplusminus_ruleContext)_localctx).b.ome));
						              			pilha.push(String.valueOf(_localctx.ome).replaceAll("\"", ""));
						              		} else {
						              			Object o1 = pilha.pop();
						              			Object o2 = pilha.pop();
						              			((Me_exprplusminus_ruleContext)_localctx).ome =  Integer.parseInt(String.valueOf(((Me_exprplusminus_ruleContext)_localctx).a.ome)) - Integer.parseInt(String.valueOf(((Me_exprplusminus_ruleContext)_localctx).b.ome));
						              			pilha.push(String.valueOf(_localctx.ome).replaceAll("\"", ""));
						              		}
						          		}
						          		else {
						          			System.out.println("Errooooou");
						          		} 
						          	
						}
						break;
					case 5:
						{
						_localctx = new Me_boolgtlt_ruleContext(new MetaexprContext(_parentctx, _parentState));
						((Me_boolgtlt_ruleContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_metaexpr);
						setState(237);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(238);
						match(TOK_CMP_GT_LT);
						setState(239);
						((Me_boolgtlt_ruleContext)_localctx).b = metaexpr(8);

						          			((Me_boolgtlt_ruleContext)_localctx).tipovar =  "boolean";
						              
						}
						break;
					case 6:
						{
						_localctx = new Me_booleqdiff_ruleContext(new MetaexprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_metaexpr);
						setState(242);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(243);
						match(TOK_CMP_EQ_DIFF);
						setState(244);
						metaexpr(7);
						 ((Me_booleqdiff_ruleContext)_localctx).tipovar =  "boolean"; 
						}
						break;
					case 7:
						{
						_localctx = new Me_boolandor_ruleContext(new MetaexprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_metaexpr);
						setState(247);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(248);
						match(TOK_BOOL_AND_OR);
						setState(249);
						metaexpr(6);
						 ((Me_boolandor_ruleContext)_localctx).tipovar =  "boolean"; 
						}
						break;
					}
					} 
				}
				setState(256);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Sequence_exprContext extends ParserRuleContext {
		public Sequence_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequence_expr; }
	 
		public Sequence_exprContext() { }
		public void copyFrom(Sequence_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Se_create_seqContext extends Sequence_exprContext {
		public FuncbodyContext funcbody() {
			return getRuleContext(FuncbodyContext.class,0);
		}
		public Se_create_seqContext(Sequence_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterSe_create_seq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitSe_create_seq(this);
		}
	}

	public final Sequence_exprContext sequence_expr() throws RecognitionException {
		Sequence_exprContext _localctx = new Sequence_exprContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_sequence_expr);
		try {
			_localctx = new Se_create_seqContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			match(T__19);
			setState(258);
			funcbody();
			setState(259);
			match(T__20);
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

	public static class FuncallContext extends ParserRuleContext {
		public FuncallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcall; }
	 
		public FuncallContext() { }
		public void copyFrom(FuncallContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Funcall_rule1Context extends FuncallContext {
		public SymbolContext symbol() {
			return getRuleContext(SymbolContext.class,0);
		}
		public MetaexprContext metaexpr() {
			return getRuleContext(MetaexprContext.class,0);
		}
		public Funcall_rule1Context(FuncallContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterFuncall_rule1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitFuncall_rule1(this);
		}
	}
	public static class Funcall_ruleContext extends FuncallContext {
		public SymbolContext symbol() {
			return getRuleContext(SymbolContext.class,0);
		}
		public Funcall_paramsContext funcall_params() {
			return getRuleContext(Funcall_paramsContext.class,0);
		}
		public Funcall_ruleContext(FuncallContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterFuncall_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitFuncall_rule(this);
		}
	}

	public final FuncallContext funcall() throws RecognitionException {
		FuncallContext _localctx = new FuncallContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_funcall);
		try {
			setState(267);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new Funcall_ruleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(261);
				symbol();
				setState(262);
				funcall_params();
				}
				break;
			case 2:
				_localctx = new Funcall_rule1Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(264);
				symbol();
				setState(265);
				metaexpr(0);
				}
				break;
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

	public static class CastContext extends ParserRuleContext {
		public String tipo;
		public Object ocast;
		public CastContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cast; }
	 
		public CastContext() { }
		public void copyFrom(CastContext ctx) {
			super.copyFrom(ctx);
			this.tipo = ctx.tipo;
			this.ocast = ctx.ocast;
		}
	}
	public static class Cast_ruleContext extends CastContext {
		public TypeContext t;
		public FuncbodyContext funcbody;
		public FuncbodyContext funcbody() {
			return getRuleContext(FuncbodyContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Cast_ruleContext(CastContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterCast_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitCast_rule(this);
		}
	}

	public final CastContext cast() throws RecognitionException {
		CastContext _localctx = new CastContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_cast);
		try {
			_localctx = new Cast_ruleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			((Cast_ruleContext)_localctx).t = type();
			setState(270);
			((Cast_ruleContext)_localctx).funcbody = funcbody();
			((Cast_ruleContext)_localctx).tipo =  ((Cast_ruleContext)_localctx).t.tipovar;
				((Cast_ruleContext)_localctx).ocast =  ((Cast_ruleContext)_localctx).funcbody.ofb;
				
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

	public static class Funcall_paramsContext extends ParserRuleContext {
		public Funcall_paramsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcall_params; }
	 
		public Funcall_paramsContext() { }
		public void copyFrom(Funcall_paramsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Funcallparams_ruleContext extends Funcall_paramsContext {
		public MetaexprContext metaexpr() {
			return getRuleContext(MetaexprContext.class,0);
		}
		public Funcall_params_contContext funcall_params_cont() {
			return getRuleContext(Funcall_params_contContext.class,0);
		}
		public Funcallparams_ruleContext(Funcall_paramsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterFuncallparams_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitFuncallparams_rule(this);
		}
	}
	public static class Funcallnoparam_ruleContext extends Funcall_paramsContext {
		public Funcallnoparam_ruleContext(Funcall_paramsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterFuncallnoparam_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitFuncallnoparam_rule(this);
		}
	}

	public final Funcall_paramsContext funcall_params() throws RecognitionException {
		Funcall_paramsContext _localctx = new Funcall_paramsContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_funcall_params);
		try {
			setState(277);
			switch (_input.LA(1)) {
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__17:
			case T__19:
			case T__21:
			case T__22:
			case TOK_ID:
			case TOK_NEG:
			case TOK_STR_LIT:
			case TOK_CHAR_LIT:
			case FLOAT:
			case DECIMAL:
			case HEXADECIMAL:
			case BINARY:
				_localctx = new Funcallparams_ruleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(273);
				metaexpr(0);
				setState(274);
				funcall_params_cont();
				}
				break;
			case T__16:
				_localctx = new Funcallnoparam_ruleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(276);
				match(T__16);
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

	public static class Funcall_params_contContext extends ParserRuleContext {
		public Funcall_params_contContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcall_params_cont; }
	 
		public Funcall_params_contContext() { }
		public void copyFrom(Funcall_params_contContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Funcall_params_cont_ruleContext extends Funcall_params_contContext {
		public MetaexprContext metaexpr() {
			return getRuleContext(MetaexprContext.class,0);
		}
		public Funcall_params_contContext funcall_params_cont() {
			return getRuleContext(Funcall_params_contContext.class,0);
		}
		public Funcall_params_cont_ruleContext(Funcall_params_contContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterFuncall_params_cont_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitFuncall_params_cont_rule(this);
		}
	}
	public static class Funcall_params_end_ruleContext extends Funcall_params_contContext {
		public Funcall_params_end_ruleContext(Funcall_params_contContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterFuncall_params_end_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitFuncall_params_end_rule(this);
		}
	}

	public final Funcall_params_contContext funcall_params_cont() throws RecognitionException {
		Funcall_params_contContext _localctx = new Funcall_params_contContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_funcall_params_cont);
		try {
			setState(283);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new Funcall_params_cont_ruleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(279);
				metaexpr(0);
				setState(280);
				funcall_params_cont();
				}
				break;
			case 2:
				_localctx = new Funcall_params_end_ruleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
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

	public static class LiteralContext extends ParserRuleContext {
		public String tipoliteral;
		public Object olite;
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	 
		public LiteralContext() { }
		public void copyFrom(LiteralContext ctx) {
			super.copyFrom(ctx);
			this.tipoliteral = ctx.tipoliteral;
			this.olite = ctx.olite;
		}
	}
	public static class Literal_char_ruleContext extends LiteralContext {
		public CharlitContext charlit() {
			return getRuleContext(CharlitContext.class,0);
		}
		public Literal_char_ruleContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterLiteral_char_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitLiteral_char_rule(this);
		}
	}
	public static class Literalnumber_ruleContext extends LiteralContext {
		public NumberContext num;
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public Literalnumber_ruleContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterLiteralnumber_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitLiteralnumber_rule(this);
		}
	}
	public static class Literalnil_ruleContext extends LiteralContext {
		public Literalnil_ruleContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterLiteralnil_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitLiteralnil_rule(this);
		}
	}
	public static class Literaltrue_ruleContext extends LiteralContext {
		public Literaltrue_ruleContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterLiteraltrue_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitLiteraltrue_rule(this);
		}
	}
	public static class Literalstring_ruleContext extends LiteralContext {
		public StrlitContext strlit;
		public StrlitContext strlit() {
			return getRuleContext(StrlitContext.class,0);
		}
		public Literalstring_ruleContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterLiteralstring_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitLiteralstring_rule(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_literal);
		try {
			setState(297);
			switch (_input.LA(1)) {
			case T__21:
				_localctx = new Literalnil_ruleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(285);
				match(T__21);
				}
				break;
			case T__22:
				_localctx = new Literaltrue_ruleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(286);
				match(T__22);

						((Literaltrue_ruleContext)_localctx).tipoliteral =  "boolean";
					
				}
				break;
			case FLOAT:
			case DECIMAL:
			case HEXADECIMAL:
			case BINARY:
				_localctx = new Literalnumber_ruleContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(288);
				((Literalnumber_ruleContext)_localctx).num = number();

						((Literalnumber_ruleContext)_localctx).tipoliteral =  ((Literalnumber_ruleContext)_localctx).num.tiponum;
						((Literalnumber_ruleContext)_localctx).olite =  ((Literalnumber_ruleContext)_localctx).num.onum;
					
				}
				break;
			case TOK_STR_LIT:
				_localctx = new Literalstring_ruleContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(291);
				((Literalstring_ruleContext)_localctx).strlit = strlit();

						((Literalstring_ruleContext)_localctx).tipoliteral =  "string"; 
						((Literalstring_ruleContext)_localctx).olite =  ((Literalstring_ruleContext)_localctx).strlit.ostr;
					
				}
				break;
			case TOK_CHAR_LIT:
				_localctx = new Literal_char_ruleContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(294);
				charlit();

						((Literal_char_ruleContext)_localctx).tipoliteral =  "char";
					
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

	public static class StrlitContext extends ParserRuleContext {
		public String s;
		public Object ostr;
		public Token st;
		public TerminalNode TOK_STR_LIT() { return getToken(MMMLParser.TOK_STR_LIT, 0); }
		public StrlitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strlit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterStrlit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitStrlit(this);
		}
	}

	public final StrlitContext strlit() throws RecognitionException {
		StrlitContext _localctx = new StrlitContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_strlit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			((StrlitContext)_localctx).st = match(TOK_STR_LIT);

			//		((StrlitContext)_localctx).s =  "string";
					((StrlitContext)_localctx).ostr =  (((StrlitContext)_localctx).st!=null?((StrlitContext)_localctx).st.getText():null);
				
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

	public static class CharlitContext extends ParserRuleContext {
		public String cha;
		public Object ocha;
		public Token ch;
		public TerminalNode TOK_CHAR_LIT() { return getToken(MMMLParser.TOK_CHAR_LIT, 0); }
		public CharlitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_charlit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterCharlit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitCharlit(this);
		}
	}

	public final CharlitContext charlit() throws RecognitionException {
		CharlitContext _localctx = new CharlitContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_charlit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			((CharlitContext)_localctx).ch = match(TOK_CHAR_LIT);

					((CharlitContext)_localctx).cha =  "char";
					((CharlitContext)_localctx).ocha =  (((CharlitContext)_localctx).ch!=null?((CharlitContext)_localctx).ch.getText():null);
				
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

	public static class NumberContext extends ParserRuleContext {
		public String tiponum;
		public Object onum;
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
	 
		public NumberContext() { }
		public void copyFrom(NumberContext ctx) {
			super.copyFrom(ctx);
			this.tiponum = ctx.tiponum;
			this.onum = ctx.onum;
		}
	}
	public static class Numberfloat_ruleContext extends NumberContext {
		public Token fl;
		public TerminalNode FLOAT() { return getToken(MMMLParser.FLOAT, 0); }
		public Numberfloat_ruleContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterNumberfloat_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitNumberfloat_rule(this);
		}
	}
	public static class Numberdecimal_ruleContext extends NumberContext {
		public Token dec;
		public TerminalNode DECIMAL() { return getToken(MMMLParser.DECIMAL, 0); }
		public Numberdecimal_ruleContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterNumberdecimal_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitNumberdecimal_rule(this);
		}
	}
	public static class Numberhexadecimal_ruleContext extends NumberContext {
		public TerminalNode HEXADECIMAL() { return getToken(MMMLParser.HEXADECIMAL, 0); }
		public Numberhexadecimal_ruleContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterNumberhexadecimal_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitNumberhexadecimal_rule(this);
		}
	}
	public static class Numberbinary_ruleContext extends NumberContext {
		public TerminalNode BINARY() { return getToken(MMMLParser.BINARY, 0); }
		public Numberbinary_ruleContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterNumberbinary_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitNumberbinary_rule(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_number);
		try {
			setState(313);
			switch (_input.LA(1)) {
			case FLOAT:
				_localctx = new Numberfloat_ruleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(305);
				((Numberfloat_ruleContext)_localctx).fl = match(FLOAT);
				((Numberfloat_ruleContext)_localctx).tiponum =  "float";
						((Numberfloat_ruleContext)_localctx).onum =  (((Numberfloat_ruleContext)_localctx).fl!=null?((Numberfloat_ruleContext)_localctx).fl.getText():null);
					
				}
				break;
			case DECIMAL:
				_localctx = new Numberdecimal_ruleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(307);
				((Numberdecimal_ruleContext)_localctx).dec = match(DECIMAL);
				((Numberdecimal_ruleContext)_localctx).tiponum =  "int";
						((Numberdecimal_ruleContext)_localctx).onum =  (((Numberdecimal_ruleContext)_localctx).dec!=null?((Numberdecimal_ruleContext)_localctx).dec.getText():null);
					
				}
				break;
			case HEXADECIMAL:
				_localctx = new Numberhexadecimal_ruleContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(309);
				match(HEXADECIMAL);
				((Numberhexadecimal_ruleContext)_localctx).tiponum =  "int";
				}
				break;
			case BINARY:
				_localctx = new Numberbinary_ruleContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(311);
				match(BINARY);
				((Numberbinary_ruleContext)_localctx).tiponum =  "int";
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

	public static class SymbolContext extends ParserRuleContext {
		public String tiposym;
		public SymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbol; }
	 
		public SymbolContext() { }
		public void copyFrom(SymbolContext ctx) {
			super.copyFrom(ctx);
			this.tiposym = ctx.tiposym;
		}
	}
	public static class Symbol_ruleContext extends SymbolContext {
		public TerminalNode TOK_ID() { return getToken(MMMLParser.TOK_ID, 0); }
		public Symbol_ruleContext(SymbolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).enterSymbol_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MMMLListener ) ((MMMLListener)listener).exitSymbol_rule(this);
		}
	}

	public final SymbolContext symbol() throws RecognitionException {
		SymbolContext _localctx = new SymbolContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_symbol);
		try {
			_localctx = new Symbol_ruleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			match(TOK_ID);

					
					
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10:
			return sequence_type_sempred((Sequence_typeContext)_localctx, predIndex);
		case 17:
			return metaexpr_sempred((MetaexprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean sequence_type_sempred(Sequence_typeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean metaexpr_sempred(MetaexprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		case 6:
			return precpred(_ctx, 6);
		case 7:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3+\u0141\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\5\3C\n\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\6\5\6U\n\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7]\n\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\5\nl\n\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\5\13x\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u0082"+
		"\n\f\f\f\16\f\u0085\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u008e\n\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00a8\n\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\5\22\u00bd\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\5\23\u00da\n\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\7\23\u00ff\n\23\f\23\16\23\u0102\13\23\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\5\25\u010e\n\25\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\5\27\u0118\n\27\3\30\3\30\3\30\3\30\5\30\u011e\n\30\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u012c\n\31"+
		"\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\5\34\u013c\n\34\3\35\3\35\3\35\3\35\2\4\26$\36\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\60\62\64\668\2\2\u014a\2:\3\2\2\2\4B\3\2\2\2"+
		"\6D\3\2\2\2\bI\3\2\2\2\nT\3\2\2\2\f\\\3\2\2\2\16^\3\2\2\2\20c\3\2\2\2"+
		"\22k\3\2\2\2\24w\3\2\2\2\26y\3\2\2\2\30\u008d\3\2\2\2\32\u008f\3\2\2\2"+
		"\34\u0096\3\2\2\2\36\u009d\3\2\2\2 \u00a7\3\2\2\2\"\u00bc\3\2\2\2$\u00d9"+
		"\3\2\2\2&\u0103\3\2\2\2(\u010d\3\2\2\2*\u010f\3\2\2\2,\u0117\3\2\2\2."+
		"\u011d\3\2\2\2\60\u012b\3\2\2\2\62\u012d\3\2\2\2\64\u0130\3\2\2\2\66\u013b"+
		"\3\2\2\28\u013d\3\2\2\2:;\5\4\3\2;<\5\6\4\2<=\b\2\1\2=\3\3\2\2\2>?\5\b"+
		"\5\2?@\5\4\3\2@C\3\2\2\2AC\3\2\2\2B>\3\2\2\2BA\3\2\2\2C\5\3\2\2\2DE\7"+
		"\3\2\2EF\7\4\2\2FG\7\5\2\2GH\5\30\r\2H\7\3\2\2\2IJ\7\3\2\2JK\5\20\t\2"+
		"KL\5\n\6\2LM\7\5\2\2MN\5\30\r\2N\t\3\2\2\2OP\5\16\b\2PQ\b\6\1\2QR\5\f"+
		"\7\2RU\3\2\2\2SU\3\2\2\2TO\3\2\2\2TS\3\2\2\2U\13\3\2\2\2VW\7\6\2\2WX\5"+
		"\16\b\2XY\b\7\1\2YZ\5\f\7\2Z]\3\2\2\2[]\3\2\2\2\\V\3\2\2\2\\[\3\2\2\2"+
		"]\r\3\2\2\2^_\58\35\2_`\7\7\2\2`a\5\22\n\2ab\b\b\1\2b\17\3\2\2\2cd\7\34"+
		"\2\2d\21\3\2\2\2ef\5\24\13\2fg\b\n\1\2gl\3\2\2\2hi\5\26\f\2ij\b\n\1\2"+
		"jl\3\2\2\2ke\3\2\2\2kh\3\2\2\2l\23\3\2\2\2mn\7\b\2\2nx\b\13\1\2op\7\t"+
		"\2\2px\b\13\1\2qr\7\n\2\2rx\b\13\1\2st\7\13\2\2tx\b\13\1\2uv\7\f\2\2v"+
		"x\b\13\1\2wm\3\2\2\2wo\3\2\2\2wq\3\2\2\2ws\3\2\2\2wu\3\2\2\2x\25\3\2\2"+
		"\2yz\b\f\1\2z{\5\24\13\2{|\7\r\2\2|}\b\f\1\2}\u0083\3\2\2\2~\177\f\3\2"+
		"\2\177\u0080\7\r\2\2\u0080\u0082\b\f\1\2\u0081~\3\2\2\2\u0082\u0085\3"+
		"\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\27\3\2\2\2\u0085"+
		"\u0083\3\2\2\2\u0086\u008e\5\32\16\2\u0087\u0088\5\34\17\2\u0088\u0089"+
		"\b\r\1\2\u0089\u008e\3\2\2\2\u008a\u008b\5$\23\2\u008b\u008c\b\r\1\2\u008c"+
		"\u008e\3\2\2\2\u008d\u0086\3\2\2\2\u008d\u0087\3\2\2\2\u008d\u008a\3\2"+
		"\2\2\u008e\31\3\2\2\2\u008f\u0090\7\16\2\2\u0090\u0091\5\30\r\2\u0091"+
		"\u0092\7\17\2\2\u0092\u0093\5\30\r\2\u0093\u0094\7\20\2\2\u0094\u0095"+
		"\5\30\r\2\u0095\33\3\2\2\2\u0096\u0097\7\21\2\2\u0097\u0098\5\36\20\2"+
		"\u0098\u0099\7\22\2\2\u0099\u009a\b\17\1\2\u009a\u009b\5\30\r\2\u009b"+
		"\u009c\b\17\1\2\u009c\35\3\2\2\2\u009d\u009e\5\"\22\2\u009e\u009f\b\20"+
		"\1\2\u009f\u00a0\5 \21\2\u00a0\37\3\2\2\2\u00a1\u00a2\7\6\2\2\u00a2\u00a3"+
		"\5\"\22\2\u00a3\u00a4\b\21\1\2\u00a4\u00a5\5 \21\2\u00a5\u00a8\3\2\2\2"+
		"\u00a6\u00a8\3\2\2\2\u00a7\u00a1\3\2\2\2\u00a7\u00a6\3\2\2\2\u00a8!\3"+
		"\2\2\2\u00a9\u00aa\58\35\2\u00aa\u00ab\b\22\1\2\u00ab\u00ac\7\5\2\2\u00ac"+
		"\u00ad\5\30\r\2\u00ad\u00ae\b\22\1\2\u00ae\u00bd\3\2\2\2\u00af\u00b0\7"+
		"\23\2\2\u00b0\u00b1\7\5\2\2\u00b1\u00b2\5\30\r\2\u00b2\u00b3\b\22\1\2"+
		"\u00b3\u00bd\3\2\2\2\u00b4\u00b5\58\35\2\u00b5\u00b6\7\35\2\2\u00b6\u00b7"+
		"\58\35\2\u00b7\u00b8\b\22\1\2\u00b8\u00b9\7\5\2\2\u00b9\u00ba\5\30\r\2"+
		"\u00ba\u00bb\b\22\1\2\u00bb\u00bd\3\2\2\2\u00bc\u00a9\3\2\2\2\u00bc\u00af"+
		"\3\2\2\2\u00bc\u00b4\3\2\2\2\u00bd#\3\2\2\2\u00be\u00bf\b\23\1\2\u00bf"+
		"\u00c0\7\24\2\2\u00c0\u00c1\5\30\r\2\u00c1\u00c2\7\25\2\2\u00c2\u00c3"+
		"\b\23\1\2\u00c3\u00da\3\2\2\2\u00c4\u00da\5&\24\2\u00c5\u00c6\7\36\2\2"+
		"\u00c6\u00c7\58\35\2\u00c7\u00c8\b\23\1\2\u00c8\u00da\3\2\2\2\u00c9\u00ca"+
		"\7\36\2\2\u00ca\u00cb\7\24\2\2\u00cb\u00cc\5\30\r\2\u00cc\u00cd\7\25\2"+
		"\2\u00cd\u00ce\b\23\1\2\u00ce\u00da\3\2\2\2\u00cf\u00d0\58\35\2\u00d0"+
		"\u00d1\b\23\1\2\u00d1\u00da\3\2\2\2\u00d2\u00d3\5\60\31\2\u00d3\u00d4"+
		"\b\23\1\2\u00d4\u00da\3\2\2\2\u00d5\u00da\5(\25\2\u00d6\u00d7\5*\26\2"+
		"\u00d7\u00d8\b\23\1\2\u00d8\u00da\3\2\2\2\u00d9\u00be\3\2\2\2\u00d9\u00c4"+
		"\3\2\2\2\u00d9\u00c5\3\2\2\2\u00d9\u00c9\3\2\2\2\u00d9\u00cf\3\2\2\2\u00d9"+
		"\u00d2\3\2\2\2\u00d9\u00d5\3\2\2\2\u00d9\u00d6\3\2\2\2\u00da\u0100\3\2"+
		"\2\2\u00db\u00dc\f\r\2\2\u00dc\u00dd\7\37\2\2\u00dd\u00de\5$\23\16\u00de"+
		"\u00df\b\23\1\2\u00df\u00ff\3\2\2\2\u00e0\u00e1\f\f\2\2\u00e1\u00e2\7"+
		"\35\2\2\u00e2\u00e3\5$\23\r\u00e3\u00e4\b\23\1\2\u00e4\u00ff\3\2\2\2\u00e5"+
		"\u00e6\f\13\2\2\u00e6\u00e7\7 \2\2\u00e7\u00e8\5$\23\f\u00e8\u00e9\b\23"+
		"\1\2\u00e9\u00ff\3\2\2\2\u00ea\u00eb\f\n\2\2\u00eb\u00ec\7!\2\2\u00ec"+
		"\u00ed\5$\23\13\u00ed\u00ee\b\23\1\2\u00ee\u00ff\3\2\2\2\u00ef\u00f0\f"+
		"\t\2\2\u00f0\u00f1\7\"\2\2\u00f1\u00f2\5$\23\n\u00f2\u00f3\b\23\1\2\u00f3"+
		"\u00ff\3\2\2\2\u00f4\u00f5\f\b\2\2\u00f5\u00f6\7#\2\2\u00f6\u00f7\5$\23"+
		"\t\u00f7\u00f8\b\23\1\2\u00f8\u00ff\3\2\2\2\u00f9\u00fa\f\7\2\2\u00fa"+
		"\u00fb\7$\2\2\u00fb\u00fc\5$\23\b\u00fc\u00fd\b\23\1\2\u00fd\u00ff\3\2"+
		"\2\2\u00fe\u00db\3\2\2\2\u00fe\u00e0\3\2\2\2\u00fe\u00e5\3\2\2\2\u00fe"+
		"\u00ea\3\2\2\2\u00fe\u00ef\3\2\2\2\u00fe\u00f4\3\2\2\2\u00fe\u00f9\3\2"+
		"\2\2\u00ff\u0102\3\2\2\2\u0100\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101"+
		"%\3\2\2\2\u0102\u0100\3\2\2\2\u0103\u0104\7\26\2\2\u0104\u0105\5\30\r"+
		"\2\u0105\u0106\7\27\2\2\u0106\'\3\2\2\2\u0107\u0108\58\35\2\u0108\u0109"+
		"\5,\27\2\u0109\u010e\3\2\2\2\u010a\u010b\58\35\2\u010b\u010c\5$\23\2\u010c"+
		"\u010e\3\2\2\2\u010d\u0107\3\2\2\2\u010d\u010a\3\2\2\2\u010e)\3\2\2\2"+
		"\u010f\u0110\5\22\n\2\u0110\u0111\5\30\r\2\u0111\u0112\b\26\1\2\u0112"+
		"+\3\2\2\2\u0113\u0114\5$\23\2\u0114\u0115\5.\30\2\u0115\u0118\3\2\2\2"+
		"\u0116\u0118\7\23\2\2\u0117\u0113\3\2\2\2\u0117\u0116\3\2\2\2\u0118-\3"+
		"\2\2\2\u0119\u011a\5$\23\2\u011a\u011b\5.\30\2\u011b\u011e\3\2\2\2\u011c"+
		"\u011e\3\2\2\2\u011d\u0119\3\2\2\2\u011d\u011c\3\2\2\2\u011e/\3\2\2\2"+
		"\u011f\u012c\7\30\2\2\u0120\u0121\7\31\2\2\u0121\u012c\b\31\1\2\u0122"+
		"\u0123\5\66\34\2\u0123\u0124\b\31\1\2\u0124\u012c\3\2\2\2\u0125\u0126"+
		"\5\62\32\2\u0126\u0127\b\31\1\2\u0127\u012c\3\2\2\2\u0128\u0129\5\64\33"+
		"\2\u0129\u012a\b\31\1\2\u012a\u012c\3\2\2\2\u012b\u011f\3\2\2\2\u012b"+
		"\u0120\3\2\2\2\u012b\u0122\3\2\2\2\u012b\u0125\3\2\2\2\u012b\u0128\3\2"+
		"\2\2\u012c\61\3\2\2\2\u012d\u012e\7&\2\2\u012e\u012f\b\32\1\2\u012f\63"+
		"\3\2\2\2\u0130\u0131\7\'\2\2\u0131\u0132\b\33\1\2\u0132\65\3\2\2\2\u0133"+
		"\u0134\7(\2\2\u0134\u013c\b\34\1\2\u0135\u0136\7)\2\2\u0136\u013c\b\34"+
		"\1\2\u0137\u0138\7*\2\2\u0138\u013c\b\34\1\2\u0139\u013a\7+\2\2\u013a"+
		"\u013c\b\34\1\2\u013b\u0133\3\2\2\2\u013b\u0135\3\2\2\2\u013b\u0137\3"+
		"\2\2\2\u013b\u0139\3\2\2\2\u013c\67\3\2\2\2\u013d\u013e\7\34\2\2\u013e"+
		"\u013f\b\35\1\2\u013f9\3\2\2\2\23BT\\kw\u0083\u008d\u00a7\u00bc\u00d9"+
		"\u00fe\u0100\u010d\u0117\u011d\u012b\u013b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}