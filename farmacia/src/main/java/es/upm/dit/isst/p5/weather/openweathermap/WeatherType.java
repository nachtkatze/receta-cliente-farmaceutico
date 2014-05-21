package es.upm.dit.isst.p5.weather.openweathermap;

import javax.xml.bind.annotation.XmlAttribute;

public class WeatherType {	
	
	@XmlAttribute(name="id") private int code;
	@XmlAttribute(name="main") private String name;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	
	public String toString() {
		return name;
	}

}
