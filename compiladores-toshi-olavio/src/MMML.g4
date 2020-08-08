grammar MMML;

@header {
package parserMMML;	

import java.util.*;
}

@parser::members {
	public NestedSymbolTable<Object> simbolos = new NestedSymbolTable<Object>();
	public Stack<Object> pilha = new Stack<Object>();
	
	NestedSymbolTable<String> tabela = new NestedSymbolTable<String>();
	private void imprimirTabela() {
		int i= 1;
	for (SymbolEntry<String> entry : tabela.getEntries()) {
                System.out.println(i +"� simbolo= "+ entry);
                i++;
            }
   }
} /*
Programa: Declarações de funções e uma função main SEMPRE

def fun x = x + 1

def main =
  let x = read_int
  in
     print concat "Resultado" (string (fun x))
*/
WS
:
	[ \r\t\u000C\n]+ -> channel ( HIDDEN )
;

COMMENT
:
	'//' ~( '\n' | '\r' )* '\r'? '\n' -> channel ( HIDDEN )
;

program
:
	fdecls maindecl
	{System.out.println("Parseou um programa!");}

;

fdecls
:
	fdecl fdecls # fdecls_one_decl_rule
	| # fdecls_end_rule
;

maindecl
:
	'def' 'main' '=' funcbody # programmain_rule
;

fdecl
:
	'def' functionname fdeclparams '=' funcbody # funcdef_rule
	/*{
            System.Console.WriteLine("Achou declaração: {0} com {1}", $functionname.text, $fdeclparams.plist.ToString());
        }*/
;

fdeclparams returns [List<String> plist] @init {
    $plist = new ArrayList<String>();
}
@after {
    for (String s : $plist) {
        System.out.println("Parametro: " + s);
    }
}
:
	fdeclparam
	{
            $plist.add($fdeclparam.pname);
        }

	fdeclparams_cont [$plist] # fdeclparams_one_param_rule
	| # fdeclparams_no_params
;

fdeclparams_cont [List<String> plist]
:
	',' fdeclparam
	{
            $plist.add($fdeclparam.pname);
        }

	fdeclparams_cont [$plist] # fdeclparams_cont_rule
	| # fdeclparams_end_rule
;

fdeclparam returns [String pname, String ptype]
:
	symbol ':' type
	{
            $pname = $symbol.text;
            $ptype = $type.text;
        } # fdecl_param_rule
;

functionname
:
	TOK_ID # fdecl_funcname_rule
;

type returns [String tipovar]
:
	tipo_regra = basic_type
	{$tipovar = $tipo_regra.tipovar;} # basictype_rule
	| sequence_type
	{
            System.out.println("Variavel do tipo " + $sequence_type.base + " dimensao "+ $sequence_type.dimension);
        } # sequencetype_rule
;

basic_type returns [String tipovar]
:
	'int'
	{$tipovar = "int";}

	| 'boolean'
	{$tipovar = "boolean";}

	| 'str'
	{$tipovar = "string";}

	| 'float'
	{$tipovar = "float";}

	| 'char'
	{$tipovar = "char";}

;

sequence_type returns [int dimension=0, String base]
:
	basic_type '[]'
	{
            $dimension = 1;
            $base = $basic_type.text;
        } # sequencetype_basetype_rule
	| s = sequence_type '[]'
	{
            $dimension = $s.dimension + 1;
            $base = $s.base;
        } # sequencetype_sequence_rule
;

funcbody returns [String fb, Object ofb]
:
	ifexpr # fbody_if_rule
	| letexpr
	{
    		$fb = $letexpr.retorno;
    		$ofb = $letexpr.ole;
    	} # fbody_let_rule
	| m = metaexpr
	{
    		$ofb = $metaexpr.ome;
			$fb = $m.tipovar; //imprimirTabela();
	} # fbody_expr_rule
;

ifexpr
:
	'if' funcbody 'then' funcbody 'else' funcbody # ifexpression_rule
;

letexpr returns [NestedSymbolTable<String> tabela, String retorno, Object ole]
:
	'let' letlist 'in'
	{tabela = $letlist.tabela;
	simbolos = $letlist.olist;
	}

	funcbody
	{tabela = tabela.getParent(); $retorno = $funcbody.fb;
		simbolos = simbolos.getParent();
		$retorno = $funcbody.fb;
		$ole =  $funcbody.ofb;
	} # letexpression_rule
;

letlist returns
[NestedSymbolTable<String> tabela, NestedSymbolTable<Object> olist] @init {
		$tabela = new NestedSymbolTable<String>();
		$olist = new  NestedSymbolTable<Object>(simbolos);
		simbolos = $olist;
	}
