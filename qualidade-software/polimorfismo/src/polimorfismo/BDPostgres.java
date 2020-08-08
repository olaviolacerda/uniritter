package polimorfismo;

public class BDPostgres  implements TipoBD{
	
	@Override
	public void conecta(){
		System.out.println("Conectado ao Postgres.");
	}
}
