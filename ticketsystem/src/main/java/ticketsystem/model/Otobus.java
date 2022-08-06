package ticketsystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "otobusler")
public class Otobus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String marka;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "otobus")
	private Sefer sefer;
	
	
	public Otobus(int id, String marka, Sefer sefer) {
		super();
		this.id = id;
		this.marka = marka;
		this.sefer = sefer;
	}
	
	public Otobus() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public Sefer getSefer() {
		return sefer;
	}

	public void setSefer(Sefer sefer) {
		this.sefer = sefer;
	}
	
	
	@Override
	public String toString() {
		
		return "Otobüs: " + marka +"\n" + sefer;
	}
	
	
}
