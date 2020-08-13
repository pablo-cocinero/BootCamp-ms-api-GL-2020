package hibernate.example.menu;

import java.util.ArrayList;

public class MenuApplication {

	public static void main(String[] args) {
		
		
		Plato plato1 = new Plato();
		Plato plato2 = new Plato();

		plato1.setNombre("Milanesa Clasica");
		plato1.setDescripcion("una delicada milanesa con crocantes papas fritas finamente seleccionadas");
		plato1.setPrecio(500.0);
	
		plato2.setNombre("Lomo al piedra");
		plato2.setDescripcion("un curioso plato donde se utilizan piedras calentadas al rojo vivo para cocinar el lomo junto a las especias orientales y sudamericanas logrando un elixir entre la textura y el sabor");
		plato2.setPrecio(750.0);
		
		ArrayList<Plato> platos = new ArrayList<>();
		platos.add(plato1);
		platos.add(plato2);
		
		Menu menu = new Menu();
		
		menu.setPlatos(platos);
		plato1.setMenu(menu);
		plato2.setMenu(menu);
		
		MenuDAO menuDAO = new MenuDAO();
		menuDAO.createMenu(menu);
		
		System.out.println(menuDAO.getMenu()); 
		
	}

}
