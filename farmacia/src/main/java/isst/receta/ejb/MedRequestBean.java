package isst.receta.ejb;

import java.util.List;
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

	public void createMed(String medId,String name, String brand, double price,int units){
		try{
			Med med = new Med(medId,name,brand,price,units);
			em.persist(med);
		} catch (Exception ex) {
			throw new EJBException(ex.getMessage());
		}
	}
	public List<Med> getMeds() throws Exception {
        try {
            return (List<Med>) em.createNamedQuery("findMeds").getResultList();
        } catch (Exception ex) {
            throw new Exception(
                    "Could not get meds: " + ex.getMessage());
        }
    }

    public Med getMed(String medId){
        Med requestedMed = em.find(Med.class, medId);

        return requestedMed;
    }
    
    public void update(Med med) {
    	try {
    		em.merge(med);
    	} catch (Exception ex) {
    		throw new EJBException(ex.getMessage());
    	}
    }
    
    

}

