package hibernate.example.carrera;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "competidor")
public class Competidor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numero;
	
	@Column(name = "nombre")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "carrera_id")
	private Carrera carrera;

	public Integer getNumero() {
		return numero;
	}

	public String getNombre() {
		return nombre;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	
	@Override
	public String toString()
	{
		return "\nNumero: " + numero + ", Nombre: " + nombre;
	}
	
	@Override
	public boolean equals(Object object)
	{
		Competidor otro = (Competidor)object;
		if(this.getNumero().equals(otro.getNumero()) && this.getNombre().equals(otro.getNombre())&& this.getCarrera().equals(otro.getCarrera()))
		{
			return true;
		}else
			return false;
	}
	
}
