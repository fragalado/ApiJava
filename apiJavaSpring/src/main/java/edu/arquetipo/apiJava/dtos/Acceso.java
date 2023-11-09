package edu.arquetipo.apiJava.dtos;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "accesos", schema = "gbp_operacional")
public class Acceso {
	// Atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_acceso", nullable = false)
	private long id_acceso;
	
	@Column(name = "codigo_acceso")
	private String codigo_acceso;
	
	@Column(name = "descripcion_acceso")
	private String descripcion_acceso;
	
	@OneToMany(mappedBy = "acceso")
	List<Usuario> usuariosConAcceso;
	
	// Constructores
	
	public Acceso() {
		super();
	}
	
	public Acceso(String codigo_acceso, String descripcion_acceso) {
		super();
		this.codigo_acceso = codigo_acceso;
		this.descripcion_acceso = descripcion_acceso;
	}
	
	// Getter
	
	public String getCodigo_acceso() {
		return codigo_acceso;
	}

	public String getDescripcion_acceso() {
		return descripcion_acceso;
	}
	
	// Setter

	public void setCodigo_acceso(String codigo_acceso) {
		this.codigo_acceso = codigo_acceso;
	}

	public void setDescripcion_acceso(String descripcion_acceso) {
		this.descripcion_acceso = descripcion_acceso;
	}
	
	// toString
	
	@Override
	public String toString() {
		return "Acceso [codigo_acceso=" + codigo_acceso + ", descripcion_acceso=" + descripcion_acceso + "]";
	}
}
