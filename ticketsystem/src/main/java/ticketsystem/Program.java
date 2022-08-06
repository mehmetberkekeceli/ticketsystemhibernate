package ticketsystem;

import ticketsystem.view.AnaMenu;

public class Program {

	public static void main(String[] args) {
		
		DbHelper.getSession().close();
		
		AnaMenu.anaMenu();
		
		
		DbHelper.close();

	}

}
