package _09_World_Clocks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.text.StyledEditorKit.ForegroundAction;

/*
 * You task is to create a java program that:
 * 1. Displays the time for multiple cities around the world on one display.
 * 2. Gives the user the ability to add a city to the display. One possible
 *    way to do this is to create a HashMap of city names and their
 *    corresponding time zones, e.g. HashMap<String, TimeZone>, then use each
 *    city's TimeZone to get the current date/time every second using a
 *    Timer object (see example code below).
 * 
 * The code below is an example of how to print out a clock for San Diego.
 * Use the ClockUtilities class to find the time zone of each city, then use
 * Calendar.getInstance to return a Calendar object to get the current time for
 * that city. Example:
 *   TimeZone timeZone = clockUtil.getTimeZoneFromCityName("San Diego, US");
 *   Calendar c = Calendar.getInstance(timeZone);
 *   System.out.println("Full date and time: " + calendar.getTime());
 * 
 * NOTE: The program may take a second or two to execute
 * 
 * Calendar class:
 * https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html
 */

public class WorldClocks implements ActionListener {
	
	  ArrayList<String> time = new ArrayList<String>();
	  ArrayList<String> names = new ArrayList<String>();
	  ArrayList<TimeZone> io = new ArrayList<TimeZone>();
    ClockUtilities clockUtil;
    Timer timer;
    TimeZone timeZone;

    JFrame frame;
    JPanel panel;
    JTextArea textArea;
    String addtimestr = "";
    String city;
    String dateStr = "";
    String timeStr;
    String finalcity = "";
    String ogcity = "";
    int counter=0;
    String dis = "";
    public WorldClocks() {
        clockUtil = new ClockUtilities();
	for (int i = 0; i < 100; i++) {
        // The format for the city must be: city, country (all caps)
        city = JOptionPane.showInputDialog("Enter a city name \n The format for the city must be: city, country (all caps)");
        timeZone = clockUtil.getTimeZoneFromCityName(city);
        names.add(city);
        io.add(timeZone);
       // io.set(names.size(), timeZone);
        ogcity=city;
        finalcity += city + "\n";
city = finalcity;
        String month = "";
        String dayOfWeek = "";
        String timeStr = "";
        Calendar calendar = Calendar.getInstance(timeZone);
         month += calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
         dayOfWeek +=  calendar.getDisplayName( Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
        dateStr += dayOfWeek + " " + month + " " + calendar.get(Calendar.DAY_OF_MONTH) + " " + calendar.get(Calendar.YEAR) + "\n";
        
        System.out.println(dateStr);
if(counter==0) {
        // Sample starter program
        frame = new JFrame();
        panel = new JPanel();
        textArea = new JTextArea();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(100, 100);
        frame.add(panel);
        panel.add(textArea);
       // textArea.setText("g"/*finalcity*/ /*+ "\n"*/ + dateStr);
        
        // This Timer object is set to call the actionPerformed() method every
        // 1000 milliseconds
        timer = new Timer(1000, this);
        timer.start();
        counter++;
}
    }
	}
    @Override
    public void actionPerformed(ActionEvent arg0) {
     /*   Calendar c = Calendar.getInstance(timeZone);
        String militaryTime = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
        String twelveHourTime = " [" + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND) + "]";
        
        */
         dis="";
       for (int i = 0; i < names.size(); i++) {
        //	timeZone = clockUtil.getTimeZoneFromCityName(names.get(i));
        	Calendar c = Calendar.getInstance(io.get(i));
        	String militaryTime = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
            String twelveHourTime = " [" + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND) + "]";
		timeStr =names.get(i) + ": " + militaryTime + twelveHourTime;
        addtimestr += timeStr + "\n";
        time.add("g");
        
        time.set(i, names.get(i) + "\n" + dateStr + "\n" + addtimestr);
        
        dis += time.get(i) + "\n";
        addtimestr="";
        System.out.println(timeStr);
        time.clear();
        }
       // timeStr =ogcity + ": " + militaryTime + twelveHourTime;
      //  System.out.println(timeStr);
        //textArea.setText(city + "\n" + dateStr + "\n" + addtimestr);
        textArea.setText(dis);
        frame.pack();
    }
}
