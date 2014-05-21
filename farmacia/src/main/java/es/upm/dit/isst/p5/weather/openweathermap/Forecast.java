package es.upm.dit.isst.p5.weather.openweathermap;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Forecast {

	@XmlAttribute(name = "dt_txt")
	private String dateTime;
	// private int dt;
	private Clouds clouds;
	private Wind wind;
	
//	@XmlElement(name = "weather")
	private WeatherType weather;
	
	private Rain rain;
	
	@XmlElement(name = "main")
	private WeatherData data;

	public String toString() {
		return dateTime + " " + getWeather() + " -- " + clouds + ", " + wind + ", " 
				+ ( rain != null? rain : "no rain")
				+ ", " + data;
	}

	// public int getDt() {
	// return dt;
	// }
	// public void setDt(int dt) {
	// this.dt = dt;
	// }

	public String getDateTime() {
		return dateTime;
	}

	public void setDt_txt(String dateTime) {
		this.dateTime = dateTime;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public Clouds getClouds() {
		return clouds;
	}

	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}

	public Rain getRain() {
		return rain;
	}

	public void setRain(Rain rain) {
		this.rain = rain;
	}

	public WeatherData getData() {
		return data;
	}

	public void setData(WeatherData data) {
		this.data = data;
	}

	public WeatherType getWeather() {
		return weather;
	}

	public void setWeather(WeatherType weather) {
		this.weather = weather;
	}

}