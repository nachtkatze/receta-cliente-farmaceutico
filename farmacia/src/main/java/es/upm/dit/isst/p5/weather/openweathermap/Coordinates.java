package es.upm.dit.isst.p5.weather.openweathermap;

import javax.xml.bind.annotation.XmlAttribute;

public class Coordinates {

	@XmlAttribute(name="lon")
	private float longitude;
	@XmlAttribute(name="lat")
	private float latitude;
	
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	
	public String toString() {
		return  decToDms(Math.abs(longitude)) + ( longitude>0 ? "E" : "W") + " "
				+ decToDms(Math.abs(latitude)) + ( latitude>0 ? "N" : "S");
	}
	
	private static final String decToDms(float decimal) {
		return (int)decimal + "º" 
				+ (int)(decimal % 1.0f * 60) + "\'"
				+ (int)(decimal % 1.0f * 60 % 1.0f * 60) + "\"";
	}
}