:
	letvarexpr
	{$tabela.store($letvarexpr.nome, $letvarexpr.tipo);
		$olist.store($letvarexpr.nome, $letvarexpr.oletvar);
	}

	letlist_cont [$tabela, $olist] # letlist_rule
;

letlist_cont
[NestedSymbolTable<String> tabela, NestedSymbolTable<Object> ocont]
:
	',' letvarexpr
	{$tabela.store($letvarexpr.nome, $letvarexpr.tipo);
		$ocont.store($letvarexpr.nome, $letvarexpr.oletvar);
	}

	letlist_cont [$tabela, $ocont] # letlist_cont_rule
	| # letlist_cont_end
;

letvarexpr returns [String nome, String tipo, Object oletvar]
:
	sym = symbol
	{$nome = $sym.text;
	}

	'=' fb = funcbody
	{//$tipo = $fb.fb;
		$oletvar = $fb.ofb;
	} # letvarattr_rule
	| '_' '=' fb = funcbody
	{$nome = "_"; $tipo = $fb.fb; 
		$oletvar = $fb.ofb;
	} # letvarresult_ignore_rule
	| sym1 = symbol '::' sym2 = symbol
	{$nome = $sym1.text + $sym2.text;
		$oletvar = $sym1.text + $sym2.text;
	}

	'=' fb = funcbody
	{$tipo = $fb.fb;
		$oletvar = $fb.ofb;
	} # letunpack_rule
;

