package javaeetutorial.isst.ejb;

import java.util.logging.Logger;

import javaeetutorial.isst.entity.Customer;
import javaeetutorial.isst.exception.CustomerAuthenticationException;
import javaeetutorial.isst.exception.CustomerNotFoundException;

import javax.ejb.EJBException;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateful
public class CustomerRequestBean {

	@PersistenceContext
	private EntityManager em;
	private static final Logger logger =
			Logger.getLogger("isst.ejb.CustomerRequestBean");

	public CustomerRequestBean() throws Exception {

	}

	public boolean createCustomer(String userId, String password, String name, String surname, String creditCardNumber, String language, String email){
		try{
			if(getCustomer(userId) != null) {
				System.out.println("Ya existe este usuario");
			}
		} catch(CustomerNotFoundException ex) {
			Customer customer = new Customer(userId,password,name,surname,creditCardNumber,language, email);
			em.persist(customer);
			return true;
		} catch (Exception ex) {
			throw new EJBException(ex.getMessage());
		}
		return false;
	}
	
	public void updateCustomer(String userId, String password, String name, String surname, String creditCardNumber, String language, String email) {
		try {
			Customer updatedCustomer = new Customer(userId,password,name,surname,creditCardNumber,language, email);
			em.merge(updatedCustomer);
		} catch (Exception ex) {
			throw new EJBException(ex.getMessage());
		}
	}
	
	public Customer authenticateCustomer(String customerId, String password)  {
		try {
			System.out.println("Checking password");
			return  checkPassword(customerId, password);	
		} catch (Exception ex) {
			throw new EJBException(ex.getMessage());
		}
			
	}
	
	public Customer checkPassword(String customerId, String password) throws CustomerNotFoundException {
		Customer requestedCustomer = getCustomer(customerId);
		if(requestedCustomer.getPassword().equals(password)) {
			System.out.println("Password is correct");
			return requestedCustomer;
		} 
		return null;
	}
	
	public Customer getCustomer(String customerId) throws CustomerNotFoundException {
        Customer requestedCustomer = em.find(Customer.class, customerId);

        if (requestedCustomer == null) {
            throw new CustomerNotFoundException("Couldn't find customer: " + customerId);
        }

        return requestedCustomer;
    }

}
