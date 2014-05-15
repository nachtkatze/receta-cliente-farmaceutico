/**
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://java.net/projects/javaeetutorial/pages/BerkeleyLicense
 */
package javaeetutorial.isst.ejb;

import java.sql.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * <p>Singleton bean that initializes the book database for the bookstore
 * example.</p>
 */
@Singleton
@Startup
public class ConfigBean {

	@EJB
	private BookRequestBean request;
	@EJB
	private RecetaRequestBean receta;

	@PostConstruct
	public void createData() {
		
		
		request.createBook("201", "Duke", "",
				"My Early Years: Growing Up on *7",
				30.75, false, 2005, "What a cool book.", 20);
		request.createBook("202", "Jeeves", "",
				"Web Servers for Fun and Profit", 40.75, true,
				2010, "What a cool book.", 20);
		request.createBook("203", "Masterson", "Webster",
				"Web Components for Web Developers",
				27.75, false, 2010, "What a cool book.", 20);
		request.createBook("205", "Novation", "Kevin",
				"From Oak to Java: The Revolution of a Language",
				10.75, true, 2008, "What a cool book.", 20);
		request.createBook("206", "Thrilled", "Ben",
				"The Green Project: Programming for Consumer Devices",
				30.00, true, 2008, "What a cool book.", 20);
		request.createBook("207", "Coding", "Happy",
				"Java Intermediate Bytecodes", 30.95, true,
				2010, "What a cool book.", 20); 
		
		receta.crearReceta("100", "Marcos Torres", "1000212", "Medico de Marcos",
				"123456789", new Date(System.currentTimeMillis()), "Cetirizina",
				"Tomar cuando te de la realisima gana", "Tipo raro", "Coso para la alergia");
		receta.crearReceta("101", "Oscar Araque", "1000213", "Medico de Oscar",
				"123456123", new Date(System.currentTimeMillis()), "Bisolvon",
				"Tomar mucho, MUCHISIMO", "Tipo lucha", "Otro antitusivo");
		receta.crearReceta("102", "Marcos Torres", "1000212", "Medico de Marcos",
				"123456789", new Date(System.currentTimeMillis()), "Cetirizina2",
				"Tomar por la oreja", "Para la alergia", "Es para la alergia nano");
		receta.crearReceta("103", "Oscar Araque", "1000213", "Medico de Oscar",
				"123456123", new Date(System.currentTimeMillis()), "Bisolvon (x2)",
				"Tomar mucho, MUCHISISISISIMO", "Tipo lucha contra la tos", "Otro antitusivo mas, aun");
		
	}
}
