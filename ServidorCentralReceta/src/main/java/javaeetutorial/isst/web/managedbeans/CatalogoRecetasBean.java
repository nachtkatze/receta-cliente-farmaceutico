/**
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://java.net/projects/javaeetutorial/pages/BerkeleyLicense
 */
package javaeetutorial.isst.web.managedbeans;

import java.io.Serializable;
import java.util.List;

import javaeetutorial.isst.ejb.BookRequestBean;
import javaeetutorial.isst.ejb.RecetaRequestBean;
import javaeetutorial.isst.entity.Book;
import javaeetutorial.isst.entity.Receta;
import javaeetutorial.isst.exception.BooksNotFoundException;
import javaeetutorial.isst.exception.RecetasNotFoundException;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.FacesException;
import javax.inject.Named;

/**
 * <p>Backing bean for the <code>/index.xhtml</code> page.</p>
 */
@Named("catalogo")
@SessionScoped
public class CatalogoRecetasBean extends AbstractBean implements Serializable {

    private static final long serialVersionUID = -3594317405246398714L;
    private int totalBooks = 0;
    @EJB
    private BookRequestBean bookRequestBean;
    @EJB
    private RecetaRequestBean recetaRequestBean;

	/**
     * <p>Return the currently selected
     * <code>Book</code> instance from the user request.</p>
     */
    protected Book book() {
        Book book;
        book = (Book) context().getExternalContext()
           .getRequestMap().get("book");

        return (book);
    }

    /**
     * <p>Add the selected item to our shopping cart.</p>
     */
    public String add() {
        Book book = book();
        cart.add(book.getBookId(), book);
        message(null, "ConfirmAdd", new Object[]{book.getTitle()});

        return ("index");
    }

    /**
     * <p>Show the details page for the current book.</p>
     */
    public String details() {
        context().getExternalContext().getSessionMap().put("selected", book());

        return ("bookdetails");
    }

    public int getTotalBooks() {
        totalBooks = cart.getNumberOfItems();

        return totalBooks;
    }

    public void setTotalBooks(int totalBooks) {
        this.totalBooks = totalBooks;
    }

    public int getBookQuantity() {
        int bookQuantity = 0;
        Book book = book();

        if (book == null) {
            return bookQuantity;
        }

        List<ShoppingCartItem> results = cart.getItems();
        for (ShoppingCartItem item : results) {
            Book bd = (Book) item.getItem();

            if ((bd.getBookId()).equals(book.getBookId())) {
                bookQuantity = item.getQuantity();

                break;
            }
        }

        return bookQuantity;
    }
    
    public List<Receta> getRecetas() {
        try {
            return recetaRequestBean.consultarRecetas();
        } catch (RecetasNotFoundException e) {
            throw new FacesException("Exception: " + e);
        }
    }
    
    public List<Receta> getRecetasPaciente() {
    	try {
    		return recetaRequestBean.buscarRecetasPorPaciente("1000212");
    	}catch (RecetasNotFoundException e) {
            throw new FacesException("Exception: " + e);
        }
    }
    
    public BookRequestBean getBookRequestBean() {
		return bookRequestBean;
	}

	public void setBookRequestBean(BookRequestBean bookRequestBean) {
		this.bookRequestBean = bookRequestBean;
	}
}
