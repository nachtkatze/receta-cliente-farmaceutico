package isst.receta.web.managedbeans;

import isst.receta.ejb.FarmaceuticoRequestBean;
import isst.receta.ejb.Logging;
import isst.receta.entity.Farmaceutico;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;


@Named("logMe")
@RequestScoped
public class LoggerBean extends AbstractBean implements Serializable {

	private static final long serialVersionUID = -5633644967469166418L;

	@EJB
	private Logging logging;
	
	
	@Inject
	private Farmaceutico Farmaceutico;
	
	public String enter() {
		Farmaceutico buscado=logging.checkPassword(Farmaceutico.getFarmaId(), Farmaceutico.getPassword());
		if(buscado!=null){
			Farmaceutico=buscado;
			return ("index");
		}
		
		message(null, "Match");
		Farmaceutico.setFarmaId(null);
		return ("login");
	}
	
	public String logOut(){
		System.out.println(Farmaceutico.getFarmaId());
		Farmaceutico.setFarmaId(null);
		System.out.println("AHora es" + Farmaceutico.getFarmaId());
		
		return ("index");
	}
	
}
