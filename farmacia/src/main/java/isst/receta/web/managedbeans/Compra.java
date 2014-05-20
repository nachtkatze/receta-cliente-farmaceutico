package isst.receta.web.managedbeans;

import isst.receta.entity.Med;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named("compra")
@SessionScoped
public class Compra implements Serializable{
	
	private static final long serialVersionUID = 1440716172304717L;
	
	private static List<Med> lista=new ArrayList<Med>();;
	
	private static double total =0;
	
	public Compra(){
		
		
	}

	public List<Med> getLista() {
		return lista;
	}
	
	
	public void setLista(List<Med> lista) {
		Compra.lista = lista;
	}
	
	public void add(Med med){
		med.setUnits(1);
		int cantidad=0;
		Med buscado=null;
		boolean coincide=false;
		if(lista.isEmpty()){
			lista.add(med);
			System.out.println("La cantidad del primer "+med.getName()+" es "+med.getUnits());
			
		}
		else{
			//Miramos si el medicamento ya se encuentra en la lista
			for (Med item : lista) {
				System.out.println("Comparamos "+item.getMedId()+" es "+med.getMedId());
	            if(item.getMedId().equalsIgnoreCase(med.getMedId())==true){
	            	coincide=true;
	            	buscado=item;    
	            }
	            
            }
			//Si se encuentra aumentamos la cantidad en uno
			if(coincide){
				cantidad=buscado.getUnits()+1;
            	lista.remove(buscado);
            	med.setUnits(cantidad);
            	System.out.println("La cantidad del nuevo "+med.getName()+" es "+med.getUnits());
            	lista.add(med);
            //No se encuentra en la lista, por tanto añadimos directamente una unidad	
			}else{
				lista.add(med);
            	System.out.println("La cantidad de "+med.getName()+" es "+med.getUnits());
			}
		//Simplemente para comprobar que sale la lista correctamente	
		}for (Med item : lista) {
			System.out.println("Medicamento "+item.getName()+" con "+ item.getUnits()+" unidades");
			
		}
		total=roundOff(total+(med.getPrice()));
		System.out.println("Con importe total de "+total+" euros");
		
	}
	
	//Para limpiar la lista
	public void clear(){
		lista.clear();
		total =0;
		
	}
	
		

	public double getTotal() {
		return total;
	}

	public void setTotal(int total) {
		Compra.total = total;
	}

	private double roundOff(double x) {
        long val = Math.round(x * 100); // cents

        return val / 100.0;
    }
	
	
	
	
	
	
	

}
