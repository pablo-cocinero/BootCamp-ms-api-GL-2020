package hibernate.example.menu;

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
@Table(name = "menu")
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	List<Plato> platos;

	@Column(name = "nombre")
	String nombre;
	
	public Menu() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Plato> getPlatos() {
		return platos;
	}

	public void setPlatos(List<Plato> platos) {
		this.platos = platos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Menu id:" + id + ", Platos: \n" + platos.toString();
	}

	@Override
	public boolean equals(Object object) {
		Menu otro = (Menu) object;
		if (this.getId().equals(otro.getId()) && this.getNombre().equals(otro.getNombre())) {
			if (this.getPlatos().size() != otro.getPlatos().size()) {
				return false;
			} else 
			{
				for (int i = 0; i < this.getPlatos().size(); i++) {
					if (!this.getPlatos().get(i).equals(otro.getPlatos().get(i)))
						return false;
				}
				return true;
			}
		} else
			return false;
	}
}
