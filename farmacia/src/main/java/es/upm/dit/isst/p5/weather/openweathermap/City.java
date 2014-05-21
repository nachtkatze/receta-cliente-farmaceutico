package es.upm.dit.isst.p5.weather.openweathermap;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class City {
	
	@XmlAttribute(name="name") private String name;
	@XmlAttribute(name="country") private String countryCode;
	@XmlElement(name="coord") private Coordinates coordinates;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountry(String countryCode) {
		this.countryCode = countryCode;
	}
	public Coordinates getCoord() {
		return coordinates;
	}
	public void setCoord(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	
	public String toString() {
		return name 
				+ ( countryCode != null ? "," + countryCode : "") 
				+ " (" + coordinates + ")";
	}

}
