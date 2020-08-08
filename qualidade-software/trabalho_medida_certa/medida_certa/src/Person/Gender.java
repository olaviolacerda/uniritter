package Person;

public enum Gender {
	FEMALE(0), MALE(1);
	
	private int genderID;
	
	Gender(int genderID){
		this.genderID = genderID;
	}
	
	public int getGenderID() {
		return this.genderID;
	}
	
	public static Gender returnGender(Integer option) {
		if(option.equals(0))
			return FEMALE;
		else
			return MALE;
	}
}


