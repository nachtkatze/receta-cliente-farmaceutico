package isst.receta.web.managedbeans;

import isst.receta.ejb.MedRequestBean;
import isst.receta.entity.Med;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


import javax.activation.DataSource;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

@ManagedBean(name="stock")
@SessionScoped
public class StockBean extends AbstractBean implements Serializable{
	private static final long serialVersionUID = -3594317405246398714L;
	
    @EJB
    private MedRequestBean medRequestBean;
    
//    private String name;
//    private String medId;
//    private String brand;
//    private double price;
//    private int units;


    public StockBean(){
    	
    }
    
    
    
    public List<Med> getMeds() {
        try {
            return medRequestBean.getMeds();
        } catch (Exception e) {
            throw new FacesException("Exception: " + e);
        }
    }


	public MedRequestBean getMedRequestBean() {
		return medRequestBean;
	}


	public void setMedRequestBean(MedRequestBean medRequestBean) {
		this.medRequestBean = medRequestBean;
	}


//	public String getName() {
//		return name;
//	}
//
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//
//	public String getMedId() {
//		return medId;
//	}
//
//
//	public void setMedId(String medId) {
//		this.medId = medId;
//	}
//
//
//	public String getBrand() {
//		return brand;
//	}
//
//
//	public void setBrand(String brand) {
//		this.brand = brand;
//	}
//
//
//	public double getPrice() {
//		return price;
//	}
//
//
//	public void setPrice(double price) {
//		this.price = price;
//	}
//
//
//	public int getUnits() {
//		return units;
//	}
//
//
//	public void setUnits(int units) {
//		this.units = units;
//	}


    
    
}


