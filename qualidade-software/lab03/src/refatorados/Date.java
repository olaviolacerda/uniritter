package refatorados;

public class Date {
	private int month;
	private int day;
	private int year;

	public Date(int theDay, int theMonth, int theYear) {
		month = checkMonth(theMonth);
		year = theYear;
		day = checkDay(theDay);
	}

	private int checkMonth(int testMonth) {
		if (testMonth > 0 && testMonth <= 12)
			return testMonth;
		else
			return 1;
	}
	
	private boolean isFebruary(){
		return month == 2;
	}
	
	private int checkDay(int testDay) {
		
		if (testDay > 0 && testDaysPerMonth(testDay))
			return testDay;

		if (testDay == 29 && isFebruary() && isLeapYear())
			return testDay;

		return 1;
	}

	private boolean isLeapYear() {
		if (year % 4 == 0 && year % 100 != 0)
			return true;
		else if (year % 400 == 0)
			return true;
		else
			return false;
	}

	private boolean testDaysPerMonth(int testDay){
		int[] daysPerMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		return testDay <= daysPerMonth[month];
	}
	
	public String toString() {
		return String.format("%d/%d/%d", day, month, year);
	}
	

}
