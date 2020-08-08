package Menu;

import java.util.Scanner;

import Person.Gender;
import Person.Person;
import RightMeasureCalculator.IMCCalculator;
import RightMeasureCalculator.PCalculator;
import RightMeasureCalculator.TGCCalculator;

public class MenuService {
	Person person = new Person();
	PCalculator pCalculator = new PCalculator();
	IMCCalculator imcCalculator = new IMCCalculator();
	TGCCalculator tgcCalculator = new TGCCalculator();
	Integer option;
	
	public void menuTitulo() {
		System.out.println("\n\n\n\n----------Bem-vindo ao Calculador de Medida Certa----------\n\n\n\n"
				+ "Para calcular o seu �ncice de gordura corporal (IMC), digite [1]. \n\n"
				+ "Para calcular a sua Taxa de Gordura Corporal (TGC), digite [2]. \n\n"
				+ "Para calcular o seu Peso Ideal, digite [3].\n\n" + "Para sair, digite [0]." + "\n\n"
				+ "\nDigite a op��o desejada: \n\n");

	}

	public Gender returnGender(Integer option) {
		if (option.equals(0))
			return Gender.FEMALE;
		else
			return Gender.MALE;
	}

	public void menuIMC(Scanner teclado) {
		System.out.println("C�lculo de IMC \n");
		System.out.println("Qual seu g�nero? Feminino [0] | Masculino [1]: \n");
		person.setGender(returnGender(teclado.nextInt()));
		System.out.println("Qual sua altura? Em metros, utilize ponto(.) no lugar da v�rgula: \n");
		person.setHeight(Double.parseDouble(teclado.next()));
		System.out.println("Qual o seu peso? \n");
		person.setWeight(Double.parseDouble(teclado.next()));
		System.out.println("Sua situa��o, baseada no IMC �: " + imcCalculator.getSituation(person));
	}

	public void menuTGC(Scanner teclado) {
		System.out.println("C�lculo de TGC \n");
		System.out.println("Qual seu g�nero? Feminino [0] | Masculino [1]: \n");
		person.setGender(returnGender(teclado.nextInt()));
		System.out.println("Qual a sua idade? \n");
		person.setAge(teclado.nextInt());
		System.out.println("Qual sua altura? Em metros, utilize ponto(.) no lugar da v�rgula: \n");
		person.setHeight(Double.parseDouble(teclado.next()));
		System.out.println("Qual o seu peso? \n");
		person.setWeight(Double.parseDouble(teclado.next()));
		System.out.println("Seu ind�ce de gordura �: " + tgcCalculator.getSituation(person));
	}

	public void menuP(Scanner teclado) {
		System.out.println("C�lculo de Peso Ideal \n");
		System.out.println("Qual seu g�nero? Feminino [0] | Masculino [1]: \n");
		person.setGender(returnGender(teclado.nextInt()));
		System.out.println("Qual sua altura? Em metros, utilize ponto(.) no lugar da v�rgula: \n");
		person.setHeight(Double.parseDouble(teclado.next()));
		System.out.println("Qual o seu peso? \n");
		person.setWeight(Double.parseDouble(teclado.next()));
		System.out.println("Seu peso ideal � de: " + pCalculator.getPesoIdeal(person));
	}

	public void geraMenu(Integer option, Scanner teclado) {
		
		while (!option.equals(0)) {
			menuTitulo();
			switch (teclado.nextInt()) {
			case 1:
				menuIMC(teclado);
				break;
			case 2:
				menuTGC(teclado);
				break;
			case 3:
				menuP(teclado);
				break;
			default:
				option = 0;
				System.out.println("At� logo!");
				System.exit(0);
				break;
			}
		}
	}

}
