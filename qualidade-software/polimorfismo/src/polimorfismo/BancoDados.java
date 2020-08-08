package polimorfismo;

public class BancoDados {
	private TipoBD tipo;
	
	public BancoDados(TipoBD tipo) {
		this.tipo = tipo;
	}
	

	public void conecta() {
		tipo.conecta();
	}
}
