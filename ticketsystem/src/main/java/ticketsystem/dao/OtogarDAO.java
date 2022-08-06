package ticketsystem.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ticketsystem.DbHelper;
import ticketsystem.model.Otogar;

public class OtogarDAO {

	public static void save(Otogar o) {
		
		Session ses = DbHelper.getSession();
		
		Transaction tr = ses.beginTransaction();
		
		ses.persist(o);
		
		tr.commit();
		
		ses.close();
		
	}

	public static List<Otogar> getAll() {
		Session ses = DbHelper.getSession();
		
		Transaction tr = ses.beginTransaction();
		
		Query<Otogar> query = ses.createQuery("from Otogar");
		
		List<Otogar> otogarlar = query.list();
		
		tr.commit();
		
		ses.close();
		
		return otogarlar;
	}

	public static void delete(Otogar o) {
		Session ses = DbHelper.getSession();
		Transaction tr = ses.beginTransaction();

		ses.delete(o);
		
		tr.commit();
		
		ses.close();
		
	}

	public static void update(Otogar o) {
		Session ses = DbHelper.getSession();
		Transaction tr = ses.beginTransaction();

		ses.update(o);
		
		tr.commit();
		
		ses.close();
		
	}

	
}
