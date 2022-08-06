package ticketsystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "yolcular")
public class Yolcu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String isim;
	private String soyisim;
	
	@OneToOne(cascade = CascadeType.ALL,  mappedBy = "yolcu")
	private Bilet bilet;
	
	
	public Yolcu(int id, String isim, String soyisim, Bilet bilet) {
		super();
		this.id = id;
		this.isim = isim;
		this.soyisim = soyisim;
		this.bilet = bilet;
	}
	
	public Yolcu() {}

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

	public String getSoyisim() {
		return soyisim;
	}

	public void setSoyisim(String soyisim) {
		this.soyisim = soyisim;
	}

	public Bilet getBilet() {
		return bilet;
	}

	public void setBilet(Bilet bilet) {
		this.bilet = bilet;
	}
	
	
}