metaexpr returns [String tipovar, Object ome]
:
	'(' fb = funcbody ')'
	{
		$tipovar = $fb.fb;
		$ome = $fb.ofb;
	} # me_exprparens_rule // Anything in parenthesis -- if, let, funcion call, etc

	| sequence_expr # me_list_create_rule // creates a list [x]

	| TOK_NEG sym = symbol
	{
    	if( $sym.tiposym == "string")
    	{
    		$tipovar = "string";
    	}
    	else
    	{
    		$tipovar = "int";
    	}
    	} # me_boolneg_rule // Negate a variable

	| TOK_NEG '(' funcbody ')'
	{
    		//$tipovar = "boolean";
    } # me_boolnegparens_rule //        or anything in between ( )

	| a = metaexpr TOK_POWER b = metaexpr
	{
		if ($a.tipovar == "int" && $b.tipovar == "int") {
		   $tipovar = "int";
		} else if ($a.tipovar == "float" && $b.tipovar == "float") {
		   $tipovar = "float";
		}
		else if (($a.tipovar == "int" && $b.tipovar == "float") || ($a.tipovar == "float" && $b.tipovar == "int"))
		{
			$tipovar = "float";
		}
		else {
			System.out.println("Errooooou");
		} 
    } # me_exprpower_rule // Exponentiation

	| a = metaexpr TOK_CONCAT b = metaexpr
	{
		if(($a.tipovar == "string" || $b.tipovar == "string"))
		{
			$tipovar = "string";
			$ome = String.valueOf($a.ome).replaceAll("\"", "");
			$ome = $ome + String.valueOf($b.ome).replaceAll("\"", "");
    		Object o1 = pilha.pop();
    		Object o2 = pilha.pop();
    		pilha.push(String.valueOf($ome).replaceAll("\"", ""));
    		
		}
		else {
			System.out.println("Errooooou");
		}      
  } # me_listconcat_rule // Sequence concatenation

	| a = metaexpr op = TOK_DIV_OR_MUL b = metaexpr
	{
		if ($a.tipovar == "int" && $b.tipovar == "int") {
		   $tipovar = "int";
		   if($op.text.equals("*")) {
    			Object o1 = pilha.pop();
    			Object o2 = pilha.pop();
    			$ome = Integer.parseInt(String.valueOf($a.ome)) * Integer.parseInt(String.valueOf($b.ome));
    			pilha.push(String.valueOf($ome).replaceAll("\"", ""));
    		} else {
    			Object o1 = pilha.pop();
    			Object o2 = pilha.pop();
    			$ome = Integer.parseInt(String.valueOf($a.ome)) / Integer.parseInt(String.valueOf($b.ome));
    			pilha.push(String.valueOf($ome).replaceAll("\"", ""));
    		}
		} else if ($a.tipovar == "float" && $b.tipovar == "float") {
		   $tipovar = "float";
		   if($op.text.equals("*")) {
    			Object o1 = pilha.pop();
    			Object o2 = pilha.pop();
    			$ome = Integer.parseInt(String.valueOf($a.ome)) * Integer.parseInt(String.valueOf($b.ome));
    			pilha.push(String.valueOf($ome).replaceAll("\"", ""));
    		} else {
    			Object o1 = pilha.pop();
    			Object o2 = pilha.pop();
    			$ome = Integer.parseInt(String.valueOf($a.ome)) / Integer.parseInt(String.valueOf($b.ome));
    			pilha.push(String.valueOf($ome).replaceAll("\"", ""));
    		}
		}
		else if (($a.tipovar == "int" && $b.tipovar == "float") || ($a.tipovar == "float" && $b.tipovar == "int"))
		{
			$tipovar = "float";
			if($op.text.equals("*")) {
    			Object o1 = pilha.pop();
    			Object o2 = pilha.pop();
    			$ome = Integer.parseInt(String.valueOf($a.ome)) * Integer.parseInt(String.valueOf($b.ome));
    			pilha.push(String.valueOf($ome).replaceAll("\"", ""));
    		} else {
    			Object o1 = pilha.pop();
    			Object o2 = pilha.pop();
    			$ome = Integer.parseInt(String.valueOf($a.ome)) / Integer.parseInt(String.valueOf($b.ome));
    			pilha.push(String.valueOf($ome).replaceAll("\"", ""));
    		}
		}
		else {
			System.out.println("Errooooou");
		} 
	} # me_exprmuldiv_rule // Div and Mult are equal

	| a = metaexpr op = TOK_PLUS_OR_MINUS b = metaexpr
	{
		if ($a.tipovar == "int" && $b.tipovar == "int") {
		   $tipovar = "int";
		   if($op.text.equals("+")) {
    			Object o1 = pilha.pop();
    			Object o2 = pilha.pop();
    			$ome = Integer.parseInt(String.valueOf($a.ome)) + Integer.parseInt(String.valueOf($b.ome));
    			pilha.push(String.valueOf($ome).replaceAll("\"", ""));
    		} else {
    			Object o1 = pilha.pop();
    			Object o2 = pilha.pop();
    			$ome = Integer.parseInt(String.valueOf($a.ome)) - Integer.parseInt(String.valueOf($b.ome));
    			pilha.push(String.valueOf($ome).replaceAll("\"", ""));
    		}
		} else if ($a.tipovar == "float" && $b.tipovar == "float") {
		   $tipovar = "float";
		   if($op.text.equals("+")) {
    			Object o1 = pilha.pop();
    			Object o2 = pilha.pop();
    			$ome = Integer.parseInt(String.valueOf($a.ome)) + Integer.parseInt(String.valueOf($b.ome));
    			pilha.push(String.valueOf($ome).replaceAll("\"", ""));
    		} else {
    			Object o1 = pilha.pop();
    			Object o2 = pilha.pop();
    			$ome = Integer.parseInt(String.valueOf($a.ome)) - Integer.parseInt(String.valueOf($b.ome));
    			pilha.push(String.valueOf($ome).replaceAll("\"", ""));
    		}
		}
		else if (($a.tipovar == "int" && $b.tipovar == "float") || ($a.tipovar == "float" && $b.tipovar == "int"))
		{
			$tipovar = "float";
			if($op.text.equals("+")) {
    			Object o1 = pilha.pop();
    			Object o2 = pilha.pop();
    			$ome = Integer.parseInt(String.valueOf($a.ome)) + Integer.parseInt(String.valueOf($b.ome));
    			pilha.push(String.valueOf($ome).replaceAll("\"", ""));
    		} else {
    			Object o1 = pilha.pop();
    			Object o2 = pilha.pop();
    			$ome = Integer.parseInt(String.valueOf($a.ome)) - Integer.parseInt(String.valueOf($b.ome));
    			pilha.push(String.valueOf($ome).replaceAll("\"", ""));
    		}
		}
		else {
			System.out.println("Errooooou");
		} 
	} # me_exprplusminus_rule // Sum and Sub are equal

	| a = metaexpr TOK_CMP_GT_LT b = metaexpr
	{
			$tipovar = "boolean";
    } # me_boolgtlt_rule // < <= >= > are equal

	| metaexpr TOK_CMP_EQ_DIFF metaexpr
	{ $tipovar = "boolean"; } # me_booleqdiff_rule // == and != are egual

	| metaexpr TOK_BOOL_AND_OR metaexpr
	{ $tipovar = "boolean"; } # me_boolandor_rule // &&   and  ||  are equal

	| sym = symbol
	{
			if(tabela.lookup($sym.text) != null) {
				
				SymbolEntry se = tabela.lookup($sym.text);
				$tipovar = (String) se.symbol;
//   $tipovar = tabela.lookup($sym.text).symbol;
		}
		if(simbolos.lookup($sym.text) != null) {
		SymbolEntry ss = simbolos.lookup($sym.text);
			   $ome = ss.symbol;
			   pilha.push(String.valueOf($ome).replaceAll("\"", ""));
			   }
	} # me_exprsymbol_rule // a single symbol

	| lit = literal
	{$tipovar = $lit.tipoliteral;
		$ome = $lit.olite;
	} # me_exprliteral_rule // literal value

	| funcall # me_exprfuncall_rule // a funcion call

	| c = cast
	{	$tipovar = $c.tipo;
		$ome = $c.ocast;
		pilha.push(String.valueOf($ome).replaceAll("\"",""));
	} # me_exprcast_rule // cast a type to other

