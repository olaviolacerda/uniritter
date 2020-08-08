package RightMeasureCalculator;

import java.util.HashMap;

import Person.Person;

public enum TGCStatus {
	FORA_DA_FAIXA, IDEAL, ACEITAVEL;

	private static HashMap<Integer, Double[]> consultTable = new HashMap<Integer,Double[]>();
	
	private static void fillTable() {
		consultTable.put(1, new Double[] { 16D, 9D, 18D, 13D });
		consultTable.put(2, new Double[] { 18D, 12.5D, 20D, 16.5D });
		consultTable.put(3, new Double[] { 18.5D, 15D, 23.5D, 19D });
		consultTable.put(4, new Double[] { 21.5D, 16.5D, 36.5D, 20.5D });
		consultTable.put(5, new Double[] { 22.5D, 16.5D, 27.5D, 20.5D });
	}
	
	public static TGCStatus returnSituation(Double tgcValue, Person person) {
		fillTable();
		Integer age = person.getAge();
		Integer genderID = person.getGender().getGenderID();

		if (tgcValue < consultTable.get(getKeyValue(age))[genderID]) {
			return IDEAL;
		} else if (tgcValue > consultTable.get(getKeyValue(age))[genderID + 2]) {
			return FORA_DA_FAIXA;
		} else {
			return ACEITAVEL;
		}
		
	}

	private static Integer getKeyValue(Integer age) {
		if (age < 30) {
			return 1;
		} else if (age > 60) {
			return 5;
		} else {
			return (age / 10) - 1;
		}
	}

}
