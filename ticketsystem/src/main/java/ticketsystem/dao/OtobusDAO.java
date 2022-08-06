package ticketsystem.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ticketsystem.DbHelper;
import ticketsystem.model.Otobus;

public class OtobusDAO {

	public static void save(Otobus o) {
		Session ses = DbHelper.getSession();
		Transaction tr = ses.beginTransaction();
		
		ses.save(o);
		
		tr.commit();
		ses.close();
	}

	public static List<Otobus> getAll() {
		Session ses = DbHelper.getSession();
		Transaction tr = ses.beginTransaction();
		
		Query<Otobus> q = ses.createQuery("from Otobus");
		
		List<Otobus> oler = q.list();
		
		tr.commit();
		ses.close();
		
		return oler;
	}

}
