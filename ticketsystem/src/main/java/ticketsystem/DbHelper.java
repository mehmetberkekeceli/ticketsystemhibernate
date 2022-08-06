package ticketsystem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ticketsystem.model.*;

public class DbHelper {
	
	// Singleton

	private static DbHelper helper;
	private Configuration conf = null;
	private SessionFactory factory = null;
	
	private DbHelper() {
		
		conf = new Configuration();
		conf.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Otogar.class)
			.addAnnotatedClass(Yolcu.class)
			.addAnnotatedClass(Sefer.class)
			.addAnnotatedClass(Otobus.class)
			.addAnnotatedClass(Bilet.class);
		
		factory = conf.buildSessionFactory();
		
	}
	
	public static Session getSession() {
		
		if (helper == null) {
			helper = new DbHelper();
			
			return helper.factory.openSession();
			
		}
			
		return helper.factory.openSession();
		
	}

	public static void close() {
		
		if (helper != null)
			helper.factory.close();
	}
	
	
}
