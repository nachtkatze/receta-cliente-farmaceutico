package isst.receta.entity;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="MEDICAMENTOS")
@NamedQuery(
       name = "findMeds",
       query = "SELECT b FROM Med b ORDER BY b.medId")
public class Med implements Serializable {

	
	private static final long serialVersionUID = -8063254025502891401L;
	@Id
	@NotNull
	private String medId;
	private String brand;
	private String name;
	private double price;
	private int units;



	public Med(){}
	
	public Med(String medId, String name, String brand, double price,int units) {
		this.medId = medId;
		this.name = name;
		this.brand = brand;
		this.price=price;
		this.units=units;

	}

	public String getMedId() {
		return medId;
	}

	public void setMedId(String medId) {
		this.medId = medId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}
	
}
