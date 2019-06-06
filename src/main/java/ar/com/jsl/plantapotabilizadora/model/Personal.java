package ar.com.jsl.plantapotabilizadora.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="personal")
public class Personal implements Serializable {

	private static final long serialVersionUID = -3240819562819611418L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPersonal;
	@Column(length=50, nullable=false)
	private String nombre;
	@Column(length=50, nullable=false)
	private String apellido;
	@Column(length=50, unique=true)
	private String mail;
	@Column(length=50, unique=true)
	private int dni;
	@Column(columnDefinition="tinyint(4) default '1'")
	private boolean estado;
	@Column(length=250)
	private String direccion;
	
	public int getIdPersonal() {
		return idPersonal;
	}
	public void setIdPersonal(int idPersonal) {
		this.idPersonal = idPersonal;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="personal_especialidades",
	joinColumns= 
		{@JoinColumn(name="id_personal", referencedColumnName = "idPersonal")},
	inverseJoinColumns = 
		{@JoinColumn(name="id_especialidad",referencedColumnName = "id")}
	)
	private Set<Especialidad> especialidades;
	
	
	@ElementCollection
	@CollectionTable(
		name="telefonos_personal", joinColumns=
		@JoinColumn(name="id_personal"))
	@Column(name="telefono")
	private Set<Telefono> telefonos;
	
	public Set<Telefono> getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(Set<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	public Set<Especialidad> getEspecialidades() {
		return especialidades;
	}
	public void setEspecialidades(Set<Especialidad> especialidades) {
		this.especialidades = especialidades;
	}

}
