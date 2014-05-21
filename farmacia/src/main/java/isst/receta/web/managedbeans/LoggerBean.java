package isst.receta.web.managedbeans;

import isst.receta.converters.Password;
import isst.receta.ejb.Logging;
import isst.receta.entity.Farmaceutico;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import es.upm.dit.isst.p5.weather.openweathermap.City;
import es.upm.dit.isst.p5.weather.openweathermap.WeatherReport;
import es.upm.dit.isst.p5.weather.openweathermap.Wind;


@Named("logMe")
@RequestScoped
public class LoggerBean extends AbstractBean implements Serializable {

	private static final long serialVersionUID = -5633644967469166418L;

	@EJB
	private Logging logging;
	
	private float temperatura;
	private String viento;
	
	@Inject
	private Farmaceutico farmaceutico;
	
	public String enter() throws Exception{
		String passwordCifrada=Password.cifrar(farmaceutico.getPassword());
		Farmaceutico buscado=logging.checkPassword(farmaceutico.getFarmaId(), passwordCifrada);
		if(buscado!=null){
			farmaceutico.setName(buscado.getName());
			return ("index");
		}
		
		message(null, "Match");
		farmaceutico.setFarmaId(null);
		return ("login");
	}
	
	public void logOut(){
		
		
		Client client = ClientBuilder.newClient();
		UriBuilder builder = UriBuilder
				.fromPath("http://api.openweathermap.org/data/2.5/forecast");
		URI uri = builder.clone().queryParam("q", "ALMERIA" + "," + "ES")
				.queryParam("units", "metric").build();

		WebTarget r = client.target(uri);
		System.out.println("URI: " + uri);

		WeatherReport report = r.request(MediaType.APPLICATION_JSON_TYPE).get(
				WeatherReport.class);
		//String report = r.request(MediaType.APPLICATION_JSON_TYPE).get(
		//		String.class);
		System.out.println(report.getHourly().get(6).getData().getTemp());
		System.out.println(report.getHourly().get(6));
		System.out.println(report.getHourly().get(6).getWind().toString());
		
		temperatura = report.getHourly().get(6).getData().getTemp();
		viento = report.getHourly().get(6).getWind().toString();
		
		
		//ExternalContext ec=FacesContext.getCurrentInstance().getExternalContext();
		//ec.invalidateSession();
		//return ("login");
		
	}

	public float getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}

	public String getViento() {
		return viento;
	}

	public void setViento(String viento) {
		this.viento = viento;
	}
	
	
	
}
