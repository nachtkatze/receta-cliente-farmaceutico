package isst.receta.web.managedbeans;

import isst.receta.ejb.MedRequestBean;
import isst.receta.entity.Med;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("regMed")
@RequestScoped
public class RegisterMedBean extends AbstractBean {

	private static final long serialVersionUID = -2633611967469166418L;

	@EJB
	private MedRequestBean medRequestBean;
	
	private String medId;
	private String name;
	private String brand;
	private double price;
	private int units;
	
	public String submit(){

		if(medRequestBean.getMed(medId)!=null){
			Med buscado=medRequestBean.getMed(medId);
			//Si ya se encuentra registrado,simplemente añadimos más unidades
			buscado.setUnits(buscado.getUnits()+units);
			System.out.println("Las unidades son"+ buscado.getUnits());
			medRequestBean.update(buscado);
			message(null,"Stockactualizado");
			return("index");
		}
		medRequestBean.createMed(medId, name,brand,price,units);
		message(null,"Introducidoconexito");
		return ("index");
		
	}

	public MedRequestBean getMedRequestBean() {
		return medRequestBean;
	}

	public void setMedRequestBean(MedRequestBean medRequestBean) {
		this.medRequestBean = medRequestBean;
	}

	public String getMedId() {
		return medId;
	}

	public void setMedId(String medId) {
		this.medId = medId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
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
	