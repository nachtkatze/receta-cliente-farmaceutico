package isst.receta.web.managedbeans;

import isst.receta.converters.Password;
import isst.receta.ejb.Logging;
import isst.receta.entity.Farmaceutico;

import java.io.IOException;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;


@Named("logMe")
@RequestScoped
public class LoggerBean extends AbstractBean implements Serializable {

	private static final long serialVersionUID = -5633644967469166418L;

	@EJB
	private Logging logging;
	
	@Inject
	private LocaleBean localeBean;
	
	@Inject
	private Farmaceutico farmaceutico;
	
	public String enter() throws Exception{
		localeBean.setLanguage("es");
		System.out.println(localeBean.getLocale().getDisplayLanguage());
		String passwordCifrada=Password.cifrar(farmaceutico.getPassword());
		Farmaceutico buscado=logging.checkPassword(farmaceutico.getFarmaId(), passwordCifrada);
		if(buscado!=null){
			farmaceutico.setName(buscado.getName());
			return ("index");
		}
		
		message(null, "Match");
		farmaceutico.setFarmaId(null);
		return ("login");
	}
	
	public String logOut(){
		ExternalContext ec=FacesContext.getCurrentInstance().getExternalContext();
		ec.invalidateSession();
		return ("login");
		
	}

	public LocaleBean getLocaleBean() {
		return localeBean;
	}

	public void setLocaleBean(LocaleBean localeBean) {
		this.localeBean = localeBean;
	}

	public Logging getLogging() {
		return logging;
	}

	public void setLogging(Logging logging) {
		this.logging = logging;
	}

	public Farmaceutico getFarmaceutico() {
		return farmaceutico;
	}

	public void setFarmaceutico(Farmaceutico farmaceutico) {
		this.farmaceutico = farmaceutico;
	}
	
	
	
}
