package RightMeasureCalculator;

import Person.Person;

public class IMCCalculator implements Calculator {

	
	public Double calculate(Person person) {
		Double height = person.getHeight();
		Double weight = person.getWeight();
		Double imcValue = weight / Math.pow(height, 2);

		return convertBigNumberToDecimalFormat(imcValue);
	}

	public Double convertBigNumberToDecimalFormat(Double number) {
		return Math.floor(number * 100) / 100;
	}

	public IMCStatus getSituation(Person person) {
		Double imcValue = calculate(person);
		 		
		return IMCStatus.returnSituation(imcValue, person);
	}

}
