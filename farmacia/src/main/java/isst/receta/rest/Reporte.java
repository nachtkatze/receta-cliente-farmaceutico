package isst.receta.rest;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Reporte {

	@XmlElement(name="recetas")
	private List<Receta> recetas;
	@XmlElement(name="numeroRecetas")
	private int numeroRecetas;
	
	public String toString() {
		StringBuffer toReturn = new StringBuffer();
		for(Receta r: recetas) {
			toReturn.append("\t");
			toReturn.append(r);
			toReturn.append("\n");
		}
		toReturn.append("Numero de recetas: " + numeroRecetas);
		toReturn.append("\n");
		return toReturn.toString();
	}

	public List<Receta> getRecetas() {
		return recetas;
	}

	public void setRecetas(List<Receta> recetas) {
		this.recetas = recetas;
	}

	public int getNumeroRecetas() {
		return numeroRecetas;
	}

	public void setNumeroRecetas(int numeroRecetas) {
		this.numeroRecetas = numeroRecetas;
	}
	
	
	
}