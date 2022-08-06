package ticketsystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "seferler")
public class Sefer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	private Otogar kalkis;
	
	@OneToOne
	private Otogar varis;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Otobus otobus;

	public Sefer() {}
	
	public Sefer(int id, Otogar kalkis, Otogar varis) {
		super();
		this.id = id;
		this.kalkis = kalkis;
		this.varis = varis;
	}
	
	public Otobus getOtobus() {
		return otobus;
	}
	public void setOtobus(Otobus otobus) {
		this.otobus = otobus;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Otogar getKalkis() {
		return kalkis;
	}
	public void setKalkis(Otogar kalkis) {
		this.kalkis = kalkis;
	}
	public Otogar getVaris() {
		return varis;
	}
	public void setVaris(Otogar varis) {
		this.varis = varis;
	}
	
	@Override
	public String toString() {
		
		return "Sefer: " + id +" " + kalkis.getIsim() + " --> " + varis.getIsim();
	}
	
	
}
