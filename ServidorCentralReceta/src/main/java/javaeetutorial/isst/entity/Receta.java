package javaeetutorial.isst.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.faces.bean.SessionScoped;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Entity implementation class for Entity: Receta
 *
 */
@Entity
@Table(name = "WEB_RECETA")

@NamedQueries({
	@NamedQuery(
			name = "buscaReceta",
	        query = "SELECT r FROM Receta r ORDER BY r.recetaId"),
	@NamedQuery(
			name = "buscaRecetasPaciente",
			query = "SELECT r FROM Receta r WHERE r.tarjetaSanitaria =:numeroTarjeta ORDER BY r.recetaId"),
	@NamedQuery(
			name = "borrarRecetasPaciente",
			query = "DELETE FROM Receta r WHERE r.tarjetaSanitaria =:numeroTarjeta")
})


public class Receta implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	private String recetaId;
	private String nombrePaciente;
	private String tarjetaSanitaria;
	private String nombreMedico;
	private String numeroColegiado;
	private Date fechaExpedicion;
	private String nombreMedicamento;
	private String posologia;
	private String tipo;
	private String medicamentoAlternativo;
	private boolean expedido;
	
	
	public Receta(String recetaId, String nombrePaciente, String tarjetaSanitaria, String nombreMedico, String numeroColegiado,
			Date fechaExpedicion, String nombreMedicamento, String posologia, String tipo, String medicamentoAlternativo, boolean expedido) {
		this.recetaId = recetaId;
		this.nombrePaciente = nombrePaciente;
		this.tarjetaSanitaria = tarjetaSanitaria;
		this.nombreMedico = nombreMedico;
		this.numeroColegiado = numeroColegiado;
		this.fechaExpedicion = fechaExpedicion;
		this.nombreMedicamento = nombreMedicamento;
		this.posologia = posologia;
		this.tipo = tipo;
		this.medicamentoAlternativo = medicamentoAlternativo;
		this.expedido = expedido;
		
	}

	public boolean getExpedido() {
		return expedido;
	}

	public void setExpedido(boolean expedido) {
		this.expedido = expedido;
	}

	public String getRecetaId() {
		return recetaId;
	}



	public void setRecetaId(String recetaId) {
		this.recetaId = recetaId;
	}



	public String getNombrePaciente() {
		return nombrePaciente;
	}



	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}



	public String getTarjetaSanitaria() {
		return tarjetaSanitaria;
	}



	public void setTarjetaSanitaria(String tarjetaSanitaria) {
		this.tarjetaSanitaria = tarjetaSanitaria;
	}



	public String getNombreMedico() {
		return nombreMedico;
	}



	public void setNombreMedico(String nombreMedico) {
		this.nombreMedico = nombreMedico;
	}



	public String getNumeroColegiado() {
		return numeroColegiado;
	}



	public void setNumeroColegiado(String numeroColegiado) {
		this.numeroColegiado = numeroColegiado;
	}



	public Date getFechaExpedicion() {
		return fechaExpedicion;
	}



	public void setFechaExpedicion(Date fechaExpedicion) {
		this.fechaExpedicion = fechaExpedicion;
	}



	public String getNombreMedicamento() {
		return nombreMedicamento;
	}



	public void setNombreMedicamento(String nombreMedicamento) {
		this.nombreMedicamento = nombreMedicamento;
	}



	public String getPosologia() {
		return posologia;
	}



	public void setPosologia(String posologia) {
		this.posologia = posologia;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public String getMedicamentoAlternativo() {
		return medicamentoAlternativo;
	}



	public void setMedicamentoAlternativo(String medicamentoAlternativo) {
		this.medicamentoAlternativo = medicamentoAlternativo;
	}



	public Receta() {
	}
   
}