;

sequence_expr
:
	'[' funcbody ']' # se_create_seq
;

funcall
:
	symbol funcall_params # funcall_rule
	| symbol metaexpr # funcall_rule1
	/*{
            System.Console.WriteLine("Uma chamada de funcao! {0}", $symbol.text);
        }*/
;

cast returns [String tipo, Object ocast]
:
	t = type funcbody
	{$tipo = $t.tipovar;
	$ocast = $funcbody.ofb;
	} # cast_rule
;

funcall_params
:
	metaexpr funcall_params_cont # funcallparams_rule
	| '_' # funcallnoparam_rule
;

funcall_params_cont
:
	metaexpr funcall_params_cont # funcall_params_cont_rule
	| # funcall_params_end_rule
;

literal returns [String tipoliteral, Object olite]
:
	'nil' # literalnil_rule
	| 'true'
	{
		$tipoliteral = "boolean";
	} # literaltrue_rule
	| num = number
	{
		$tipoliteral = $num.tiponum;
		$olite = $num.onum;
	} # literalnumber_rule
	| strlit
	{
		$tipoliteral = "string"; 
		$olite = $strlit.ostr;
	} # literalstring_rule
	| charlit
	{
		$tipoliteral = "char";
	} # literal_char_rule
;

strlit returns [String s, Object ostr]
:
	st = TOK_STR_LIT
	{
//		$s = "string";
		$ostr = $st.text;
	}

;

charlit returns [String cha, Object ocha]
:
	ch = TOK_CHAR_LIT
	{
		$cha = "char";
		$ocha = $ch.text;
	}

;

number returns [String tiponum, Object onum]
:
	fl = FLOAT
	{$tiponum = "float";
		$onum = $fl.text;
	} # numberfloat_rule
	| dec = DECIMAL
	{$tiponum = "int";
		$onum = $dec.text;
	} # numberdecimal_rule
	| HEXADECIMAL
	{$tiponum = "int";} # numberhexadecimal_rule
	| BINARY
	{$tiponum = "int";} # numberbinary_rule
;

symbol returns [String tiposym]
:
	TOK_ID
	{
		
		} # symbol_rule
;

// id: begins with a letter, follows letters, numbers or underscore

TOK_ID
:
	[a-zA-Z]
	(
		[a-zA-Z0-9_]*
	)
;

TOK_CONCAT
:
	'::'
;

TOK_NEG
:
	'!'
;

TOK_POWER
:
	'^'
;

TOK_DIV_OR_MUL
:
	(
		'/'
		| '*'
	)
;

TOK_PLUS_OR_MINUS
:
	(
		'+'
		| '-'
	)
;

TOK_CMP_GT_LT
:
	(
		'<='
		| '>='
		| '<'
		| '>'
	)
;

TOK_CMP_EQ_DIFF
:
	(
		'=='
		| '!='
	)
;

TOK_BOOL_AND_OR
:
	(
		'&&'
		| '||'
	)
;

TOK_REL_OP
:
	(
		'>'
		| '<'
		| '=='
		| '>='
		| '<='
	)
;

TOK_STR_LIT
:
	'"'
	(
		~[\"\\\r\n]
		| '\\'
		(
			.
			| EOF
		)
	)* '"'
;

TOK_CHAR_LIT
:
	'\''
	(
		~[\'\n\r\\]
		| '\\'
		(
			.
			| EOF
		)
	) '\''
;

FLOAT
:
	'-'? DEC_DIGIT+ '.' DEC_DIGIT+
	(
		[eE] [\+-]? DEC_DIGIT+
	)?
;

DECIMAL
:
	'-'? DEC_DIGIT+
;

HEXADECIMAL
:
	'0' 'x' HEX_DIGIT+
;

BINARY
:
	BIN_DIGIT+ 'b'
; // Sequencia de digitos seguida de b  10100b

fragment
BIN_DIGIT
:
	[01]
;

fragment
HEX_DIGIT
:
	[0-9A-Fa-f]
;

fragment
DEC_DIGIT
:
	[0-9]
;
