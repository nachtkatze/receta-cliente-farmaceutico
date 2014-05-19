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
	private Farmaceutico farmaceutico;
	
	public String enter() throws Exception{
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
	
}
