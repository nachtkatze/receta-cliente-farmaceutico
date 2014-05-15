package isst.receta.ejb;

import isst.receta.entity.Farmaceutico;

import java.util.logging.Logger;

import javax.ejb.EJBException;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
public class FarmaceuticoRequestBean {

	@PersistenceContext
	private EntityManager em;
	private static final Logger logger =
			Logger.getLogger("dukesbookstore.ejb.FarmaceuticoRequestBean");
	
	public FarmaceuticoRequestBean() throws Exception {

	}

	public void createFarmaceutico(String farmaId, String name, String surname, String dni, String password){
		try{
			Farmaceutico farmaceutico = new Farmaceutico(farmaId,name,surname,dni,password);
			em.persist(farmaceutico);
		} catch (Exception ex) {
			throw new EJBException(ex.getMessage());
		}
	}
	
	

}
 