package ticketsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "otogarlar")
public class Otogar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String isim;
	
	@Enumerated(EnumType.STRING)
	private Sehir lokasyon;
	
	public Otogar(int id, String isim, Sehir lokasyon) {
		super();
		this.id = id;
		this.isim = isim;
		this.lokasyon = lokasyon;
	}
	
	public Otogar() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public Sehir getLokasyon() {
		return lokasyon;
	}

	public void setLokasyon(Sehir lokasyon) {
		this.lokasyon = lokasyon;
	}
	
	@Override
	public String toString() {
		return id + ": " + isim + ", " + lokasyon.toString() ;
	}
	
}
