package javaeetutorial.isst.web.managedbeans;

import javaeetutorial.isst.ejb.CustomerRequestBean;
import javaeetutorial.isst.entity.Customer;

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
		boolean result =  customerRequestBean.createCustomer(customer.getUserId(), customer.getPassword(), customer.getName(), customer.getSurname(), customer.getCreditCardNumber(), customer.getLanguage(), customer.getEmail());
		if (result) {
			localeBean.setLanguage(customer.getLanguage());
			return ("index");
		}
		message(null, "RegisterFailed", new Object []{customer.getUserId()});
		customer.setUserId(null);
		return ("index");
	}
	
	public String authenticate() {
		Customer result = customerRequestBean.authenticateCustomer(customer.getUserId(), customer.getPassword());
		if(result != null) {
			customer.setName(result.getName());
			customer.setEmail(result.getEmail());
			customer.setSurname(result.getSurname());
			customer.setCreditCardNumber(result.getCreditCardNumber());
			customer.setLanguage(result.getLanguage());
			localeBean.setLanguage(customer.getLanguage());
			return ("index");
		} else {
			message(null, "AuthenticationFailed");
			customer.setUserId(null);
			return ("authenticate");
		}
	}
	
	public String edit() {
		customerRequestBean.updateCustomer(customer.getUserId(), customer.getPassword(), customer.getName(), customer.getSurname(), customer.getCreditCardNumber(), customer.getLanguage(), customer.getEmail());
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
