package isst.receta.web.managedbeans;

import isst.receta.ejb.MedRequestBean;
import isst.receta.entity.Farmaceutico;
import isst.receta.entity.Med;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("pagar")
@RequestScoped
public class Pagar extends AbstractBean implements Serializable{
	
	private static final long serialVersionUID = -152356766344479856L;
	
	@EJB
	private MedRequestBean medRequestBean;
	
	@Inject
	private Compra compra;
	
	@Inject
	private Farmaceutico farmaceutico;
	
	public Farmaceutico getFarmaceutico() {
		return farmaceutico;
	}

	public void setFarmaceutico(Farmaceutico farmaceutico) {
		this.farmaceutico = farmaceutico;
	}

	private String name;
	private String surname;
	private String card;
	private double importe;
	private double cambio;
	private double total;
	private String farma;
	private List<Med> listaAlmacen;
	private List<Med> listaCompra;
	
	public Pagar(){
		
	}
	
	public String getFarma() {
		return farma;
	}

	public void setFarma(String farma) {
		this.farma = farma;
	}

	public String pago(){
		total=compra.getTotal();
		if(importe<total){
			message(null,"No ha abonado el importe total");
			return ("pago");
		}		
		cambio=roundOff(importe-total);
		farma=farmaceutico.getName();
		
		return ("recibo");
		
	}
	
	public String finish() throws Exception{
	
		int actualizado=0;
		listaAlmacen=medRequestBean.getMeds();
		listaCompra=compra.getLista();
		//Comparamos la lista actual del almacen con la lista del recibo para saber cuales extraemos del almacen
		for (Med almacen : listaAlmacen) {
			for (Med item : listaCompra) {
				//En este caso coinciden y quitamos del almacen la cantidad comprada
				if(almacen.getMedId().equalsIgnoreCase(item.getMedId())){
					actualizado=almacen.getUnits()-item.getUnits();
					almacen.setUnits(actualizado);
					medRequestBean.update(almacen);					
				}
			}
			
		}
		
		compra.clear();
		return("index");
	}
	
	private double roundOff(double x) {
        long val = Math.round(x * 100); // cents

        return val / 100.0;
    }
	
	
	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public double getCambio() {
		return cambio;
	}

	public void setCambio(double cambio) {
		this.cambio = cambio;
	}

	
	
	public MedRequestBean getMedRequestBean() {
		return medRequestBean;
	}
	public void setMedRequestBean(MedRequestBean medRequestBean) {
		this.medRequestBean = medRequestBean;
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
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	

}
