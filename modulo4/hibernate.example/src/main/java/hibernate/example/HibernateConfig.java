package hibernate.example;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateConfig {

	private static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) {

			try {

				Configuration configuration = new Configuration();

				Properties settings = new Properties();

				settings.put(Environment.DRIVER, "org.h2.Driver");

				settings.put(Environment.URL, "jdbc:h2:C:\\GLBootCamp\\data\\Alumno.h2");

				settings.put(Environment.USER, "root");

				settings.put(Environment.PASS, "root");

				settings.put(Environment.HBM2DDL_AUTO, "create-drop");

				configuration.setProperties(settings);

				configuration.addAnnotatedClass(Alumno.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()

						.applySettings(configuration.getProperties()).build();

				sessionFactory = configuration.buildSessionFactory(serviceRegistry);

			} catch (Exception e) {

				e.printStackTrace();

			}

		}

		return sessionFactory;
	}
}
