package javaeetutorial.isst.web.managedbeans;

import javaeetutorial.isst.ejb.CustomerRequestBean;
import javaeetutorial.isst.entity.Customer;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("edit")
@RequestScoped
public class ProfileEditBean extends AbstractBean {

	private static final long serialVersionUID = -2633611967469166418L;

	@EJB
	private CustomerRequestBean customerRequestBean;
	
	@Inject
	private LocaleBean localeBean;
	
	@Inject
	private Customer customer;
	
	

	public CustomerRequestBean getCustomerRequestBean() {
		return customerRequestBean;
	}

	public void setCustomerRequestBean(CustomerRequestBean customerRequestBean) {
		this.customerRequestBean = customerRequestBean;
	}

	public LocaleBean getLocaleBean() {
		return localeBean;
	}

	public void setLocaleBean(LocaleBean localeBean) {
		this.localeBean = localeBean;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
