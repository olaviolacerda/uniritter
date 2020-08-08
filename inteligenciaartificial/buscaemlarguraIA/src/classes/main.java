package classes;

import java.util.LinkedList;
import java.util.List;

public class main {

	public static void main(String[] args) {

		int[][] matriz;
		List<Integer> paths = new LinkedList();
		buscaemlargura aux3 = new buscaemlargura();
		Converte conteudo = new Converte();
		Converte aux = new Converte();
		Converte aux2 = new Converte();
		matriz = aux2.IntTransforma(aux.Criamatriz(conteudo.transforma("grafo.txt")));
		 paths = aux3.busca(matriz, 0, 4);

//		for (int i = 0; i < matriz[0].length; i++) {
//			for (int j = 0; j < matriz.length ; j++) {
//				System.out.print(matriz[i][j]);
//
//			}
//			System.out.println();
//		}
		 System.out.println(paths);
	}

}
