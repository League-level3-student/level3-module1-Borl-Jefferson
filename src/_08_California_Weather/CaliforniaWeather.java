package _08_California_Weather;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.StyledEditorKit.ForegroundAction;

/*
 * OBJECTIVE:
 * 1. Create a program that allows the user to search for the weather
 * conditions of a given city in California. Use the example program below
 * and the Utilities class inside this project to get the temperature data
 * from a day in December 2020.
 * Example: User: Encinitas
 *          Program: Encinitas is Overcast with a tempeature of 59.01 �F
 * 
 * 2. Create a way for the user to specify the weather condition and then
 * list the cities that have those conditions.
 * Example: User: Mostly Cloudy
 *          Program: Long Beach, Pomona, Oceanside, ...
 * 
 * 3. Create a way for the user to enter a minimum and maximum temperature
 * and then list the cities that have temperatures within that range
 * Example: User: minimum temperature �F = 65.0, max temperature �F = 70.0
 *          Program: Fortana, Glendale, Escondido, Del Mar, ...
 * 
 * EXTRA:
 * Feel free to add pictures for specific weather conditions or a thermometer
 * for the temperature. Also If you want your program to get the current day's
 * temperature, you can get a free API key at: https://openweathermap.org/api
 */

public class CaliforniaWeather implements ActionListener {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JTextField text = new JTextField();
        JButton jb1 = new JButton();
        JButton jb2 = new JButton();
        JButton jb3 = new JButton();
        Utilities utili = new Utilities();
        String min;
        String max;
       int counter3=0;
       int counter1=0;
       int counter2=0;
        HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();
    void start() {
        
    
        
        panel.add(text);
        panel.add(jb1);
        panel.add(jb2);
        panel.add(jb3);
        frame.add(panel);
        frame.pack();
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 240);
       jb1.setText("Search by name");
       jb2.setText("Search by weather");
       jb3.setText("Search by temperature (F)");
      text.setPreferredSize(new Dimension(115, 35));
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        // All city keys have the first letter capitalized of each word
     
        
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.jb1) {
			if(counter1==1) {
			   String cityName = Utilities.capitalizeWords( text.getText() );
        WeatherData datum = weatherData.get(cityName);
        
        if( datum == null ) {
            System.out.println("Unable to find weather data for: " + cityName);
        } else {
            System.out.println(cityName + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F");
        }
			counter1=0;
			}
        if(counter1==0) {
        	text.setText("Enter city name");
        	counter1++;
        }
			}
		
	/*
	 * Cities with City Weather weather: 
Clear
Cities with City Weather weather: 
Overcast
Cities with City Weather weather: 
Overcast
Cities with City Weather weather: 
Clear
Cities with City Weather weather: 
Mostly Cloudy	
	 */
		if(e.getSource() == this.jb2) {
			if(counter2 == 1) {
			String clist = "";
			 String cityName = Utilities.capitalizeWords( text.getText() );
			 WeatherData datum = weatherData.get(cityName);
			
		System.out.println("Cities with " + cityName + " weather:");
		        	for(String citynames : weatherData.keySet()) {
		        		if(weatherData.get(citynames).weatherSummary.equals(cityName)){
System.out.println(citynames);
		        	}
		        	}
		 
		        
			 counter2=0;
			}
			if(counter2 ==0) {
				text.setText("City Weather");
				counter2++;
			}
		}
		
		if(e.getSource() == this.jb3) {
			if(counter3 ==2) {
				max=text.getText();
				Double maxd=Double.parseDouble(max);
				Double mind=Double.parseDouble(min);
				System.out.println("Cities with temperatures between " + mind + " and " + maxd);
				for(String temps : weatherData.keySet()) {
					if(weatherData.get(temps).temperatureF < maxd && weatherData.get(temps).temperatureF > mind) {
					System.out.println(temps);
					}
					}
					
				
				counter3=0;
			}
			if(counter3 == 1) {
			min = text.getText();
			text.setText("Maximum temp");
			counter3++;
			}
			if(counter3==0) {
			text.setText("Minumum temp");
			counter3++;
		}
			
		}
		
	}
}
