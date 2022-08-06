package ticketsystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "biletler")
public class Bilet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	private Sefer sefer;
	
	@OneToOne
	private Yolcu yolcu;
	
	public Bilet(int id, Sefer sefer, Yolcu yolcu) {
		super();
		this.id = id;
		this.sefer = sefer;
		this.yolcu = yolcu;
	}
	
	public Bilet() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Sefer getSefer() {
		return sefer;
	}

	public void setSefer(Sefer sefer) {
		this.sefer = sefer;
	}

	public Yolcu getYolcu() {
		return yolcu;
	}

	public void setYolcu(Yolcu yolcu) {
		this.yolcu = yolcu;
	}
	
	
	
}
