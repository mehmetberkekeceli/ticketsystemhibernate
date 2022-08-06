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
			System.out.println("��k�� -> 3");
			
			int secim = scn.nextInt(); scn.nextLine();
			
			if (secim == 3) {
				System.out.println("Program sonland�r�ld�!");
				break;
			}else if ( secim == 1) {
				adminMenu(scn);
			}else if ( secim == 2) {
				yolcuMenu(scn);
			}else  {
				System.out.println("Hatal� se�im");
			}
			
		}
		
	}

	private static void yolcuMenu(Scanner scn) {
		// TODO Auto-generated method stub
		
	}

	private static void adminMenu(Scanner scn) {
		
		while(true) {
			System.out.println("Otogar i�lemleri -> 1");
			System.out.println("Otob�s i�lemleri -> 2");
			System.out.println("Sefer i�lemleri -> 3");
			System.out.println("�st men�-> 4");
			
			int secim = scn.nextInt(); scn.nextLine();
			
			if (secim == 4) {
				System.out.println("�st men�");
				break;
			}else if ( secim == 1) {
				otogarMenu(scn);
			}else if ( secim == 2) {
				otobusMenu(scn);
			}else if ( secim == 3) {
				seferMenu(scn);
			}else {
				System.out.println("Hatal� se�im");
			}
			
		}
		
	}

	private static void seferMenu(Scanner scn) {
		while(true) {
			System.out.println("Sefer ��lemleri");
			System.out.println("ekle -> 1");
			System.out.println("g�r�nt�le-> 2");
			System.out.println("sil -> 3");
			System.out.println("�st men� -> 4");
			
			int secim = scn.nextInt(); scn.nextLine();
			
			if (secim == 4) {
				System.out.println("�st men�");
				break;
			}else if ( secim == 1) {
				List<Otogar> otogarlar = OtogarDAO.getAll();
				System.out.println("Kalk�� otogar� se�in:");
				otogarlar�EkranaYazd�r();
				int kalkisId = scn.nextInt(); scn.nextLine();
				System.out.println("Var�� otogar� se�in:");
				otogarlar�EkranaYazd�r();
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
				System.out.println("Silinecek seferi se�in: ");
				seferleriYazdir();
				int id = scn.nextInt(); scn.nextLine();
				List<Sefer> seferler = SeferDAO.getAll();
				
				Sefer s = null;
				
				for (Sefer a : seferler) 
					if (a.getId() == id) 
						s = a; 
				
				SeferDAO.delete(s);
				
			}else {
				System.out.println("Hatal� se�im");
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
			System.out.println("Otob�s ��lemleri");
			System.out.println("ekle -> 1");
			System.out.println("g�r�nt�le-> 2");
			System.out.println("sil -> 3");
			System.out.println("�st men� -> 4");
			
			int secim = scn.nextInt(); scn.nextLine();
			
			if (secim == 4) {
				System.out.println("�st men�");
				break;
			}else if ( secim == 1) {
				System.out.print("Marka: ");
				String marka = scn.nextLine();
				System.out.println("Sefer se�in:");
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
				System.out.println("Hatal� se�im");
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
			System.out.println("Otogar ��lemleri");
			System.out.println("ekle -> 1");
			System.out.println("g�r�nt�le-> 2");
			System.out.println("sil -> 3");
			System.out.println("g�ncelle -> 5");
			System.out.println("�st men� -> 4");
			
			int secim = scn.nextInt(); scn.nextLine();
			
			if (secim == 4) {
				System.out.println("�st men�");
				break;
			}else if ( secim == 1) {
				System.out.print("Otogar�n ad�: ");
				String isim = scn.nextLine();
				System.out.print("Otogar�n �ehri: ");
				String sehirStr = scn.nextLine();
				
				try { 
					Sehir sehir = Sehir.valueOf(sehirStr.toUpperCase());
					Otogar o = new Otogar();
					o.setIsim(isim);
					o.setLokasyon(sehir);
					
					OtogarDAO.save(o);
				}catch (Exception e) {
					
					System.out.println("Hatal� �ehir ismi girildi");
					
				}
				
				
			}else if ( secim == 2) {
				System.out.println("Kay�tl� Otogarlar");
				otogarlar�EkranaYazd�r();
			}else if ( secim == 3) {
				System.out.println("silmek istedi�iniz otogar� se�in: ");
				List<Otogar> otogarlar = OtogarDAO.getAll();
				otogarlar�EkranaYazd�r();
				int silinecekId = scn.nextInt(); scn.nextLine();
				
				Otogar o = null;
				
				for(Otogar a : otogarlar) {
					if(silinecekId == a.getId()) {
						o = a;
					}
				}
				
				OtogarDAO.delete(o);
				
			}else if ( secim == 5) {
				System.out.println("G�ncellemek isted�iniz otogar� se�in:");
				List<Otogar> otogarlar = OtogarDAO.getAll();
				otogarlar�EkranaYazd�r();
				
				int id = scn.nextInt(); scn.nextLine();
				Otogar o = null;
				for (Otogar a : otogarlar) {
					if(a.getId() == id) {
						o = a;
					}
				}
				
				System.out.print("Yeni isim: ");
				String isim = scn.nextLine();
				System.out.print("Yeni �ehir: ");
				Sehir sehir = Sehir.valueOf(scn.nextLine().toUpperCase());
				
				o.setIsim(isim);
				o.setLokasyon(sehir);
				
				OtogarDAO.update(o);
				
			}else {
				System.out.println("Hatal� se�im");
			}
			
		}
		
	}

	private static void otogarlar�EkranaYazd�r() {

		List<Otogar> otogarlar = OtogarDAO.getAll();
		
		System.out.println("--------------------");
		for (Otogar o : otogarlar) {
			System.out.println(o);
		}
		System.out.println("--------------------");
		
	}
}
