package javaeetutorial.dukesbookstore.entity;

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
@Table(name="CUSTOMERS")
public class Customer implements Serializable {

	
	private static final long serialVersionUID = -8063254025502891401L;
	@Id
	@NotNull
	private String userId;
	private String password;
	private String name;
	private String surname;
	private String creditCardNumber;
	private String language;
	
	public Customer(){}
	
	public Customer(String userId, String password, String name, String surname, String creditcard, String language) {
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.creditCardNumber = creditcard;
		this.language = language;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditcard) {
		this.creditCardNumber = creditcard;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	

}
