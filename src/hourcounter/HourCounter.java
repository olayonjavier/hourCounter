
package hourcounter;

import java.util.Scanner;

public class HourCounter {

	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter how many days worked: ");
		int days = input.nextInt();
		int minutes = 0;
		int totalHours = 0;
		int remainderMinutes = 0;
		
		for(int currentDay = 1; currentDay <= days; currentDay++){
			System.out.println("Enter minutes for day " + currentDay);
			minutes += input.nextInt();
		}	
		
		totalHours = minutes / 60;
		remainderMinutes = minutes % 60;
		
		System.out.println("Total Hours = " + totalHours + " " + remainderMinutes + " minutes");
	}
	
}
