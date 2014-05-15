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
public class PacienteRequestBean {

	@PersistenceContext
	private EntityManager em;
	private static final Logger logger =
			Logger.getLogger("isst.ejb.CustomerRequestBean");

	public PacienteRequestBean() throws Exception {

	}
	

}
