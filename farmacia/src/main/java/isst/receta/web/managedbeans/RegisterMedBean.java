package isst.receta.web.managedbeans;

import isst.receta.ejb.MedRequestBean;
import isst.receta.entity.Med;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class RegisterMedBean extends AbstractBean {

	private static final long serialVersionUID = -2633611967469166418L;

	@EJB
	private MedRequestBean medRequestBean;

	
	@Inject
	private Med med;
	
	public String submit() {
		medRequestBean.createMed(med.getMedId(), med.getName(),med.getBrand(),med.getPrice());
		message(null,"Introducido con exito");
		return ("index");
	}

	public MedRequestBean getMedRequestBean() {
		return medRequestBean;
	}

	public void setMedRequestBean(MedRequestBean medRequestBean) {
		this.medRequestBean = medRequestBean;
	}

	public Med getMed() {
		return med;
	}

	public void setMed(Med med) {
		this.med = med;
	}
	
	
}
	