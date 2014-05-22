/**
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://java.net/projects/javaeetutorial/pages/BerkeleyLicense
 */
package javaeetutorial.isst.ejb;

import java.sql.Date;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javaeetutorial.isst.entity.Book;
import javaeetutorial.isst.entity.Receta;
import javaeetutorial.isst.exception.BooksNotFoundException;
import javaeetutorial.isst.exception.RecetasNotFoundException;

import javax.ejb.EJBException;
import javax.ejb.Stateful;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * <p>Stateful session bean for the bookstore example.</p>
 */
@Stateful
public class RecetaRequestBean {

    @PersistenceContext
    private EntityManager em;
    private static final Logger logger =
            Logger.getLogger("isst.ejb.BookRequestBean");

    public RecetaRequestBean() throws Exception {
    }
    
    public void crearReceta(String recetaId, String nombrePaciente, String tarjetaSanitaria, String nombreMedico, String numeroColegiado, Date fechaExpedicion,
    		String nombreMedicamento, String posologia, String tipo, String medicamentoAlternativo, boolean expedido) {
    	Receta receta = new Receta(recetaId, nombrePaciente, tarjetaSanitaria, nombreMedico, numeroColegiado, fechaExpedicion,
    			nombreMedicamento, posologia, tipo, medicamentoAlternativo, expedido);
    	em.persist(receta);
    }
    
    public List<Receta> consultarRecetas() throws RecetasNotFoundException {
    	try {
    		Query q = em.createNamedQuery("buscaReceta");
    		List<Receta> receta = q.getResultList();
    		return receta ;
        } catch (Exception ex) {
            throw new RecetasNotFoundException(
                    "No se ha podido encontrar las recetas: " + ex.getStackTrace());
        }
    }
    
    public List<Receta> buscarRecetasPorPaciente(String tarjetaPaciente) throws RecetasNotFoundException {
    	try {
    		return (List<Receta>) em.createNamedQuery("buscaRecetasPaciente").setParameter("numeroTarjeta", tarjetaPaciente).getResultList();
    	} catch (Exception ex) {
    		throw new RecetasNotFoundException(
    				"No se ha podido encontrar las recetas por paciente: " + ex.getMessage());
    	}
    }
    
    public void eliminarRecetasPorPaciente(String pacienteID) {
    	Query resultado = em.createNamedQuery("borrarRecetasPaciente").setParameter("numeroTarjeta", pacienteID);
    }
    
    public void actualizarReceta(Receta receta) {
    	try {
    		em.merge(receta);
    	} catch (Exception ex) {
    		throw new EJBException(ex.getMessage());
    	}
    }

    
}
