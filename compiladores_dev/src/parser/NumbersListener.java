// Generated from src/Numbers.g4 by ANTLR 4.5.3


    package parser;


import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NumbersParser}.
 */
public interface NumbersListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NumbersParser#exprtotal}.
	 * @param ctx the parse tree
	 */
	void enterExprtotal(NumbersParser.ExprtotalContext ctx);
	/**
	 * Exit a parse tree produced by {@link NumbersParser#exprtotal}.
	 * @param ctx the parse tree
	 */
	void exitExprtotal(NumbersParser.ExprtotalContext ctx);
	/**
	 * Enter a parse tree produced by {@link NumbersParser#operador}.
	 * @param ctx the parse tree
	 */
	void enterOperador(NumbersParser.OperadorContext ctx);
	/**
	 * Exit a parse tree produced by {@link NumbersParser#operador}.
	 * @param ctx the parse tree
	 */
	void exitOperador(NumbersParser.OperadorContext ctx);
	/**
	 * Enter a parse tree produced by {@link NumbersParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(NumbersParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NumbersParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(NumbersParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NumbersParser#pare}.
	 * @param ctx the parse tree
	 */
	void enterPare(NumbersParser.PareContext ctx);
	/**
	 * Exit a parse tree produced by {@link NumbersParser#pare}.
	 * @param ctx the parse tree
	 */
	void exitPare(NumbersParser.PareContext ctx);
}