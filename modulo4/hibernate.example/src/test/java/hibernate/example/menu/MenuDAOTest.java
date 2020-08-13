package hibernate.example.menu;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class MenuDAOTest {

	static Menu menu;
	static MenuDAO menuDAO;
	
	@BeforeAll
	static void setUp() throws Exception {
		
		menu = new Menu();
		menuDAO = new MenuDAO();
		
		Plato plato1 = new Plato();
		Plato plato2 = new Plato();

		plato1.setNombre("Milanesa Clasica");
		plato1.setDescripcion("una delicada milanesa con crocantes papas fritas finamente seleccionadas");
		plato1.setPrecio(500.0);
		plato1.setMenu(menu);
		
		plato2.setNombre("Lomo al piedra");
		plato2.setDescripcion("un curioso plato donde se utilizan piedras calentadas al rojo vivo para cocinar el lomo junto a las especias orientales y sudamericanas logrando un elixir entre la textura y el sabor");
		plato2.setPrecio(750.0);
		plato2.setMenu(menu);
		
		ArrayList<Plato> platos = new ArrayList<>();
		platos.add(plato1);
		platos.add(plato2);
		
		menu.setNombre("menu 1");
		menu.setPlatos(platos);
		
		
		menuDAO = new MenuDAO();
		menuDAO.createMenu(menu);
	}

	@Test
	@DisplayName("getMenu_test")
	void testCase_1() {
		
		List<Menu>  returnedMenu = menuDAO.getMenu();
		assertEquals(menu, returnedMenu.get(0));
		
	}
	
	@Test
	@DisplayName("getMenuById_test")
	void testCase_2() {
		
		List<Menu>  returnedMenu = menuDAO.getMenu(1);
		assertEquals(menu, returnedMenu.get(0));
		
	}
	
	@Test
	@DisplayName("updateMenu_test")
	void testCase_3() {
		
		Menu returnedMenu = menuDAO.getMenu(1).get(0);
		returnedMenu.setNombre("nombre nuevo");
		menuDAO.updateMenu(returnedMenu);
		
		Menu modifiedMenu = menuDAO.getMenu(1).get(0);
		
		assertNotEquals(menu, modifiedMenu);
		assertEquals("nombre nuevo",modifiedMenu.getNombre());
	}
	
	@Test
	@DisplayName("removeMenu_test")
	void testCase_4() {
		
		Menu returnedMenu = menuDAO.getMenu(1).get(0);
		int id = returnedMenu.getId();
		menuDAO.removeMenu(returnedMenu);
		
		assertTrue(!menuDAO.getMenu(id).contains(returnedMenu));
		
	}

}

