package isst.receta.web.managedbeans;

import isst.receta.ejb.MedRequestBean;
import isst.receta.entity.Med;
import isst.receta.rest.Receta;
import isst.receta.rest.Reporte;

import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;


@ManagedBean(name="stock")
@SessionScoped
public class StockBean extends AbstractBean implements Serializable{
	private static final long serialVersionUID = -3594317405246398714L;

	private static Compra compra=new Compra();
    @EJB
    private MedRequestBean medRequestBean;
    

    private boolean recibido;
    
	private String pacienteID;
	
	private static List<Receta> listaRecetas=new ArrayList<Receta>();
	
	private static List<String> listaID=new ArrayList<String>();
	
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public StockBean(){
    	
    	
    }
    
    
    //Añadimos un medicamento a la lista compra
    public void add(Med med) throws Exception{
        recibido=true;
    	Receta buscada=null;
    	for (Receta item : listaRecetas) {
    		if((med.getName().equalsIgnoreCase(item.getNombreMedicamento())||med.getName().equalsIgnoreCase(item.getMedicamentoAlternativo())))
    		    		
    		{
    			buscada=item;
    			System.out.println("Holii "+item.getNombreMedicamento()+ "" + med.getName());
    		}
    	}if(buscada==null){
    		message(null,"No se encuentra en la receta");
    		
    	}else{   
    	
    		listaRecetas.remove(buscada);
    		message(null, "Añadida al recibo");
            compra.add(med);   
    	}
    			
    			
  
        System.out.println("La seleccionada es "+med.getName());
         

    }
    
    public List<Med> getMeds() {
        try {
            return medRequestBean.getMeds();
        } catch (Exception e) {
            throw new FacesException("Exception: " + e);
        }
    }

    public void removeUnit(Med med) throws Exception{
    	med.setUnits(med.getUnits()-1);
    	medRequestBean.update(med);
    }
    
	public MedRequestBean getMedRequestBean() {
		return medRequestBean;
	}


	public void setMedRequestBean(MedRequestBean medRequestBean) {
		this.medRequestBean = medRequestBean;
	}
	
	public void clean(){
	
		compra.clean();
		message(null,"Lista de compra limpiada");
	}

	public static Compra getCompra() {
		return compra;
	}

	public static void setCompra(Compra compra) {
		StockBean.compra = compra;
	}
	
	public void submit(){
		listaRecetas.clear();

		
		Client client = ClientBuilder.newClient();
		UriBuilder builder = UriBuilder
				.fromPath("http://strauss.gsi.dit.upm.es:8080/isst/recetas");
		URI uri = builder.clone().queryParam(pacienteID)
				.queryParam("pacienteID", pacienteID).build();

		WebTarget r = client.target(uri);
		System.out.println("URI: " + uri);

		Reporte report = r.request(MediaType.APPLICATION_JSON_TYPE).get(
				Reporte.class);
		if(report.getNumeroRecetas()==0){
			message(null,"No existe el TSI");
			recibido=false;
		}else{
		
			for (Receta item : report.getRecetas()) {
				//Solo nos la manda si no está expedida
				if(item.isExpedido()==true){
					
						listaRecetas.add(item);
						listaID.add(item.getId());
				}			
			}
		}
		
		recibido=true;
		
	}	



	public String getPacienteID() {
		return pacienteID;
	}


	public void setPacienteID(String pacienteID) {
		this.pacienteID = pacienteID;
	}


	public boolean isRecibido() {
		return recibido;
	}


	public void setRecibido(boolean recibido) {
		this.recibido = recibido;
	}


	public List<Receta> getListaRecetas() {
		return listaRecetas;
	}


	public void setListaRecetas(List<Receta> listaRecetas) {
		this.listaRecetas = listaRecetas;
	}


	public static List<String> getListaID() {
		return listaID;
	}


	public static void setListaID(List<String> listaID) {
		StockBean.listaID = listaID;
	}



    
    
}


