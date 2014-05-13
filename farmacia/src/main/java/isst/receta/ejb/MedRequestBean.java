package isst.receta.ejb;

import java.util.logging.Logger;

import isst.receta.entity.Med;

import javax.ejb.EJBException;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateful
public class MedRequestBean {

	@PersistenceContext
	private EntityManager em;
	private static final Logger logger =
			Logger.getLogger("isst.receta.ejb.MedRequestBean");

	public MedRequestBean() throws Exception {

	}

	public void createMed(String medId,String name, String brand, double price){
		try{
			Med med = new Med(medId,name,brand,price);
			em.persist(med);
		} catch (Exception ex) {
			throw new EJBException(ex.getMessage());
		}
	}

}

