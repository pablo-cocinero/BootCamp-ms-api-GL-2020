package hibernate.example.carrera;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "carrera")
public class Carrera {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "nombre")
	private String nombre;
	
	@OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Competidor> competidores;

	public Integer getId() {
		return id;
	}

	public Date getFecha() {
		return fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Competidor> getCompetidores() {
		return competidores;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCompetidores(List<Competidor> competidores) {
		this.competidores = competidores;
	}
	
	@Override
	public String toString()
	{
		return "Id: " + id + ", Fecha: " + fecha + " Nombre: " + nombre + "\nCompetidores: \n" + competidores.toString();
	}
	
}
