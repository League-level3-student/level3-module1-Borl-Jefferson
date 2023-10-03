package _07_Meeting_Scheduler;

import java.util.ArrayList;

public class MeetingScheduler {
    /*
     * Your task is to code a method to find a meeting time for two people
     * given their schedules.
     * 
     * Code the method below so that it returns a Schedule object that contains
     * all the times during the week that are in BOTH people's schedules. The
     * Schedule class is included in this package.
     * 
     * Example:
     * person1 availability - Monday at 9, Tuesday at 14, and Friday 10
     * person2 availability - Tuesday at 14, Friday 8, and Monday at 9
     * The returned HashMap should contain: Tuesday 14 and Monday 9
     * 
     * The returned Schedule object represents the times both people are
     * available for a meeting.
     * 
     * Time availability is always at the top of the hour, so 9:30 is not valid
     * Time availability always represents 1 hour
     * Assume both schedules are in the same time zones
     */
    public static Schedule getMutualAvailability(Schedule person1, Schedule person2) {
    	//al1: 6, 4, 3
    	//al2: 2, 6, 5
    	String day = "Monday";
    	String mo = "Monday";
    	String tu = "Tuesday";
    	String we = "Wednesday";
    	String th = "Thursday";
    	String fr = "Friday";
    	
    	
    	Schedule fin = new Schedule();
        ArrayList<Integer> monday = new ArrayList<Integer>();
    	for (int k = 1; k < 6; k++) {
			System.out.println(k);
		if(k==1) {day=mo;}
		if(k==2) {day=tu;}
		if(k==3) {day=we;}
		if(k==4) {day=th;}
		if(k==5) {day=fr;}
			
    	for (int i = 0; i < person1.getSchedule().get(day).size(); i++) {
    		for (int j = 0; j < person2.getSchedule().get(day).size(); j++) {

    		if(person1.getSchedule().get(day).get(i) == person2.getSchedule().get(day).get(j)) {
    			fin.addAvailability(day, j);
    		}
		}
    }
    	}
        
        return null;
    }
}
