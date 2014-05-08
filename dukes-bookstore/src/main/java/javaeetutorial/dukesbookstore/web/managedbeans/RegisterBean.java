package javaeetutorial.dukesbookstore.web.managedbeans;

import javaeetutorial.dukesbookstore.ejb.CustomerRequestBean;
import javaeetutorial.dukesbookstore.entity.Customer;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class RegisterBean extends AbstractBean {

	private static final long serialVersionUID = -2633611967469166418L;

	@EJB
	private CustomerRequestBean customerRequestBean;
	
	@Inject
	private LocaleBean localeBean;
	
	@Inject
	private Customer customer;
	
	public String submit() {
		customerRequestBean.createCustomer(customer.getUserId(), customer.getPassword(), customer.getName(), customer.getSurname(), customer.getCreditCardNumber(), customer.getLanguage());
		localeBean.setLanguage(customer.getLanguage());
		return ("index");
	}

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
