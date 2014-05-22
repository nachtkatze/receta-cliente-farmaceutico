package javaeetutorial.isst.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javaeetutorial.isst.ejb.RecetaRequestBean;
import javaeetutorial.isst.entity.Receta;
import javaeetutorial.isst.exception.RecetasNotFoundException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class RecetasJSON
 */
@WebServlet("/recetas")
public class RecetasJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@EJB
	private RecetaRequestBean recetareqbean;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecetasJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String opcion = request.getParameter("opcion");
			String pacienteID = request.getParameter("pacienteID");
			String recetaID = request.getParameter("recetaID");
			List<Receta> recetas;
			if(opcion != null){
				if(recetaID != null) {
					if(opcion.equals("modificar")) {
						recetas = recetareqbean.consultarRecetas();
						for(int i=0; i<recetas.size(); i++) {
							Receta receta = recetas.get(i);
							if(receta.getRecetaId().equals(recetaID)) {
								receta.setExpedido(true);
								recetareqbean.actualizarReceta(receta);
								JSONObject objJSON = new JSONObject();
								objJSON.put("estado", "Receta actualizada");
								
								response.setContentType("application/json");
								PrintWriter out = response.getWriter();
								out.println(objJSON);
								return;
							}
						}
					}
				}
			}
			if(pacienteID != null) {
				recetas = recetareqbean.buscarRecetasPorPaciente(pacienteID);
			} else {
				recetas = recetareqbean.consultarRecetas();
			}
			
			JSONObject objJSON = new JSONObject();
			
			JSONArray list = new JSONArray();
			int contador = 0;
			for(int i=0; i < recetas.size(); i++) {
				JSONObject receta = new JSONObject();
				Receta rec = recetas.get(i);
				receta.put("id", rec.getRecetaId());
				receta.put("nombrePaciente", rec.getNombrePaciente());
				receta.put("tarjetaSS", rec.getTarjetaSanitaria());
				receta.put("nombreMedico", rec.getNombreMedico());
				receta.put("numeroColegiado", rec.getNumeroColegiado());
				receta.put("fechaExpedicion", rec.getFechaExpedicion().toString());
				receta.put("nombreMedicamento", rec.getNombreMedicamento());
				receta.put("posologia", rec.getPosologia());
				receta.put("tipo", rec.getTipo());
				receta.put("medicamentoAlternativo", rec.getMedicamentoAlternativo());
				receta.put("expedido", rec.getExpedido());
				
				list.add(receta);
				contador++;
			}
			objJSON.put("recetas", list);
			objJSON.put("numeroRecetas", contador);
			
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.println(objJSON);
			
			
		} catch (RecetasNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
