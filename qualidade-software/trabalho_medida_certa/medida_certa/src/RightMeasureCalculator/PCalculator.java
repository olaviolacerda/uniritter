package RightMeasureCalculator;

import Person.Person;

public class PCalculator {
	
	
	public Double calculate(Person person) {
		Double height = person.getHeight() * 100;
		
		Integer k = (person.getGender().getGenderID() * 2) + 2;
		
		return ((height-100D) - ((height - 150D) / k));
	}
	
	public String getPesoIdeal(Person person) {
		Double pValue = calculate(person);
		
		return pValue + "KG";
	}
	
}