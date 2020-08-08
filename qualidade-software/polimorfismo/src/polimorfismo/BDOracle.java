package polimorfismo;

public class BDOracle  implements TipoBD{
	
	@Override
	public void conecta(){
		System.out.println("Conectado ao Oracle.");
	}
	
}
