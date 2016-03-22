package com.testwithbuiltin;

import java.util.Observable;
import java.util.Observer;

import com.test.DisplayElement;

public class CurrentConditionsDisplay implements Observer, DisplayElement{
	Observable observable;
	private float temperature;
	private float humidity;
	
	
	public CurrentConditionsDisplay (Observable ob){
		this.observable=ob;
		observable.addObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println("Current conditions: "+ temperature+ "F degrees and "+humidity+ "% humidity");
		
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof WeatherData){
			WeatherData weatherData = (WeatherData)o;
			this.temperature=weatherData.getTemperature();
			this.humidity=weatherData.getHumidity();
			display();
		}
		
	}
	
}
