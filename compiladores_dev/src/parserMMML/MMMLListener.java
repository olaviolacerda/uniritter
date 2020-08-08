// Generated from src/MMML.g4 by ANTLR 4.5.3

package parserMMML;	

import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MMMLParser}.
 */
public interface MMMLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MMMLParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MMMLParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MMMLParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MMMLParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fdecls_one_decl_rule}
	 * labeled alternative in {@link MMMLParser#fdecls}.
	 * @param ctx the parse tree
	 */
	void enterFdecls_one_decl_rule(MMMLParser.Fdecls_one_decl_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fdecls_one_decl_rule}
	 * labeled alternative in {@link MMMLParser#fdecls}.
	 * @param ctx the parse tree
	 */
	void exitFdecls_one_decl_rule(MMMLParser.Fdecls_one_decl_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fdecls_end_rule}
	 * labeled alternative in {@link MMMLParser#fdecls}.
	 * @param ctx the parse tree
	 */
	void enterFdecls_end_rule(MMMLParser.Fdecls_end_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fdecls_end_rule}
	 * labeled alternative in {@link MMMLParser#fdecls}.
	 * @param ctx the parse tree
	 */
	void exitFdecls_end_rule(MMMLParser.Fdecls_end_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code programmain_rule}
	 * labeled alternative in {@link MMMLParser#maindecl}.
	 * @param ctx the parse tree
	 */
	void enterProgrammain_rule(MMMLParser.Programmain_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code programmain_rule}
	 * labeled alternative in {@link MMMLParser#maindecl}.
	 * @param ctx the parse tree
	 */
	void exitProgrammain_rule(MMMLParser.Programmain_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcdef_rule}
	 * labeled alternative in {@link MMMLParser#fdecl}.
	 * @param ctx the parse tree
	 */
	void enterFuncdef_rule(MMMLParser.Funcdef_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcdef_rule}
	 * labeled alternative in {@link MMMLParser#fdecl}.
	 * @param ctx the parse tree
	 */
	void exitFuncdef_rule(MMMLParser.Funcdef_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fdeclparams_one_param_rule}
	 * labeled alternative in {@link MMMLParser#fdeclparams}.
	 * @param ctx the parse tree
	 */
	void enterFdeclparams_one_param_rule(MMMLParser.Fdeclparams_one_param_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fdeclparams_one_param_rule}
	 * labeled alternative in {@link MMMLParser#fdeclparams}.
	 * @param ctx the parse tree
	 */
	void exitFdeclparams_one_param_rule(MMMLParser.Fdeclparams_one_param_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fdeclparams_no_params}
	 * labeled alternative in {@link MMMLParser#fdeclparams}.
	 * @param ctx the parse tree
	 */
	void enterFdeclparams_no_params(MMMLParser.Fdeclparams_no_paramsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fdeclparams_no_params}
	 * labeled alternative in {@link MMMLParser#fdeclparams}.
	 * @param ctx the parse tree
	 */
	void exitFdeclparams_no_params(MMMLParser.Fdeclparams_no_paramsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fdeclparams_cont_rule}
	 * labeled alternative in {@link MMMLParser#fdeclparams_cont}.
	 * @param ctx the parse tree
	 */
	void enterFdeclparams_cont_rule(MMMLParser.Fdeclparams_cont_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fdeclparams_cont_rule}
	 * labeled alternative in {@link MMMLParser#fdeclparams_cont}.
	 * @param ctx the parse tree
	 */
	void exitFdeclparams_cont_rule(MMMLParser.Fdeclparams_cont_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fdeclparams_end_rule}
	 * labeled alternative in {@link MMMLParser#fdeclparams_cont}.
	 * @param ctx the parse tree
	 */
	void enterFdeclparams_end_rule(MMMLParser.Fdeclparams_end_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fdeclparams_end_rule}
	 * labeled alternative in {@link MMMLParser#fdeclparams_cont}.
	 * @param ctx the parse tree
	 */
	void exitFdeclparams_end_rule(MMMLParser.Fdeclparams_end_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fdecl_param_rule}
	 * labeled alternative in {@link MMMLParser#fdeclparam}.
	 * @param ctx the parse tree
	 */
	void enterFdecl_param_rule(MMMLParser.Fdecl_param_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fdecl_param_rule}
	 * labeled alternative in {@link MMMLParser#fdeclparam}.
	 * @param ctx the parse tree
	 */
	void exitFdecl_param_rule(MMMLParser.Fdecl_param_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fdecl_funcname_rule}
	 * labeled alternative in {@link MMMLParser#functionname}.
	 * @param ctx the parse tree
	 */
	void enterFdecl_funcname_rule(MMMLParser.Fdecl_funcname_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fdecl_funcname_rule}
	 * labeled alternative in {@link MMMLParser#functionname}.
	 * @param ctx the parse tree
	 */
	void exitFdecl_funcname_rule(MMMLParser.Fdecl_funcname_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code basictype_rule}
	 * labeled alternative in {@link MMMLParser#type}.
	 * @param ctx the parse tree
	 */
	void enterBasictype_rule(MMMLParser.Basictype_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code basictype_rule}
	 * labeled alternative in {@link MMMLParser#type}.
	 * @param ctx the parse tree
	 */
	void exitBasictype_rule(MMMLParser.Basictype_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sequencetype_rule}
	 * labeled alternative in {@link MMMLParser#type}.
	 * @param ctx the parse tree
	 */
	void enterSequencetype_rule(MMMLParser.Sequencetype_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sequencetype_rule}
	 * labeled alternative in {@link MMMLParser#type}.
	 * @param ctx the parse tree
	 */
	void exitSequencetype_rule(MMMLParser.Sequencetype_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MMMLParser#basic_type}.
	 * @param ctx the parse tree
	 */
	void enterBasic_type(MMMLParser.Basic_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MMMLParser#basic_type}.
	 * @param ctx the parse tree
	 */
	void exitBasic_type(MMMLParser.Basic_typeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sequencetype_sequence_rule}
	 * labeled alternative in {@link MMMLParser#sequence_type}.
	 * @param ctx the parse tree
	 */
	void enterSequencetype_sequence_rule(MMMLParser.Sequencetype_sequence_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sequencetype_sequence_rule}
	 * labeled alternative in {@link MMMLParser#sequence_type}.
	 * @param ctx the parse tree
	 */
	void exitSequencetype_sequence_rule(MMMLParser.Sequencetype_sequence_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sequencetype_basetype_rule}
	 * labeled alternative in {@link MMMLParser#sequence_type}.
	 * @param ctx the parse tree
	 */
	void enterSequencetype_basetype_rule(MMMLParser.Sequencetype_basetype_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sequencetype_basetype_rule}
	 * labeled alternative in {@link MMMLParser#sequence_type}.
	 * @param ctx the parse tree
	 */
	void exitSequencetype_basetype_rule(MMMLParser.Sequencetype_basetype_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fbody_if_rule}
	 * labeled alternative in {@link MMMLParser#funcbody}.
	 * @param ctx the parse tree
	 */
	void enterFbody_if_rule(MMMLParser.Fbody_if_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fbody_if_rule}
	 * labeled alternative in {@link MMMLParser#funcbody}.
	 * @param ctx the parse tree
	 */
	void exitFbody_if_rule(MMMLParser.Fbody_if_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fbody_let_rule}
	 * labeled alternative in {@link MMMLParser#funcbody}.
	 * @param ctx the parse tree
	 */
	void enterFbody_let_rule(MMMLParser.Fbody_let_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fbody_let_rule}
	 * labeled alternative in {@link MMMLParser#funcbody}.
	 * @param ctx the parse tree
	 */
	void exitFbody_let_rule(MMMLParser.Fbody_let_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fbody_expr_rule}
	 * labeled alternative in {@link MMMLParser#funcbody}.
	 * @param ctx the parse tree
	 */
	void enterFbody_expr_rule(MMMLParser.Fbody_expr_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fbody_expr_rule}
	 * labeled alternative in {@link MMMLParser#funcbody}.
	 * @param ctx the parse tree
	 */
	void exitFbody_expr_rule(MMMLParser.Fbody_expr_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifexpression_rule}
	 * labeled alternative in {@link MMMLParser#ifexpr}.
	 * @param ctx the parse tree
	 */
	void enterIfexpression_rule(MMMLParser.Ifexpression_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifexpression_rule}
	 * labeled alternative in {@link MMMLParser#ifexpr}.
	 * @param ctx the parse tree
	 */
	void exitIfexpression_rule(MMMLParser.Ifexpression_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code letexpression_rule}
	 * labeled alternative in {@link MMMLParser#letexpr}.
	 * @param ctx the parse tree
	 */
	void enterLetexpression_rule(MMMLParser.Letexpression_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code letexpression_rule}
	 * labeled alternative in {@link MMMLParser#letexpr}.
	 * @param ctx the parse tree
	 */
	void exitLetexpression_rule(MMMLParser.Letexpression_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code letlist_rule}
	 * labeled alternative in {@link MMMLParser#letlist}.
	 * @param ctx the parse tree
	 */
	void enterLetlist_rule(MMMLParser.Letlist_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code letlist_rule}
	 * labeled alternative in {@link MMMLParser#letlist}.
	 * @param ctx the parse tree
	 */
	void exitLetlist_rule(MMMLParser.Letlist_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code letlist_cont_rule}
	 * labeled alternative in {@link MMMLParser#letlist_cont}.
	 * @param ctx the parse tree
	 */
	void enterLetlist_cont_rule(MMMLParser.Letlist_cont_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code letlist_cont_rule}
	 * labeled alternative in {@link MMMLParser#letlist_cont}.
	 * @param ctx the parse tree
	 */
	void exitLetlist_cont_rule(MMMLParser.Letlist_cont_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code letlist_cont_end}
	 * labeled alternative in {@link MMMLParser#letlist_cont}.
	 * @param ctx the parse tree
	 */
	void enterLetlist_cont_end(MMMLParser.Letlist_cont_endContext ctx);
	/**
	 * Exit a parse tree produced by the {@code letlist_cont_end}
	 * labeled alternative in {@link MMMLParser#letlist_cont}.
	 * @param ctx the parse tree
	 */
	void exitLetlist_cont_end(MMMLParser.Letlist_cont_endContext ctx);
	/**
	 * Enter a parse tree produced by the {@code letvarattr_rule}
	 * labeled alternative in {@link MMMLParser#letvarexpr}.
	 * @param ctx the parse tree
	 */
	void enterLetvarattr_rule(MMMLParser.Letvarattr_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code letvarattr_rule}
	 * labeled alternative in {@link MMMLParser#letvarexpr}.
	 * @param ctx the parse tree
	 */
	void exitLetvarattr_rule(MMMLParser.Letvarattr_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code letvarresult_ignore_rule}
	 * labeled alternative in {@link MMMLParser#letvarexpr}.
	 * @param ctx the parse tree
	 */
	void enterLetvarresult_ignore_rule(MMMLParser.Letvarresult_ignore_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code letvarresult_ignore_rule}
	 * labeled alternative in {@link MMMLParser#letvarexpr}.
	 * @param ctx the parse tree
	 */
	void exitLetvarresult_ignore_rule(MMMLParser.Letvarresult_ignore_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code letunpack_rule}
	 * labeled alternative in {@link MMMLParser#letvarexpr}.
	 * @param ctx the parse tree
	 */
	void enterLetunpack_rule(MMMLParser.Letunpack_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code letunpack_rule}
	 * labeled alternative in {@link MMMLParser#letvarexpr}.
	 * @param ctx the parse tree
	 */
	void exitLetunpack_rule(MMMLParser.Letunpack_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code me_exprplusminus_rule}
	 * labeled alternative in {@link MMMLParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void enterMe_exprplusminus_rule(MMMLParser.Me_exprplusminus_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code me_exprplusminus_rule}
	 * labeled alternative in {@link MMMLParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void exitMe_exprplusminus_rule(MMMLParser.Me_exprplusminus_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code me_boolneg_rule}
	 * labeled alternative in {@link MMMLParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void enterMe_boolneg_rule(MMMLParser.Me_boolneg_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code me_boolneg_rule}
	 * labeled alternative in {@link MMMLParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void exitMe_boolneg_rule(MMMLParser.Me_boolneg_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code me_exprliteral_rule}
	 * labeled alternative in {@link MMMLParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void enterMe_exprliteral_rule(MMMLParser.Me_exprliteral_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code me_exprliteral_rule}
	 * labeled alternative in {@link MMMLParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void exitMe_exprliteral_rule(MMMLParser.Me_exprliteral_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code me_listconcat_rule}
	 * labeled alternative in {@link MMMLParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void enterMe_listconcat_rule(MMMLParser.Me_listconcat_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code me_listconcat_rule}
	 * labeled alternative in {@link MMMLParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void exitMe_listconcat_rule(MMMLParser.Me_listconcat_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code me_list_create_rule}
	 * labeled alternative in {@link MMMLParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void enterMe_list_create_rule(MMMLParser.Me_list_create_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code me_list_create_rule}
	 * labeled alternative in {@link MMMLParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void exitMe_list_create_rule(MMMLParser.Me_list_create_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code me_exprmuldiv_rule}
	 * labeled alternative in {@link MMMLParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void enterMe_exprmuldiv_rule(MMMLParser.Me_exprmuldiv_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code me_exprmuldiv_rule}
	 * labeled alternative in {@link MMMLParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void exitMe_exprmuldiv_rule(MMMLParser.Me_exprmuldiv_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code me_exprcast_rule}
	 * labeled alternative in {@link MMMLParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void enterMe_exprcast_rule(MMMLParser.Me_exprcast_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code me_exprcast_rule}
	 * labeled alternative in {@link MMMLParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void exitMe_exprcast_rule(MMMLParser.Me_exprcast_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code me_exprparens_rule}
	 * labeled alternative in {@link MMMLParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void enterMe_exprparens_rule(MMMLParser.Me_exprparens_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code me_exprparens_rule}
	 * labeled alternative in {@link MMMLParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void exitMe_exprparens_rule(MMMLParser.Me_exprparens_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code me_boolandor_rule}
	 * labeled alternative in {@link MMMLParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void enterMe_boolandor_rule(MMMLParser.Me_boolandor_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code me_boolandor_rule}
	 * labeled alternative in {@link MMMLParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void exitMe_boolandor_rule(MMMLParser.Me_boolandor_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code me_exprsymbol_rule}
	 * labeled alternative in {@link MMMLParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void enterMe_exprsymbol_rule(MMMLParser.Me_exprsymbol_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code me_exprsymbol_rule}
	 * labeled alternative in {@link MMMLParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void exitMe_exprsymbol_rule(MMMLParser.Me_exprsymbol_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code me_exprfuncall_rule}
	 * labeled alternative in {@link MMMLParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void enterMe_exprfuncall_rule(MMMLParser.Me_exprfuncall_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code me_exprfuncall_rule}
	 * labeled alternative in {@link MMMLParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void exitMe_exprfuncall_rule(MMMLParser.Me_exprfuncall_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code me_boolgtlt_rule}
	 * labeled alternative in {@link MMMLParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void enterMe_boolgtlt_rule(MMMLParser.Me_boolgtlt_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code me_boolgtlt_rule}
	 * labeled alternative in {@link MMMLParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void exitMe_boolgtlt_rule(MMMLParser.Me_boolgtlt_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code me_boolnegparens_rule}
	 * labeled alternative in {@link MMMLParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void enterMe_boolnegparens_rule(MMMLParser.Me_boolnegparens_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code me_boolnegparens_rule}
	 * labeled alternative in {@link MMMLParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void exitMe_boolnegparens_rule(MMMLParser.Me_boolnegparens_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code me_exprpower_rule}
	 * labeled alternative in {@link MMMLParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void enterMe_exprpower_rule(MMMLParser.Me_exprpower_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code me_exprpower_rule}
	 * labeled alternative in {@link MMMLParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void exitMe_exprpower_rule(MMMLParser.Me_exprpower_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code me_booleqdiff_rule}
	 * labeled alternative in {@link MMMLParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void enterMe_booleqdiff_rule(MMMLParser.Me_booleqdiff_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code me_booleqdiff_rule}
	 * labeled alternative in {@link MMMLParser#metaexpr}.
	 * @param ctx the parse tree
	 */
	void exitMe_booleqdiff_rule(MMMLParser.Me_booleqdiff_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code se_create_seq}
	 * labeled alternative in {@link MMMLParser#sequence_expr}.
	 * @param ctx the parse tree
	 */
	void enterSe_create_seq(MMMLParser.Se_create_seqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code se_create_seq}
	 * labeled alternative in {@link MMMLParser#sequence_expr}.
	 * @param ctx the parse tree
	 */
	void exitSe_create_seq(MMMLParser.Se_create_seqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcall_rule}
	 * labeled alternative in {@link MMMLParser#funcall}.
	 * @param ctx the parse tree
	 */
	void enterFuncall_rule(MMMLParser.Funcall_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcall_rule}
	 * labeled alternative in {@link MMMLParser#funcall}.
	 * @param ctx the parse tree
	 */
	void exitFuncall_rule(MMMLParser.Funcall_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcall_rule1}
	 * labeled alternative in {@link MMMLParser#funcall}.
	 * @param ctx the parse tree
	 */
	void enterFuncall_rule1(MMMLParser.Funcall_rule1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code funcall_rule1}
	 * labeled alternative in {@link MMMLParser#funcall}.
	 * @param ctx the parse tree
	 */
	void exitFuncall_rule1(MMMLParser.Funcall_rule1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code cast_rule}
	 * labeled alternative in {@link MMMLParser#cast}.
	 * @param ctx the parse tree
	 */
	void enterCast_rule(MMMLParser.Cast_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cast_rule}
	 * labeled alternative in {@link MMMLParser#cast}.
	 * @param ctx the parse tree
	 */
	void exitCast_rule(MMMLParser.Cast_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcallparams_rule}
	 * labeled alternative in {@link MMMLParser#funcall_params}.
	 * @param ctx the parse tree
	 */
	void enterFuncallparams_rule(MMMLParser.Funcallparams_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcallparams_rule}
	 * labeled alternative in {@link MMMLParser#funcall_params}.
	 * @param ctx the parse tree
	 */
	void exitFuncallparams_rule(MMMLParser.Funcallparams_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcallnoparam_rule}
	 * labeled alternative in {@link MMMLParser#funcall_params}.
	 * @param ctx the parse tree
	 */
	void enterFuncallnoparam_rule(MMMLParser.Funcallnoparam_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcallnoparam_rule}
	 * labeled alternative in {@link MMMLParser#funcall_params}.
	 * @param ctx the parse tree
	 */
	void exitFuncallnoparam_rule(MMMLParser.Funcallnoparam_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcall_params_cont_rule}
	 * labeled alternative in {@link MMMLParser#funcall_params_cont}.
	 * @param ctx the parse tree
	 */
	void enterFuncall_params_cont_rule(MMMLParser.Funcall_params_cont_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcall_params_cont_rule}
	 * labeled alternative in {@link MMMLParser#funcall_params_cont}.
	 * @param ctx the parse tree
	 */
	void exitFuncall_params_cont_rule(MMMLParser.Funcall_params_cont_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcall_params_end_rule}
	 * labeled alternative in {@link MMMLParser#funcall_params_cont}.
	 * @param ctx the parse tree
	 */
	void enterFuncall_params_end_rule(MMMLParser.Funcall_params_end_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcall_params_end_rule}
	 * labeled alternative in {@link MMMLParser#funcall_params_cont}.
	 * @param ctx the parse tree
	 */
	void exitFuncall_params_end_rule(MMMLParser.Funcall_params_end_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literalnil_rule}
	 * labeled alternative in {@link MMMLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteralnil_rule(MMMLParser.Literalnil_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literalnil_rule}
	 * labeled alternative in {@link MMMLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteralnil_rule(MMMLParser.Literalnil_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literaltrue_rule}
	 * labeled alternative in {@link MMMLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteraltrue_rule(MMMLParser.Literaltrue_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literaltrue_rule}
	 * labeled alternative in {@link MMMLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteraltrue_rule(MMMLParser.Literaltrue_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literalnumber_rule}
	 * labeled alternative in {@link MMMLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteralnumber_rule(MMMLParser.Literalnumber_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literalnumber_rule}
	 * labeled alternative in {@link MMMLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteralnumber_rule(MMMLParser.Literalnumber_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literalstring_rule}
	 * labeled alternative in {@link MMMLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteralstring_rule(MMMLParser.Literalstring_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literalstring_rule}
	 * labeled alternative in {@link MMMLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteralstring_rule(MMMLParser.Literalstring_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literal_char_rule}
	 * labeled alternative in {@link MMMLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_char_rule(MMMLParser.Literal_char_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literal_char_rule}
	 * labeled alternative in {@link MMMLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_char_rule(MMMLParser.Literal_char_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MMMLParser#strlit}.
	 * @param ctx the parse tree
	 */
	void enterStrlit(MMMLParser.StrlitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MMMLParser#strlit}.
	 * @param ctx the parse tree
	 */
	void exitStrlit(MMMLParser.StrlitContext ctx);
	/**
	 * Enter a parse tree produced by {@link MMMLParser#charlit}.
	 * @param ctx the parse tree
	 */
	void enterCharlit(MMMLParser.CharlitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MMMLParser#charlit}.
	 * @param ctx the parse tree
	 */
	void exitCharlit(MMMLParser.CharlitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberfloat_rule}
	 * labeled alternative in {@link MMMLParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumberfloat_rule(MMMLParser.Numberfloat_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberfloat_rule}
	 * labeled alternative in {@link MMMLParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumberfloat_rule(MMMLParser.Numberfloat_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberdecimal_rule}
	 * labeled alternative in {@link MMMLParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumberdecimal_rule(MMMLParser.Numberdecimal_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberdecimal_rule}
	 * labeled alternative in {@link MMMLParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumberdecimal_rule(MMMLParser.Numberdecimal_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberhexadecimal_rule}
	 * labeled alternative in {@link MMMLParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumberhexadecimal_rule(MMMLParser.Numberhexadecimal_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberhexadecimal_rule}
	 * labeled alternative in {@link MMMLParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumberhexadecimal_rule(MMMLParser.Numberhexadecimal_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberbinary_rule}
	 * labeled alternative in {@link MMMLParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumberbinary_rule(MMMLParser.Numberbinary_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberbinary_rule}
	 * labeled alternative in {@link MMMLParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumberbinary_rule(MMMLParser.Numberbinary_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code symbol_rule}
	 * labeled alternative in {@link MMMLParser#symbol}.
	 * @param ctx the parse tree
	 */
	void enterSymbol_rule(MMMLParser.Symbol_ruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code symbol_rule}
	 * labeled alternative in {@link MMMLParser#symbol}.
	 * @param ctx the parse tree
	 */
	void exitSymbol_rule(MMMLParser.Symbol_ruleContext ctx);
}