package RightMeasureCalculator;

import Person.Person;

public enum IMCStatus {
	ABAIXO_DO_PESO, OBESO, IDEAL;

	private static Double[] limitsGender = { 19.1D, 20.7D, 25.8D, 26.4D };

	public static IMCStatus returnSituation(Double imcValue, Person person) {
		Integer genderID = person.getGender().getGenderID();

		if (imcValue < limitsGender[genderID]) {
			return ABAIXO_DO_PESO;
		} else if (imcValue > limitsGender[genderID + 2]) {
			return OBESO;
		} else {
			return IDEAL;
		}

	}
}
