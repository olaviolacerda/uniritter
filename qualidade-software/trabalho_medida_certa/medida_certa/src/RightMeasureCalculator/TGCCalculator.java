package RightMeasureCalculator;

import Person.Person;

public class TGCCalculator implements Calculator {

	private IMCCalculator imc;

	public TGCCalculator() {
		imc = new IMCCalculator();
	}

	public Double convertBigNumberToDecimalFormat(Double number) {
		return Math.floor(number * 100) / 100;
	}

	public Double calculate(Person person) {
		Double imcValue = imc.calculate(person);

		Double tgcValue = (1.2 * imcValue) - (10.8 * person.getGender().getGenderID()) + (0.23 * person.getAge()) - 5.4;

		return convertBigNumberToDecimalFormat(tgcValue);
	}

	public String evaluatePercentage(Double tgcValue) {
		return tgcValue + "%";
	}

	public TGCStatus getSituation(Person person) {
		Double tgcValue = calculate(person);

		return TGCStatus.returnSituation(tgcValue, person);

	}

}
