package es.upm.dit.isst.p5.weather.openweathermap;

import javax.xml.bind.annotation.XmlAttribute;

public class Rain {
	
	@XmlAttribute(name="3h")
	private float precipitation;

	public float getPrecipitation() {
		return precipitation;
	}

	public void setPrecipitation(float precipitation) {
		this.precipitation = precipitation;
	}
	
	public String toString() {
		return "rain " + precipitation + "mm/3h";
	}

}
