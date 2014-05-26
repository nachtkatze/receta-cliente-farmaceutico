package isst.receta.web.managedbeans;


import isst.receta.ejb.FarmaceuticoRequestBean;
import isst.receta.entity.Farmaceutico;
import isst.receta.converters.Password;

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
	@Inject
	private LocaleBean localeBean;
	
	private String admin="Admin";
	
	private String passRepeat;
	
	
	public String getPassRepeat() {
		return passRepeat;
	}

	public void setPassRepeat(String passRepeat) {
		this.passRepeat = passRepeat;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String submit() throws Exception{
			if(farmaceutico.getPassword().equalsIgnoreCase(passRepeat)==false){
			message(null,"Lascontraseñasnocoinciden");
			return("register");
		}
		if(farmaceuticoRequestBean.checkId(farmaceutico.getFarmaId())!=null){
			message(null,"Eseidentificadoryaseencuentraenuso");
			return("register");
		}
		if(farmaceuticoRequestBean.checkDNI(farmaceutico.getDni())!=null){
			message(null,"EseDNIyaseencuentraregistrado");
			return("register");
		}
		
		String passwordCifrada=Password.cifrar(farmaceutico.getPassword());
		farmaceuticoRequestBean.createFarmaceutico(farmaceutico.getFarmaId(), 
				farmaceutico.getName(), farmaceutico.getSurname(), farmaceutico.getDni(),
				passwordCifrada);
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