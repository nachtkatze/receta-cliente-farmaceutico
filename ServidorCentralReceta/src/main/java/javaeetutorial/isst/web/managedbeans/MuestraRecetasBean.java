package javaeetutorial.isst.web.managedbeans;

import java.util.List;

import javaeetutorial.isst.ejb.CustomerRequestBean;
import javaeetutorial.isst.ejb.PacienteRequestBean;
import javaeetutorial.isst.ejb.RecetaRequestBean;
import javaeetutorial.isst.entity.Customer;
import javaeetutorial.isst.entity.Paciente;
import javaeetutorial.isst.entity.Receta;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class MuestraRecetasBean extends AbstractBean {

	private static final long serialVersionUID = -2633611967469166418L;

	@EJB
	private CustomerRequestBean customerRequestBean;
	
	@EJB
	private RecetaRequestBean recetaRequestBean;
	
	@EJB
	private PacienteRequestBean pacienteRequestBean;
	
	//@EJB
	//private Paciente paciente;
	
	@Inject
	private LocaleBean localeBean;
	
	

	
	public String mostrar() throws Exception {
		List<Receta> recetas = recetaRequestBean.consultarRecetas();
		System.out.println(recetas.size());
		for(int i=0; i < recetas.size(); i++) {
			Receta recetaResultado = recetas.get(i);
			System.out.println(recetaResultado.getNombreMedicamento());
		}
		return ("muestrarecetas");
	}
	
	public String buscar() throws Exception {
		String numeroTarjeta = "1000212";
		List<Receta> recetas = recetaRequestBean.buscarRecetasPorPaciente(numeroTarjeta);
		System.out.println(recetas.size());
		for(int i=0; i < recetas.size(); i++) {
			Receta recetaResultado = recetas.get(i);
			if(recetaResultado.getTarjetaSanitaria() != numeroTarjeta) {
				
			}
			System.out.println(recetaResultado.getNombreMedicamento());
		}
		return ("muestrarecetaspaciente");
	}
	

	public CustomerRequestBean getCustomerRequestBean() {
		return customerRequestBean;
	}

	public void setCustomerRequestBean(CustomerRequestBean customerRequestBean) {
		this.customerRequestBean = customerRequestBean;
	}
	
	public RecetaRequestBean getRecetaRequestBean() {
		return recetaRequestBean;
	}

	public void setRecetaRequestBean(RecetaRequestBean recetaRequestBean) {
		this.recetaRequestBean = recetaRequestBean;
	}

	public LocaleBean getLocaleBean() {
		return localeBean;
	}

	public void setLocaleBean(LocaleBean localeBean) {
		this.localeBean = localeBean;
	}
	/*
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	*/
	
}
