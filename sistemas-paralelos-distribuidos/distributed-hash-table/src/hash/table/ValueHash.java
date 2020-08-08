package hash.table;

import java.io.Serializable;

public class ValueHash implements Serializable {

	private static final long serialVersionUID = -1373603233114423576L;

	private String valor;
	private Integer versao = 0;

	public ValueHash() {}

	public ValueHash(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return this.valor;
	}
	
	public Integer getVersao() {
		return this.versao;
	}
	
	public void setVersao(Integer valor){
		this.versao = valor;
	}
}	
