package Menu;

import java.util.Scanner;

public class CalculadoraMedidaCerta {
	static Scanner teclado = new Scanner(System.in);
	static MenuService menu = new MenuService();
	static Integer option = 1;
	
	public static void main(String[] args) {
		
		menu.geraMenu(option, teclado);	
	}
}
