package ticketsystem.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ticketsystem.DbHelper;
import ticketsystem.model.*;

public class SeferDAO {

	public static void save(Sefer sefer) {
		Session ses = DbHelper.getSession();
		Transaction tr = ses.beginTransaction();
		
		ses.save(sefer);
		
		tr.commit();
		
		ses.close();
	}

	public static List<Sefer> getAll() {
		Session ses = DbHelper.getSession();
		Transaction tr = ses.beginTransaction();
		
		Query<Sefer> q = ses.createQuery("from Sefer");
		
		List<Sefer> seferler = q.list();
		
		tr.commit();
		
		ses.close();
		
		return seferler;
	}

	public static void delete(Sefer s) {
		Session ses = DbHelper.getSession();
		Transaction tr = ses.beginTransaction();
		
		ses.delete(s);

		tr.commit();
		ses.close();
	}

	public static Sefer getById(int seferId) {
		Session ses = DbHelper.getSession();
		Transaction tr = ses.beginTransaction();
		
		Sefer s = ses.get(Sefer.class, seferId);
		
		tr.commit();
		ses.close();
		
		return s;
	}
}
