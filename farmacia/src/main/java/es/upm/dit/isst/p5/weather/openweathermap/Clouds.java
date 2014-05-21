package es.upm.dit.isst.p5.weather.openweathermap;

import javax.xml.bind.annotation.XmlAttribute;

public class Clouds {
	@XmlAttribute(name="all") private int coverage;

	public int getCoverage() {
		return coverage;
	}

	public void setCoverage(int coverage) {
		this.coverage = coverage;
	}	
	
	public String toString() {
		return "clouds " + coverage + "%";
	}
	
}
