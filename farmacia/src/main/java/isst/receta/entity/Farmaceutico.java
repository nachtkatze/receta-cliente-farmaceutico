package isst.receta.entity;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Named
@SessionScoped
@Entity
@Table(name="FARMACEUTICOS")
public class Farmaceutico implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2466559573300736525L;
	@Id
	@NotNull
	private String farmaId;
	private String name;
	private String surname;
	private String dni;
	private String password;
	
	public Farmaceutico(){
	
	}
	public Farmaceutico(String farmaId, String name, String surname,
			String dni, String password) {
		this.farmaId = farmaId;
		this.name = name;
		this.surname = surname;
		this.dni = dni;
		this.password = password;
	}
	public String getFarmaId() {
		return farmaId;
	}
	public void setFarmaId(String farmaId) {
		this.farmaId = farmaId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
}
