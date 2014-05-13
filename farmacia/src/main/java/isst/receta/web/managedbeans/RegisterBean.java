package isst.receta.web.managedbeans;

import isst.receta.ejb.FarmaceuticoRequestBean;
import isst.receta.entity.Farmaceutico;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class RegisterBean extends AbstractBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1591816766344479856L;

	@EJB
	private FarmaceuticoRequestBean farmaceuticoRequestBean;
	@Inject
	private Farmaceutico farmaceutico;
	
	public String submit(){
		farmaceuticoRequestBean.createFarmaceutico(farmaceutico.getFarmaId(), 
				farmaceutico.getName(), farmaceutico.getSurname(), farmaceutico.getDni(),
				farmaceutico.getPassword());
		return("index");
		
	}

	public FarmaceuticoRequestBean getFarmaceuticoRequestBean() {
		return farmaceuticoRequestBean;
	}

	public void setFarmaceuticoRequestBean(
			FarmaceuticoRequestBean farmaceuticoRequestBean) {
		this.farmaceuticoRequestBean = farmaceuticoRequestBean;
	}

	public Farmaceutico getFarmaceutico() {
		return farmaceutico;
	}

	public void setFarmaceutico(Farmaceutico farmaceutico) {
		this.farmaceutico = farmaceutico;
	}
	
}