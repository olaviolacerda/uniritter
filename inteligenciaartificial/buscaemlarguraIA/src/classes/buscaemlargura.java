package classes;

import java.util.LinkedList;
import java.util.List;

public class buscaemlargura {
	
	private static List<Integer> goBack(int[] back, int e, int s) {
		List<Integer> shortest = new LinkedList();
		int node = e;
		while (node != s) {
		    shortest.add(0, node);
		    node = back[node];
		}
		shortest.add(0, s);
		return shortest;
	}
	
	public List<Integer> busca(int[][] matriz, int s,int e) {
		boolean[] pass = new boolean[matriz.length]; 
		
		List<Integer> paths = new LinkedList();
		int[] back = new int[matriz.length];
		
		pass[s] = true;
		paths.add(0, s); 
		while (paths.isEmpty() == false) {
			int element = paths.get(0); 
			int node = paths.remove(0);
			if (element == e) { 
				return goBack(back, e, s);
			} else {
				for (int i = 0; i < matriz.length; i++) {
					
					if (pass[i] == false && matriz[node][i] == 1) {
						pass[i] = true;
						paths.add(0, i);
						back[i] = node;
					}
					
				}
				
			}
			
			
		}
		return null;
	}
}
