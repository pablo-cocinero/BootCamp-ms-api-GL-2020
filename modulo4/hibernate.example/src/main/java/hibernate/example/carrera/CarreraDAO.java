package hibernate.example.carrera;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CarreraDAO {

	public void createCarrera(Carrera carrera) {

		Transaction transaction = null;

		try (Session session = HibernateConfig.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			session.save(carrera);

			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {

				transaction.rollback();

			}

			e.printStackTrace();

		}

	}

	public List <Carrera> getCarrera() {

		try (Session session = HibernateConfig.getSessionFactory().openSession()) {

			return session.createQuery("from Carrera", Carrera.class).list();

		}

	}

	public List<Carrera> getCarrera(Integer id) {

		try (Session session = HibernateConfig.getSessionFactory().openSession()) {

			return session.createQuery("from Carrera s where s.id =: id"

					, Carrera.class).setParameter("id", id).list();

		}

	}
	
	public void updateCarrera(Carrera carrera) {

		Transaction transaction = null;

		try (Session session = HibernateConfig.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			session.update(carrera);

			transaction.commit();

		} catch (Exception e) {

			if (transaction != null)

				transaction.rollback();

			e.printStackTrace();

		}

	}

	public void removeCarrera(Carrera carrera) {

		Transaction transaction = null;

		try (Session session = HibernateConfig.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			session.delete(carrera);

			transaction.commit();

		} catch (Exception e) {

			if (transaction != null)

				transaction.rollback();

			e.printStackTrace();

		}

	}
	
}

