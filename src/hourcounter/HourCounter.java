
package hourcounter;

import java.util.Scanner;

public class HourCounter {

	static Scanner input = new Scanner(System.in);
	static final int MIN_IN_HOUR = 60;
	static final int MAX_HOURS = 20;
	
	public static void main(String[] args) {
		
		System.out.println("Enter how many days worked: ");
		int days = input.nextInt();
		int minutes = 0;
		int remainderMinutes = 0;
		
		for(int currentDay = 1; currentDay <= days; currentDay++){
			System.out.println("Enter minutes for day " + currentDay);
			minutes += getMinutes();
		}	
		
		remainderMinutes = getRemainderMinutes(minutes);
		
		System.out.println("Total Time Worked = " + convertMinutesToHours(minutes) + " hours and " + remainderMinutes + " minutes");
		System.out.println("Remaining Hours = " + getMissingHours(minutes) + " hours and " + getMissingMinutes(remainderMinutes) + " minutes");
	}
	
	public static int getMinutes(){
		return input.nextInt();
	}
	
	public static int convertMinutesToHours(int totalMinutes){
		return totalMinutes / MIN_IN_HOUR;
	}
	
	public static int getRemainderMinutes(int totalMinutes){
		return totalMinutes % MIN_IN_HOUR;
	}
	
	public static int getMissingHours(int minutes){
		int missingMinutes = (MAX_HOURS * MIN_IN_HOUR) - minutes;
		
		return convertMinutesToHours(missingMinutes);
	}
	
	public static int getMissingMinutes(int remainderMinutes){
		return MIN_IN_HOUR - remainderMinutes;
	}
	
	
}
