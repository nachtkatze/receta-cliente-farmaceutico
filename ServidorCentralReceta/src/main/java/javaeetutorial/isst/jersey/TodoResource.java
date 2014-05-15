package javaeetutorial.isst.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/todo")
public class TodoResource {
	
	// This method is called if XMLis request
	@GET
	@Produces({MediaType.APPLICATION_JSON })
	@Path("{id}")
	public Todo getXML(@PathParam("id") String id) {
		Todo todo = new Todo();
		todo.setSummary("This is a todo in JSON, with an id of " + id);
		todo.setDescription("This is the description");
		return todo;
	}
	  
	// This can be used to test the integration with the browser
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Todo getHTML() {
		Todo todo = new Todo();
		todo.setSummary("Hey there");
		todo.setDescription("This is a description");
		return todo;
	}
	
}
