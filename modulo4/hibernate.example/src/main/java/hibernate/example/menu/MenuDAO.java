package hibernate.example.menu;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class MenuDAO {

	public void createMenu(Menu menu) {

		Transaction transaction = null;

		try (Session session = HibernateConfig.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			session.save(menu);

			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {

				transaction.rollback();

			}

			e.printStackTrace();

		}

	}

	public List <Menu> getMenu() {

		try (Session session = HibernateConfig.getSessionFactory().openSession()) {

			return session.createQuery("from Menu", Menu.class).list();

		}

	}

	public List<Menu> getMenu(Integer id) {

		try (Session session = HibernateConfig.getSessionFactory().openSession()) {

			return session.createQuery("from Menu s where s.id =: id"

					, Menu.class).setParameter("id", id).list();

		}

	}
	
	public void updateMenu(Menu menu) {

		Transaction transaction = null;

		try (Session session = HibernateConfig.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			session.update(menu);

			transaction.commit();

		} catch (Exception e) {

			if (transaction != null)

				transaction.rollback();

			e.printStackTrace();

		}

	}

	public void removeMenu(Menu menu) {

		Transaction transaction = null;

		try (Session session = HibernateConfig.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			session.delete(menu);

			transaction.commit();

		} catch (Exception e) {

			if (transaction != null)

				transaction.rollback();

			e.printStackTrace();

		}

	}
	
}

