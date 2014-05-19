package isst.receta.web.managedbeans;

import isst.receta.ejb.MedRequestBean;
import isst.receta.entity.Med;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean(name="stock")
@SessionScoped
public class StockBean extends AbstractBean implements Serializable{
	private static final long serialVersionUID = -3594317405246398714L;

	private static Compra compra=new Compra();
    @EJB
    private MedRequestBean medRequestBean;


    public StockBean(){
    	
    	
    }
    
    
    //Añadimos un medicamento a la lista compra
    public String add(Med med) throws Exception{
    	
        //compra.add(med.getMedId(), med);
        System.out.println("La seleccionada es "+med.getName());
        message(null, "Añadida al recibo");
                
        	compra.add(med);    

        return null;
    }
    
    public List<Med> getMeds() {
        try {
            return medRequestBean.getMeds();
        } catch (Exception e) {
            throw new FacesException("Exception: " + e);
        }
    }

    public void removeUnit(Med med) throws Exception{
    	med.setUnits(med.getUnits()-1);
    	medRequestBean.update(med);
    }
    
	public MedRequestBean getMedRequestBean() {
		return medRequestBean;
	}


	public void setMedRequestBean(MedRequestBean medRequestBean) {
		this.medRequestBean = medRequestBean;
	}
	
	public void clean(){
		compra.clear();
	}

	public static Compra getCompra() {
		return compra;
	}

	public static void setCompra(Compra compra) {
		StockBean.compra = compra;
	}


    
    
}


