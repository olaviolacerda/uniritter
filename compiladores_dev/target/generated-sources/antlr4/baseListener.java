// Generated from base.g4 by ANTLR 4.4
 
using System;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link baseParser}.
 */
public interface baseListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code sequencetype_sequence_rule}
	 * labeled alternative in {@link baseParser#sequence_type}.
	 * @param ctx the parse tree
	 */
	void enterSequencetype_sequence_rule(@NotNull baseParser.Sequencetype_sequence_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sequencetype_sequence_rule}
	 * labeled alternative in {@link baseParser#sequence_type}.
	 * @param ctx the parse tree
	 */
	void exitSequencetype_sequence_rule(@NotNull baseParser.Sequencetype_sequence_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcall_params_cont_rule}
	 * labeled alternative in {@link baseParser#funcall_params_cont}.
	 * @param ctx the parse tree
	 */
	void enterFuncall_params_cont_rule(@NotNull baseParser.Funcall_params_cont_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcall_params_cont_rule}
	 * labeled alternative in {@link baseParser#funcall_params_cont}.
	 * @param ctx the parse tree
	 */
	void exitFuncall_params_cont_rule(@NotNull baseParser.Funcall_params_cont_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberhexadecimal_rule}
	 * labeled alternative in {@link baseParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumberhexadecimal_rule(@NotNull baseParser.Numberhexadecimal_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberhexadecimal_rule}
	 * labeled alternative in {@link baseParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumberhexadecimal_rule(@NotNull baseParser.Numberhexadecimal_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link baseParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull baseParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link baseParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull baseParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code me_exprcast_rule}
	 * labeled alternative in {@link baseParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void enterMe_exprcast_rule(@NotNull baseParser.Me_exprcast_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code me_exprcast_rule}
	 * labeled alternative in {@link baseParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void exitMe_exprcast_rule(@NotNull baseParser.Me_exprcast_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code letvarresult_ignore_rule}
	 * labeled alternative in {@link baseParser#letvarexpr}.
	 * @param ctx the parse tree
	 */
	void enterLetvarresult_ignore_rule(@NotNull baseParser.Letvarresult_ignore_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code letvarresult_ignore_rule}
	 * labeled alternative in {@link baseParser#letvarexpr}.
	 * @param ctx the parse tree
	 */
	void exitLetvarresult_ignore_rule(@NotNull baseParser.Letvarresult_ignore_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link baseParser#charlit}.
	 * @param ctx the parse tree
	 */
	void enterCharlit(@NotNull baseParser.CharlitContext ctx);
	/**
	 * Exit a parse tree produced by {@link baseParser#charlit}.
	 * @param ctx the parse tree
	 */
	void exitCharlit(@NotNull baseParser.CharlitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifexpression_rule}
	 * labeled alternative in {@link baseParser#ifexpr}.
	 * @param ctx the parse tree
	 */
	void enterIfexpression_rule(@NotNull baseParser.Ifexpression_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifexpression_rule}
	 * labeled alternative in {@link baseParser#ifexpr}.
	 * @param ctx the parse tree
	 */
	void exitIfexpression_rule(@NotNull baseParser.Ifexpression_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberbinary_rule}
	 * labeled alternative in {@link baseParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumberbinary_rule(@NotNull baseParser.Numberbinary_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberbinary_rule}
	 * labeled alternative in {@link baseParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumberbinary_rule(@NotNull baseParser.Numberbinary_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code me_exprparens_rule}
	 * labeled alternative in {@link baseParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void enterMe_exprparens_rule(@NotNull baseParser.Me_exprparens_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code me_exprparens_rule}
	 * labeled alternative in {@link baseParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void exitMe_exprparens_rule(@NotNull baseParser.Me_exprparens_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code me_boolandor_rule}
	 * labeled alternative in {@link baseParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void enterMe_boolandor_rule(@NotNull baseParser.Me_boolandor_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code me_boolandor_rule}
	 * labeled alternative in {@link baseParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void exitMe_boolandor_rule(@NotNull baseParser.Me_boolandor_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link baseParser#strlit}.
	 * @param ctx the parse tree
	 */
	void enterStrlit(@NotNull baseParser.StrlitContext ctx);
	/**
	 * Exit a parse tree produced by {@link baseParser#strlit}.
	 * @param ctx the parse tree
	 */
	void exitStrlit(@NotNull baseParser.StrlitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literalnumber_rule}
	 * labeled alternative in {@link baseParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteralnumber_rule(@NotNull baseParser.Literalnumber_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literalnumber_rule}
	 * labeled alternative in {@link baseParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteralnumber_rule(@NotNull baseParser.Literalnumber_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code me_exprsymbol_rule}
	 * labeled alternative in {@link baseParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void enterMe_exprsymbol_rule(@NotNull baseParser.Me_exprsymbol_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code me_exprsymbol_rule}
	 * labeled alternative in {@link baseParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void exitMe_exprsymbol_rule(@NotNull baseParser.Me_exprsymbol_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fdecls_end_rule}
	 * labeled alternative in {@link baseParser#fdecls}.
	 * @param ctx the parse tree
	 */
	void enterFdecls_end_rule(@NotNull baseParser.Fdecls_end_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fdecls_end_rule}
	 * labeled alternative in {@link baseParser#fdecls}.
	 * @param ctx the parse tree
	 */
	void exitFdecls_end_rule(@NotNull baseParser.Fdecls_end_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code symbol_rule}
	 * labeled alternative in {@link baseParser#symbol}.
	 * @param ctx the parse tree
	 */
	void enterSymbol_rule(@NotNull baseParser.Symbol_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code symbol_rule}
	 * labeled alternative in {@link baseParser#symbol}.
	 * @param ctx the parse tree
	 */
	void exitSymbol_rule(@NotNull baseParser.Symbol_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcall_rule}
	 * labeled alternative in {@link baseParser#funcall}.
	 * @param ctx the parse tree
	 */
	void enterFuncall_rule(@NotNull baseParser.Funcall_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcall_rule}
	 * labeled alternative in {@link baseParser#funcall}.
	 * @param ctx the parse tree
	 */
	void exitFuncall_rule(@NotNull baseParser.Funcall_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code letexpression_rule}
	 * labeled alternative in {@link baseParser#letexpr}.
	 * @param ctx the parse tree
	 */
	void enterLetexpression_rule(@NotNull baseParser.Letexpression_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code letexpression_rule}
	 * labeled alternative in {@link baseParser#letexpr}.
	 * @param ctx the parse tree
	 */
	void exitLetexpression_rule(@NotNull baseParser.Letexpression_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcdef_rule}
	 * labeled alternative in {@link baseParser#fdecl}.
	 * @param ctx the parse tree
	 */
	void enterFuncdef_rule(@NotNull baseParser.Funcdef_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcdef_rule}
	 * labeled alternative in {@link baseParser#fdecl}.
	 * @param ctx the parse tree
	 */
	void exitFuncdef_rule(@NotNull baseParser.Funcdef_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code me_list_create_rule}
	 * labeled alternative in {@link baseParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void enterMe_list_create_rule(@NotNull baseParser.Me_list_create_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code me_list_create_rule}
	 * labeled alternative in {@link baseParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void exitMe_list_create_rule(@NotNull baseParser.Me_list_create_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link baseParser#basic_type}.
	 * @param ctx the parse tree
	 */
	void enterBasic_type(@NotNull baseParser.Basic_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link baseParser#basic_type}.
	 * @param ctx the parse tree
	 */
	void exitBasic_type(@NotNull baseParser.Basic_typeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code letvarattr_rule}
	 * labeled alternative in {@link baseParser#letvarexpr}.
	 * @param ctx the parse tree
	 */
	void enterLetvarattr_rule(@NotNull baseParser.Letvarattr_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code letvarattr_rule}
	 * labeled alternative in {@link baseParser#letvarexpr}.
	 * @param ctx the parse tree
	 */
	void exitLetvarattr_rule(@NotNull baseParser.Letvarattr_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fdecl_param_rule}
	 * labeled alternative in {@link baseParser#fdeclparam}.
	 * @param ctx the parse tree
	 */
	void enterFdecl_param_rule(@NotNull baseParser.Fdecl_param_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fdecl_param_rule}
	 * labeled alternative in {@link baseParser#fdeclparam}.
	 * @param ctx the parse tree
	 */
	void exitFdecl_param_rule(@NotNull baseParser.Fdecl_param_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fbody_expr_rule}
	 * labeled alternative in {@link baseParser#funcbody}.
	 * @param ctx the parse tree
	 */
	void enterFbody_expr_rule(@NotNull baseParser.Fbody_expr_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fbody_expr_rule}
	 * labeled alternative in {@link baseParser#funcbody}.
	 * @param ctx the parse tree
	 */
	void exitFbody_expr_rule(@NotNull baseParser.Fbody_expr_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code me_exprfuncall_rule}
	 * labeled alternative in {@link baseParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void enterMe_exprfuncall_rule(@NotNull baseParser.Me_exprfuncall_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code me_exprfuncall_rule}
	 * labeled alternative in {@link baseParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void exitMe_exprfuncall_rule(@NotNull baseParser.Me_exprfuncall_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sequencetype_rule}
	 * labeled alternative in {@link baseParser#type}.
	 * @param ctx the parse tree
	 */
	void enterSequencetype_rule(@NotNull baseParser.Sequencetype_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sequencetype_rule}
	 * labeled alternative in {@link baseParser#type}.
	 * @param ctx the parse tree
	 */
	void exitSequencetype_rule(@NotNull baseParser.Sequencetype_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fdecl_funcname_rule}
	 * labeled alternative in {@link baseParser#functionname}.
	 * @param ctx the parse tree
	 */
	void enterFdecl_funcname_rule(@NotNull baseParser.Fdecl_funcname_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fdecl_funcname_rule}
	 * labeled alternative in {@link baseParser#functionname}.
	 * @param ctx the parse tree
	 */
	void exitFdecl_funcname_rule(@NotNull baseParser.Fdecl_funcname_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code me_exprpower_rule}
	 * labeled alternative in {@link baseParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void enterMe_exprpower_rule(@NotNull baseParser.Me_exprpower_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code me_exprpower_rule}
	 * labeled alternative in {@link baseParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void exitMe_exprpower_rule(@NotNull baseParser.Me_exprpower_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcallnoparam_rule}
	 * labeled alternative in {@link baseParser#funcall_params}.
	 * @param ctx the parse tree
	 */
	void enterFuncallnoparam_rule(@NotNull baseParser.Funcallnoparam_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcallnoparam_rule}
	 * labeled alternative in {@link baseParser#funcall_params}.
	 * @param ctx the parse tree
	 */
	void exitFuncallnoparam_rule(@NotNull baseParser.Funcallnoparam_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code letlist_rule}
	 * labeled alternative in {@link baseParser#letlist}.
	 * @param ctx the parse tree
	 */
	void enterLetlist_rule(@NotNull baseParser.Letlist_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code letlist_rule}
	 * labeled alternative in {@link baseParser#letlist}.
	 * @param ctx the parse tree
	 */
	void exitLetlist_rule(@NotNull baseParser.Letlist_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literal_char_rule}
	 * labeled alternative in {@link baseParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_char_rule(@NotNull baseParser.Literal_char_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literal_char_rule}
	 * labeled alternative in {@link baseParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_char_rule(@NotNull baseParser.Literal_char_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fdeclparams_no_params}
	 * labeled alternative in {@link baseParser#fdeclparams}.
	 * @param ctx the parse tree
	 */
	void enterFdeclparams_no_params(@NotNull baseParser.Fdeclparams_no_paramsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fdeclparams_no_params}
	 * labeled alternative in {@link baseParser#fdeclparams}.
	 * @param ctx the parse tree
	 */
	void exitFdeclparams_no_params(@NotNull baseParser.Fdeclparams_no_paramsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fbody_let_rule}
	 * labeled alternative in {@link baseParser#funcbody}.
	 * @param ctx the parse tree
	 */
	void enterFbody_let_rule(@NotNull baseParser.Fbody_let_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fbody_let_rule}
	 * labeled alternative in {@link baseParser#funcbody}.
	 * @param ctx the parse tree
	 */
	void exitFbody_let_rule(@NotNull baseParser.Fbody_let_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fbody_if_rule}
	 * labeled alternative in {@link baseParser#funcbody}.
	 * @param ctx the parse tree
	 */
	void enterFbody_if_rule(@NotNull baseParser.Fbody_if_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fbody_if_rule}
	 * labeled alternative in {@link baseParser#funcbody}.
	 * @param ctx the parse tree
	 */
	void exitFbody_if_rule(@NotNull baseParser.Fbody_if_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code me_boolneg_rule}
	 * labeled alternative in {@link baseParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void enterMe_boolneg_rule(@NotNull baseParser.Me_boolneg_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code me_boolneg_rule}
	 * labeled alternative in {@link baseParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void exitMe_boolneg_rule(@NotNull baseParser.Me_boolneg_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code letlist_cont_end}
	 * labeled alternative in {@link baseParser#letlist_cont}.
	 * @param ctx the parse tree
	 */
	void enterLetlist_cont_end(@NotNull baseParser.Letlist_cont_endContext ctx);
	/**
	 * Exit a parse tree produced by the {@code letlist_cont_end}
	 * labeled alternative in {@link baseParser#letlist_cont}.
	 * @param ctx the parse tree
	 */
	void exitLetlist_cont_end(@NotNull baseParser.Letlist_cont_endContext ctx);
	/**
	 * Enter a parse tree produced by the {@code letunpack_rule}
	 * labeled alternative in {@link baseParser#letvarexpr}.
	 * @param ctx the parse tree
	 */
	void enterLetunpack_rule(@NotNull baseParser.Letunpack_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code letunpack_rule}
	 * labeled alternative in {@link baseParser#letvarexpr}.
	 * @param ctx the parse tree
	 */
	void exitLetunpack_rule(@NotNull baseParser.Letunpack_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code programmain_rule}
	 * labeled alternative in {@link baseParser#maindecl}.
	 * @param ctx the parse tree
	 */
	void enterProgrammain_rule(@NotNull baseParser.Programmain_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code programmain_rule}
	 * labeled alternative in {@link baseParser#maindecl}.
	 * @param ctx the parse tree
	 */
	void exitProgrammain_rule(@NotNull baseParser.Programmain_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberdecimal_rule}
	 * labeled alternative in {@link baseParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumberdecimal_rule(@NotNull baseParser.Numberdecimal_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberdecimal_rule}
	 * labeled alternative in {@link baseParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumberdecimal_rule(@NotNull baseParser.Numberdecimal_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code me_listconcat_rule}
	 * labeled alternative in {@link baseParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void enterMe_listconcat_rule(@NotNull baseParser.Me_listconcat_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code me_listconcat_rule}
	 * labeled alternative in {@link baseParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void exitMe_listconcat_rule(@NotNull baseParser.Me_listconcat_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code me_exprmuldiv_rule}
	 * labeled alternative in {@link baseParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void enterMe_exprmuldiv_rule(@NotNull baseParser.Me_exprmuldiv_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code me_exprmuldiv_rule}
	 * labeled alternative in {@link baseParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void exitMe_exprmuldiv_rule(@NotNull baseParser.Me_exprmuldiv_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberfloat_rule}
	 * labeled alternative in {@link baseParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumberfloat_rule(@NotNull baseParser.Numberfloat_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberfloat_rule}
	 * labeled alternative in {@link baseParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumberfloat_rule(@NotNull baseParser.Numberfloat_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code me_boolgtlt_rule}
	 * labeled alternative in {@link baseParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void enterMe_boolgtlt_rule(@NotNull baseParser.Me_boolgtlt_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code me_boolgtlt_rule}
	 * labeled alternative in {@link baseParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void exitMe_boolgtlt_rule(@NotNull baseParser.Me_boolgtlt_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fdecls_one_decl_rule}
	 * labeled alternative in {@link baseParser#fdecls}.
	 * @param ctx the parse tree
	 */
	void enterFdecls_one_decl_rule(@NotNull baseParser.Fdecls_one_decl_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fdecls_one_decl_rule}
	 * labeled alternative in {@link baseParser#fdecls}.
	 * @param ctx the parse tree
	 */
	void exitFdecls_one_decl_rule(@NotNull baseParser.Fdecls_one_decl_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code se_create_seq}
	 * labeled alternative in {@link baseParser#sequence_expr}.
	 * @param ctx the parse tree
	 */
	void enterSe_create_seq(@NotNull baseParser.Se_create_seqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code se_create_seq}
	 * labeled alternative in {@link baseParser#sequence_expr}.
	 * @param ctx the parse tree
	 */
	void exitSe_create_seq(@NotNull baseParser.Se_create_seqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fdeclparams_cont_rule}
	 * labeled alternative in {@link baseParser#fdeclparams_cont}.
	 * @param ctx the parse tree
	 */
	void enterFdeclparams_cont_rule(@NotNull baseParser.Fdeclparams_cont_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fdeclparams_cont_rule}
	 * labeled alternative in {@link baseParser#fdeclparams_cont}.
	 * @param ctx the parse tree
	 */
	void exitFdeclparams_cont_rule(@NotNull baseParser.Fdeclparams_cont_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code me_booleqdiff_rule}
	 * labeled alternative in {@link baseParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void enterMe_booleqdiff_rule(@NotNull baseParser.Me_booleqdiff_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code me_booleqdiff_rule}
	 * labeled alternative in {@link baseParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void exitMe_booleqdiff_rule(@NotNull baseParser.Me_booleqdiff_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code me_exprplusminus_rule}
	 * labeled alternative in {@link baseParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void enterMe_exprplusminus_rule(@NotNull baseParser.Me_exprplusminus_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code me_exprplusminus_rule}
	 * labeled alternative in {@link baseParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void exitMe_exprplusminus_rule(@NotNull baseParser.Me_exprplusminus_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cast_rule}
	 * labeled alternative in {@link baseParser#cast}.
	 * @param ctx the parse tree
	 */
	void enterCast_rule(@NotNull baseParser.Cast_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cast_rule}
	 * labeled alternative in {@link baseParser#cast}.
	 * @param ctx the parse tree
	 */
	void exitCast_rule(@NotNull baseParser.Cast_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sequencetype_basetype_rule}
	 * labeled alternative in {@link baseParser#sequence_type}.
	 * @param ctx the parse tree
	 */
	void enterSequencetype_basetype_rule(@NotNull baseParser.Sequencetype_basetype_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sequencetype_basetype_rule}
	 * labeled alternative in {@link baseParser#sequence_type}.
	 * @param ctx the parse tree
	 */
	void exitSequencetype_basetype_rule(@NotNull baseParser.Sequencetype_basetype_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code me_exprliteral_rule}
	 * labeled alternative in {@link baseParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void enterMe_exprliteral_rule(@NotNull baseParser.Me_exprliteral_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code me_exprliteral_rule}
	 * labeled alternative in {@link baseParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void exitMe_exprliteral_rule(@NotNull baseParser.Me_exprliteral_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code letlist_cont_rule}
	 * labeled alternative in {@link baseParser#letlist_cont}.
	 * @param ctx the parse tree
	 */
	void enterLetlist_cont_rule(@NotNull baseParser.Letlist_cont_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code letlist_cont_rule}
	 * labeled alternative in {@link baseParser#letlist_cont}.
	 * @param ctx the parse tree
	 */
	void exitLetlist_cont_rule(@NotNull baseParser.Letlist_cont_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literalnil_rule}
	 * labeled alternative in {@link baseParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteralnil_rule(@NotNull baseParser.Literalnil_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literalnil_rule}
	 * labeled alternative in {@link baseParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteralnil_rule(@NotNull baseParser.Literalnil_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literalstring_rule}
	 * labeled alternative in {@link baseParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteralstring_rule(@NotNull baseParser.Literalstring_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literalstring_rule}
	 * labeled alternative in {@link baseParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteralstring_rule(@NotNull baseParser.Literalstring_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code basictype_rule}
	 * labeled alternative in {@link baseParser#type}.
	 * @param ctx the parse tree
	 */
	void enterBasictype_rule(@NotNull baseParser.Basictype_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code basictype_rule}
	 * labeled alternative in {@link baseParser#type}.
	 * @param ctx the parse tree
	 */
	void exitBasictype_rule(@NotNull baseParser.Basictype_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fdeclparams_one_param_rule}
	 * labeled alternative in {@link baseParser#fdeclparams}.
	 * @param ctx the parse tree
	 */
	void enterFdeclparams_one_param_rule(@NotNull baseParser.Fdeclparams_one_param_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fdeclparams_one_param_rule}
	 * labeled alternative in {@link baseParser#fdeclparams}.
	 * @param ctx the parse tree
	 */
	void exitFdeclparams_one_param_rule(@NotNull baseParser.Fdeclparams_one_param_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcall_params_end_rule}
	 * labeled alternative in {@link baseParser#funcall_params_cont}.
	 * @param ctx the parse tree
	 */
	void enterFuncall_params_end_rule(@NotNull baseParser.Funcall_params_end_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcall_params_end_rule}
	 * labeled alternative in {@link baseParser#funcall_params_cont}.
	 * @param ctx the parse tree
	 */
	void exitFuncall_params_end_rule(@NotNull baseParser.Funcall_params_end_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcallparams_rule}
	 * labeled alternative in {@link baseParser#funcall_params}.
	 * @param ctx the parse tree
	 */
	void enterFuncallparams_rule(@NotNull baseParser.Funcallparams_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcallparams_rule}
	 * labeled alternative in {@link baseParser#funcall_params}.
	 * @param ctx the parse tree
	 */
	void exitFuncallparams_rule(@NotNull baseParser.Funcallparams_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fdeclparams_end_rule}
	 * labeled alternative in {@link baseParser#fdeclparams_cont}.
	 * @param ctx the parse tree
	 */
	void enterFdeclparams_end_rule(@NotNull baseParser.Fdeclparams_end_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fdeclparams_end_rule}
	 * labeled alternative in {@link baseParser#fdeclparams_cont}.
	 * @param ctx the parse tree
	 */
	void exitFdeclparams_end_rule(@NotNull baseParser.Fdeclparams_end_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code me_boolnegparens_rule}
	 * labeled alternative in {@link baseParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void enterMe_boolnegparens_rule(@NotNull baseParser.Me_boolnegparens_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code me_boolnegparens_rule}
	 * labeled alternative in {@link baseParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void exitMe_boolnegparens_rule(@NotNull baseParser.Me_boolnegparens_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literaltrue_rule}
	 * labeled alternative in {@link baseParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteraltrue_rule(@NotNull baseParser.Literaltrue_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literaltrue_rule}
	 * labeled alternative in {@link baseParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteraltrue_rule(@NotNull baseParser.Literaltrue_ruleContext ctx);
}