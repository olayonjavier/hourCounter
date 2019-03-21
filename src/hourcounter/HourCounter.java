
package hourcounter;

import java.util.Scanner;

public class HourCounter {

	static Scanner input = new Scanner(System.in);
	static final int MIN_IN_HOUR = 60;
	static final int MAX_HOURS20 = 20;
	static final int MAX_HOURS30 = 30;
	
	public static void main(String[] args) {
		
        String format = setTimeFormat();
		
        int hours = 0;
        int minutes = 0;
        int remainderMinutes = 0;
		
        while(format.equals("h") || format.equals("m")){
		
			if(format.equals("h")){
				int days = setDaysWorked();
				for(int currentDay = 1; currentDay <= days; currentDay++){
					System.out.println("Enter hours for day " + currentDay);
					hours += getHours();
					System.out.println("Enter minutes for day " + currentDay);
					minutes += getMinutes();
				}
				hours += convertMinutesToHours(minutes);
				remainderMinutes = getRemainderMinutes(minutes);
			
				System.out.println("Total Time Worked = " + hours + " hours and " + remainderMinutes + " minutes");
				System.out.println("Remaining Hours = " + getMissingHours((convertHoursToMinutes(hours) + remainderMinutes), "") + " hours and " + getMissingMinutes(remainderMinutes) + " minutes");
				format = "exit";
			}
			else if(format.equals("m")){
				int days = setDaysWorked();
				for(int currentDay = 1; currentDay <= days; currentDay++){
					System.out.println("Enter minutes for day " + currentDay);
					minutes += getMinutes();
				}	
		
				remainderMinutes = getRemainderMinutes(minutes);
		
				System.out.println("Total Time Worked = " + convertMinutesToHours(minutes) + " hours and " + remainderMinutes + " minutes");
				System.out.println("Remaining Hours = " + getMissingHours(minutes, "") + " hours and " + getMissingMinutes(remainderMinutes) + " minutes");
				format = "exit";
			}
		
        }
	}
	
	
	
	public static int setDaysWorked(){
		System.out.println("Enter how many days worked: ");
		return input.nextInt();
	}
	
	public static String setTimeFormat(){
		System.out.println("If you'd like to enter hours worked enter 'h' else enter 'm' for minutes worked.");
		return input.next();
	}
	
	public static int getMinutes(){
		return input.nextInt();
	}
	
	public static int getHours(){
		return input.nextInt();
	}
	
	public static int convertMinutesToHours(int totalMinutes){
		return totalMinutes / MIN_IN_HOUR;
	}
	
	public static int convertHoursToMinutes(int totalHours){
		return totalHours * MIN_IN_HOUR;
	}
	
	public static int getRemainderMinutes(int totalMinutes){
		return totalMinutes % MIN_IN_HOUR;
	}
	
	public static int getMissingHours(int minutes, String workWeek){
		int missingMinutes = 0;
		if(workWeek.equals("20")){
			missingMinutes = (MAX_HOURS20 * MIN_IN_HOUR) - minutes;
		}
		else if(workWeek.equals("30")){
			missingMinutes = (MAX_HOURS30 * MIN_IN_HOUR) - minutes;
		}
		else{
			missingMinutes = 0;
		}
		
		return convertMinutesToHours(missingMinutes);
	}
	
	public static int getMissingMinutes(int remainderMinutes){
		if(remainderMinutes == 0){
			return 0;
		}
		return MIN_IN_HOUR - remainderMinutes;
	}
	
}
