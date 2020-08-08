grammar Numbers;
@header {

    package parser;

}


NEWLINE : [ \r\t\u000C\n]+ -> channel(HIDDEN);

exprtotal: expr operador expr;

operador: '^'|'*'|'/'|'+'|'-'|'÷'|'x';

expr: pare |(DECIMAL|HEXADECIMAL|REAL|BINARY);

pare: '('exprtotal')'; 

HEXADECIMAL : [0][x][0-9a-fA-F]+;

BINARY : BIN_DIGIT+ 'b'; // Sequencia de digitos seguida de b  10100b

REAL : '-'?[0-9]+'.'[0-9]+([Ee][+-]?[0-9]+)?;

DECIMAL :'-'?[0-9]+;

BIN_DIGIT : [01];