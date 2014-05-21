package es.upm.dit.isst.p5.weather.openweathermap;

import javax.xml.bind.annotation.XmlAttribute;

public class Wind {
	
	@XmlAttribute(name="speed")
	private float speed;
	@XmlAttribute(name="deg")
	private float direction;

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	public float getDirection() {
		return direction;
	}
	public void setDirection(float direction) {
		this.direction = direction;
	}
	
	public String toString() {
		return "wind " + speed +"m/s " + Math.round(direction)%360 +"º";
	}

}
