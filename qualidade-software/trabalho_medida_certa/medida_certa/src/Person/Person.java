package Person;

public class Person {

	
	private Gender gender;
	private Double height;
	private Double weight;
	private Integer age;
	
	public Person() {
	}
	
	public Person(Gender gender,Double weight, Double height) {
		this.gender = gender;
		this.height = height;
		this.weight = weight;
	}
	
	
	public Person(Gender gender,Double weight, Double height,Integer age) {
		this(gender,weight, height);
		this.age = age;
	}


	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}


	public Double getHeight() {
		return height;
	}


	public void setHeight(Double height) {
		this.height = height;
	}


	public Double getWeight() {
		return weight;
	}


	public void setWeight(Double weight) {
		this.weight = weight;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}
