package javaeetutorial.isst.rest;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Error {
	private String id;
	private String description;

	
	public Error() {
		
	}
	
	public Error (String id, String description) {
		this.id = id;
		this.description = description;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setDescription(String des) {
		this.description = des;
	}
	
	public String getDescription() {
		return this.description;
	}
}
	