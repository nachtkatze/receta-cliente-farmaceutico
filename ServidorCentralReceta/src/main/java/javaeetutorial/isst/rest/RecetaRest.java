package javaeetutorial.isst.rest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javaeetutorial.isst.ejb.RecetaRequestBean;
import javaeetutorial.isst.entity.Receta;
import javaeetutorial.isst.exception.RecetasNotFoundException;
import javaeetutorial.isst.rest.Recetas;
import javaeetutorial.isst.rest.Error;
import javaeetutorial.isst.web.managedbeans.CatalogoRecetasBean;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.spi.inject.Inject;

// Plain old Java Object it does not extend as class or implements 
// an interface

// The class registers its methods for the HTTP GET request using the @GET annotation. 
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML. 

// The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@Path("/recetas")
public class RecetaRest {
	
	private CatalogoRecetasBean catalogoRecetas;
	
	@Inject 
	private RecetaRequestBean recetarequestbean;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Recetas> getRecetas() {
		try {
			//catalogoRecetas = new CatalogoRecetasBean();
			//recetarequestbean = new RecetaRequestBean();
			//List<Receta> recetas = catalogoRecetas.getRecetas();
			//System.out.println("SE VA A MOSTRAR EL REQUEST BEAAAAAN");
			System.out.println(recetarequestbean);
			List<Receta> recetas = recetarequestbean.consultarRecetas();
			List<Recetas> recetasJSON = new ArrayList<Recetas>();
			for(int i=0; i < recetas.size(); i++) {
				Receta recetaResultado = recetas.get(i);
				Recetas recetaJSON = new Recetas();
				
				recetaJSON.setRecetaId(recetaResultado.getRecetaId());
				recetaJSON.setNombrePaciente(recetaResultado.getNombrePaciente());
				recetaJSON.setTarjetaSanitaria(recetaResultado.getTarjetaSanitaria());
				recetaJSON.setNombreMedico(recetaResultado.getNombreMedico());
				recetaJSON.setNumeroColegiado(recetaResultado.getNumeroColegiado());
				recetaJSON.setFechaExpedicion(recetaResultado.getFechaExpedicion());
				recetaJSON.setNombreMedicamento(recetaResultado.getNombreMedicamento());
				recetaJSON.setPosologia(recetaResultado.getPosologia());
				recetaJSON.setTipo(recetaResultado.getTipo());
				recetaJSON.setMedicamentoAlternativo(recetaResultado.getMedicamentoAlternativo());
				
//				recetaJSON.setRecetaId("100");
//				recetaJSON.setNombrePaciente("A");
//				recetaJSON.setTarjetaSanitaria("B");
//				recetaJSON.setNombreMedico("C");
//				recetaJSON.setNumeroColegiado("D");
//				recetaJSON.setFechaExpedicion(new Date(System.currentTimeMillis()));
//				recetaJSON.setNombreMedicamento(recetaResultado.getNombreMedicamento());
//				recetaJSON.setPosologia(recetaResultado.getPosologia());
//				recetaJSON.setTipo(recetaResultado.getTipo());
//				recetaJSON.setMedicamentoAlternativo(recetaResultado.getMedicamentoAlternativo());
				
				recetasJSON.add(recetaJSON);
			}
			return recetasJSON;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Recetas>();
		}
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("usuario")
	public List<Recetas> getRecetasPorUsuario(@PathParam("paciente") String tarjeta) {
		try {
			System.out.println("Hace caso al metodoOOOOOO");
			System.out.println(tarjeta);
			List<Receta> recetas = recetarequestbean.buscarRecetasPorPaciente(tarjeta);
			List<Recetas> recetasJSON = new ArrayList<Recetas>();
			for(int i=0; i < recetas.size(); i++) {
				Receta recetaResultado = recetas.get(i);
				Recetas recetaJSON = new Recetas();
				
				recetaJSON.setRecetaId(recetaResultado.getRecetaId());
				recetaJSON.setNombrePaciente(recetaResultado.getNombrePaciente());
				recetaJSON.setTarjetaSanitaria(recetaResultado.getTarjetaSanitaria());
				recetaJSON.setNombreMedico(recetaResultado.getNombreMedico());
				recetaJSON.setNumeroColegiado(recetaResultado.getNumeroColegiado());
				recetaJSON.setFechaExpedicion(recetaResultado.getFechaExpedicion());
				recetaJSON.setNombreMedicamento(recetaResultado.getNombreMedicamento());
				recetaJSON.setPosologia(recetaResultado.getPosologia());
				recetaJSON.setTipo(recetaResultado.getTipo());
				recetaJSON.setMedicamentoAlternativo(recetaResultado.getMedicamentoAlternativo());
				
				recetasJSON.add(recetaJSON);
			}
			return recetasJSON;
		} catch (Exception ex) {
			return null;
		}
		
		
	}
	
 

} 