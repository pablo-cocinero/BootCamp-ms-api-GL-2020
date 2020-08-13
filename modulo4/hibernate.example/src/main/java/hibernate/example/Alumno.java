package hibernate.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Alumno")
public class Alumno {
	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "nombre2")
	private String apellido;
	
	public Alumno() {}
	
	public Alumno(Integer id,String nombre, String apellido)
	{
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public Integer getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	@Override
	public String toString()
	{
		return "id: " + id + ", nombre: " + nombre + ", apellido: " + apellido;
	}
	
}
