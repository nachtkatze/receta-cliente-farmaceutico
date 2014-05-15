/**
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://java.net/projects/javaeetutorial/pages/BerkeleyLicense
 */
package javaeetutorial.isst.entity;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * <p>Entity class for bookstore example.</p>
 */
@Named
@Entity
@SessionScoped
@Table(name = "WEB_PACIENTE")
@NamedQuery(
        name = "buscaPaciente",
        query = "SELECT p FROM Paciente p ORDER BY p.pacienteId")
public class Paciente implements Serializable {

    private static final long serialVersionUID = -4146681491856848089L;
    @Id
    @NotNull
    private String pacienteId;
    private String apellido;
    private String nombre;
    private String numeroSS;
    @OneToMany
    private List<Receta> recetas;

    public Paciente() {
    }

    public Paciente(String pacienteId, String apellido, String nombre, String numeroSS, List<Receta> recetas) {
        this.pacienteId = pacienteId;
        this.apellido = apellido;
        this.nombre = nombre;
        this.numeroSS = numeroSS;
        this.recetas = recetas;
    }

    public Paciente(String pacienteId) {
        this.pacienteId = pacienteId;
    }

    public String getpacienteId() {
        return pacienteId;
    }

    public void setpacienteId(String pacienteId) {
        this.pacienteId = pacienteId;
    }

    public String getapellido() {
        return apellido;
    }

    public void setapellido(String apellido) {
        this.apellido = apellido;
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNumeroSS() {
    	return numeroSS;
    }
    
    public void setNumeroSS(String numeroSS) {
    	this.numeroSS = numeroSS;
    }
    
    public List<Receta> getRecetas() {
    	return recetas;
    }
    
    public void setRecetas(List<Receta> recetas) {
    	this.recetas = recetas;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pacienteId != null ? pacienteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        return this.pacienteId != null || other.pacienteId == null 
                && this.pacienteId == null || this.pacienteId.equals(other.pacienteId);
    }

    @Override
    public String toString() {
    	return "";
    }
}
