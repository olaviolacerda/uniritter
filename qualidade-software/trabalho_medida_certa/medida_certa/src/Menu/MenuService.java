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
				+ "Para calcular o seu íncice de gordura corporal (IMC), digite [1]. \n\n"
				+ "Para calcular a sua Taxa de Gordura Corporal (TGC), digite [2]. \n\n"
				+ "Para calcular o seu Peso Ideal, digite [3].\n\n" + "Para sair, digite [0]." + "\n\n"
				+ "\nDigite a opção desejada: \n\n");

	}

	public Gender returnGender(Integer option) {
		if (option.equals(0))
			return Gender.FEMALE;
		else
			return Gender.MALE;
	}

	public void menuIMC(Scanner teclado) {
		System.out.println("Cálculo de IMC \n");
		System.out.println("Qual seu gênero? Feminino [0] | Masculino [1]: \n");
		person.setGender(returnGender(teclado.nextInt()));
		System.out.println("Qual sua altura? Em metros, utilize ponto(.) no lugar da vírgula: \n");
		person.setHeight(Double.parseDouble(teclado.next()));
		System.out.println("Qual o seu peso? \n");
		person.setWeight(Double.parseDouble(teclado.next()));
		System.out.println("Sua situação, baseada no IMC é: " + imcCalculator.getSituation(person));
	}

	public void menuTGC(Scanner teclado) {
		System.out.println("Cálculo de TGC \n");
		System.out.println("Qual seu gênero? Feminino [0] | Masculino [1]: \n");
		person.setGender(returnGender(teclado.nextInt()));
		System.out.println("Qual a sua idade? \n");
		person.setAge(teclado.nextInt());
		System.out.println("Qual sua altura? Em metros, utilize ponto(.) no lugar da vírgula: \n");
		person.setHeight(Double.parseDouble(teclado.next()));
		System.out.println("Qual o seu peso? \n");
		person.setWeight(Double.parseDouble(teclado.next()));
		System.out.println("Seu indíce de gordura é: " + tgcCalculator.getSituation(person));
	}

	public void menuP(Scanner teclado) {
		System.out.println("Cálculo de Peso Ideal \n");
		System.out.println("Qual seu gênero? Feminino [0] | Masculino [1]: \n");
		person.setGender(returnGender(teclado.nextInt()));
		System.out.println("Qual sua altura? Em metros, utilize ponto(.) no lugar da vírgula: \n");
		person.setHeight(Double.parseDouble(teclado.next()));
		System.out.println("Qual o seu peso? \n");
		person.setWeight(Double.parseDouble(teclado.next()));
		System.out.println("Seu peso ideal é de: " + pCalculator.getPesoIdeal(person));
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
				System.out.println("Até logo!");
				System.exit(0);
				break;
			}
		}
	}

}
