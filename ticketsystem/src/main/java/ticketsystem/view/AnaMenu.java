package ticketsystem.view;

import java.util.List;
import java.util.Scanner;

import ticketsystem.DbHelper;
import ticketsystem.dao.OtobusDAO;
import ticketsystem.dao.OtogarDAO;
import ticketsystem.dao.SeferDAO;
import ticketsystem.model.*;


public class AnaMenu {

	public static void anaMenu() {
		Scanner scn = new Scanner(System.in);
		
		while(true) {
			System.out.println("Admin -> 1");
			System.out.println("Yolcu -> 2");
			System.out.println("Çýkýþ -> 3");
			
			int secim = scn.nextInt(); scn.nextLine();
			
			if (secim == 3) {
				System.out.println("Program sonlandýrýldý!");
				break;
			}else if ( secim == 1) {
				adminMenu(scn);
			}else if ( secim == 2) {
				yolcuMenu(scn);
			}else  {
				System.out.println("Hatalý seçim");
			}
			
		}
		
	}

	private static void yolcuMenu(Scanner scn) {
		// TODO Auto-generated method stub
		
	}

	private static void adminMenu(Scanner scn) {
		
		while(true) {
			System.out.println("Otogar iþlemleri -> 1");
			System.out.println("Otobüs iþlemleri -> 2");
			System.out.println("Sefer iþlemleri -> 3");
			System.out.println("üst menü-> 4");
			
			int secim = scn.nextInt(); scn.nextLine();
			
			if (secim == 4) {
				System.out.println("Üst menü");
				break;
			}else if ( secim == 1) {
				otogarMenu(scn);
			}else if ( secim == 2) {
				otobusMenu(scn);
			}else if ( secim == 3) {
				seferMenu(scn);
			}else {
				System.out.println("Hatalý seçim");
			}
			
		}
		
	}

	private static void seferMenu(Scanner scn) {
		while(true) {
			System.out.println("Sefer Ýþlemleri");
			System.out.println("ekle -> 1");
			System.out.println("görüntüle-> 2");
			System.out.println("sil -> 3");
			System.out.println("üst menü -> 4");
			
			int secim = scn.nextInt(); scn.nextLine();
			
			if (secim == 4) {
				System.out.println("Üst menü");
				break;
			}else if ( secim == 1) {
				List<Otogar> otogarlar = OtogarDAO.getAll();
				System.out.println("Kalkýþ otogarý seçin:");
				otogarlarýEkranaYazdýr();
				int kalkisId = scn.nextInt(); scn.nextLine();
				System.out.println("Varýþ otogarý seçin:");
				otogarlarýEkranaYazdýr();
				int varisId = scn.nextInt(); scn.nextLine();
				
				Otogar kalkis = null;
				Otogar varis = null;
				
				for (Otogar o : otogarlar) {
					if(kalkisId == o.getId()) kalkis = o;
					
					if(varisId == o.getId()) varis = o;
				}
				
				Sefer s = new Sefer();
				s.setKalkis(kalkis);
				s.setVaris(varis);
				
				SeferDAO.save(s);
				
			}else if ( secim == 2) {
				seferleriYazdir();
			}else if ( secim == 3) {
				System.out.println("Silinecek seferi seçin: ");
				seferleriYazdir();
				int id = scn.nextInt(); scn.nextLine();
				List<Sefer> seferler = SeferDAO.getAll();
				
				Sefer s = null;
				
				for (Sefer a : seferler) 
					if (a.getId() == id) 
						s = a; 
				
				SeferDAO.delete(s);
				
			}else {
				System.out.println("Hatalý seçim");
			}
			
		}
		
	}

	private static void seferleriYazdir() {
		
		List<Sefer> seferler = SeferDAO.getAll();
		
		System.out.println("--------------------");
		for (Sefer s : seferler) {
			System.out.println(s);
		}
		System.out.println("--------------------");
		
	}

