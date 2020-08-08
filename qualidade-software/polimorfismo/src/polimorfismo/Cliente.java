package polimorfismo;

public class Cliente {
			
	public static void main(String[] args) {
		
		BancoDados bo = new BancoDados(new BDOracle());
		
		bo.conecta();
		
		BancoDados bp = new BancoDados (new BDPostgres());
		bp.conecta();
		
		
	}
}
