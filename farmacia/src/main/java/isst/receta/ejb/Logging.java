package isst.receta.ejb;

import isst.receta.entity.Farmaceutico;
import java.util.logging.Logger;


import javax.ejb.EJBException;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateful
public class Logging {

	@PersistenceContext
	private EntityManager em;
	private static final Logger logger =
			Logger.getLogger("dukesbookstore.ejb.Logging");

	public Logging() throws Exception {

	}
	
	public Farmaceutico checkPassword(String userId,String password){
		try{
			Farmaceutico requestedFarmaceutico = em.find(Farmaceutico.class, userId);
			if(requestedFarmaceutico!=null){
				if(requestedFarmaceutico.getPassword().equalsIgnoreCase(password)){
								return requestedFarmaceutico;	        
				}
			}
	
	        return null;
			
		} catch (Exception ex) {
			throw new EJBException(ex.getMessage());
		}     

     }
	

}