	private static void otobusMenu(Scanner scn) {
		while(true) {
			System.out.println("Otobüs Ýþlemleri");
			System.out.println("ekle -> 1");
			System.out.println("görüntüle-> 2");
			System.out.println("sil -> 3");
			System.out.println("üst menü -> 4");
			
			int secim = scn.nextInt(); scn.nextLine();
			
			if (secim == 4) {
				System.out.println("Üst menü");
				break;
			}else if ( secim == 1) {
				System.out.print("Marka: ");
				String marka = scn.nextLine();
				System.out.println("Sefer seçin:");
				seferleriYazdir();
				int seferId = scn.nextInt(); scn.nextLine();
				Sefer s = SeferDAO.getById(seferId);
				
				Otobus o = new Otobus();
				o.setMarka(marka);
				o.setSefer(s);
				s.setOtobus(o);
				
				OtobusDAO.save(o);
				
			}else if ( secim == 2) {
				otobusleriYazdir();
			}else if ( secim == 3) {
				
			}else {
				System.out.println("Hatalý seçim");
			}
			
		}
		
	}

	private static void otobusleriYazdir() {
		List<Otobus> otobusler = OtobusDAO.getAll();
		
		System.out.println("--------------------");
		for (Otobus o : otobusler) {
			System.out.println(o);
		}
		System.out.println("--------------------");
	}

	private static void otogarMenu(Scanner scn) {
		while(true) {
			System.out.println("Otogar Ýþlemleri");
			System.out.println("ekle -> 1");
			System.out.println("görüntüle-> 2");
			System.out.println("sil -> 3");
			System.out.println("güncelle -> 5");
			System.out.println("üst menü -> 4");
			
			int secim = scn.nextInt(); scn.nextLine();
			
			if (secim == 4) {
				System.out.println("Üst menü");
				break;
			}else if ( secim == 1) {
				System.out.print("Otogarýn adý: ");
				String isim = scn.nextLine();
				System.out.print("Otogarýn þehri: ");
				String sehirStr = scn.nextLine();
				
				try { 
					Sehir sehir = Sehir.valueOf(sehirStr.toUpperCase());
					Otogar o = new Otogar();
					o.setIsim(isim);
					o.setLokasyon(sehir);
					
					OtogarDAO.save(o);
				}catch (Exception e) {
					
					System.out.println("Hatalý þehir ismi girildi");
					
				}
				
				
			}else if ( secim == 2) {
				System.out.println("Kayýtlý Otogarlar");
				otogarlarýEkranaYazdýr();
			}else if ( secim == 3) {
				System.out.println("silmek istediðiniz otogarý seçin: ");
				List<Otogar> otogarlar = OtogarDAO.getAll();
				otogarlarýEkranaYazdýr();
				int silinecekId = scn.nextInt(); scn.nextLine();
				
				Otogar o = null;
				
				for(Otogar a : otogarlar) {
					if(silinecekId == a.getId()) {
						o = a;
					}
				}
				
				OtogarDAO.delete(o);
				
			}else if ( secim == 5) {
				System.out.println("Güncellemek istedðiniz otogarý seçin:");
				List<Otogar> otogarlar = OtogarDAO.getAll();
				otogarlarýEkranaYazdýr();
				
				int id = scn.nextInt(); scn.nextLine();
				Otogar o = null;
				for (Otogar a : otogarlar) {
					if(a.getId() == id) {
						o = a;
					}
				}
				
				System.out.print("Yeni isim: ");
				String isim = scn.nextLine();
				System.out.print("Yeni þehir: ");
				Sehir sehir = Sehir.valueOf(scn.nextLine().toUpperCase());
				
				o.setIsim(isim);
				o.setLokasyon(sehir);
				
				OtogarDAO.update(o);
				
			}else {
				System.out.println("Hatalý seçim");
			}
			
		}
		
	}

	private static void otogarlarýEkranaYazdýr() {

		List<Otogar> otogarlar = OtogarDAO.getAll();
		
		System.out.println("--------------------");
		for (Otogar o : otogarlar) {
			System.out.println(o);
		}
		System.out.println("--------------------");
		
	}
}
