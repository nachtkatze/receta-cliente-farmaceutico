package es.upm.dit.isst.p5.weather.openweathermap;

public class WeatherData {
	
	private float temp, temp_min, temp_max, pressure, humidity;

	public float getTemp() {
		return temp;
	}

	public void setTemp(float temp) {
		this.temp = temp;
	}

	public float getTemp_min() {
		return temp_min;
	}

	public void setTemp_min(float temp_min) {
		this.temp_min = temp_min;
	}

	public float getTemp_max() {
		return temp_max;
	}

	public void setTemp_max(float temp_max) {
		this.temp_max = temp_max;
	}

	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}
	
	public String toString() {
		return temp + "ºC" + " (" + temp_min + "/" + temp_max + "ºC" + "), " 
				+ pressure + "hPa, " 
				+ "humidity " + humidity + "%";
	}
	
	

}
