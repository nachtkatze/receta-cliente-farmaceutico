package es.upm.dit.isst.p5.weather.openweathermap;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WeatherReport {

	private City city;
	
	@XmlElement(name = "list")
	private List<Forecast> forecasts;

	public String toString() {
		StringBuffer toReturn = new StringBuffer();
		toReturn.append(city);
		toReturn.append(":\n");
		for(Forecast f: forecasts) {
			toReturn.append("\t");
			toReturn.append(f);
			toReturn.append("\n");
		}
		return toReturn.toString();
	}

	public List<Forecast> getHourly() {
		return forecasts;
	}

	public void setHourly(List<Forecast> hourly) {
		this.forecasts = hourly;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}
