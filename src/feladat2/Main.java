package feladat2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

	private List<Ingatlan> ingatlanok = new ArrayList<Ingatlan>();
	Scanner sc = new Scanner(System.in);
	String hsz;

	public static void main(String[] args) {
		new Main().runApp();

	}

	private void runApp() {
		
		DbHandle db = new DbHandle();
		db.fillList(ingatlanok);
		showMenu();
		
	}
/**
 * show menu and swich by menuitem
 */
	private void showMenu() {

		String menuItem = "";

		while (!menuItem.equals("5")) {
			System.out.println("1. �sszes ingatlan list�z�sa");
			System.out.println("2. Keres�s helyrajzi sz�m alapj�n");
			System.out.println("3. T�rl�s helyrajzi sz�m alapj�n");
			System.out.println("4. Becs�lt �rt�k m�dos�t�sa helyrajzi sz�m alapj�n");
			System.out.println("5. Kil�p�s");
			System.out.println();

			System.out.print("Melyik men�t v�lasztja?: ");
			menuItem = sc.nextLine();
			switch (menuItem) {
			case "1":
				listAllHouse();
				break;
			case "2":
				searchByHSz();
				break;
			case "3":
				deleteByHSz();
				break;
			case "4":
				modifyPriceByHSz();
				break;
			case "5":
				break;
			default:
				System.out.println("Ismeretlen men�pont \n\n");
			}
		}

	}
/**
 * Modify house price by hsz
 */
	private void modifyPriceByHSz() {
		int index = getHouseByHSz();
		if (index > -1) {
			System.out.println("Adja meg az �j �rat:");
			int ar;
			try {
				ar = Integer.parseInt(sc.nextLine());
				ingatlanok.get(index).setBecsultErtek(ar);
				DbHandle db = new DbHandle();
				db.modifyPriceByhSz(hsz, ar);
				System.out.println("Becs�lt �rt�k m�dos�tva\n\n");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Hiba konvert�l�sn�l: " + e.getMessage());
			}

		}

	}
/**
 * Delete house from list and db
 */
	private void deleteByHSz() {
		int index = getHouseByHSz();
		if (index > -1) {
			ingatlanok.remove(ingatlanok.get(index));
			DbHandle db = new DbHandle();
			db.deleteHouseByHsz(hsz);
			
			System.out.println("Ingatlan t�r�lve \n \n");
		}

	}

	private void searchByHSz() {
		int index = getHouseByHSz();
		if (index > -1) {
			System.out.println(ingatlanok.get(index).toString() + "\n");
		}

	}
/**
 * list all elem in list
 */
	private void listAllHouse() {
		System.out.println("\n lista \n");
		for (Ingatlan ingatlan : ingatlanok) {
			System.out.println(ingatlan.toString());
		}

		System.out.println();
		System.out.println("List�z�s v�ge");
		System.out.println();
	}
	
	/**
	 * search house by hsz
	 * @return
	 */

	private int getHouseByHSz() {
		System.out.print("Adja meg a helyajzi sz�mot:");
		String helyrajzi_szam = sc.nextLine();
		int ingatlanIndex = -1;
		for (int i = 0; i < ingatlanok.size(); i++) {
			if (ingatlanok.get(i).getHelyrajziSzam().equalsIgnoreCase(helyrajzi_szam)) {
				ingatlanIndex = i;
			}
		}
		if (ingatlanIndex == -1) {
			System.out.println("Nincs ilyen ingatlan... \n");

		} else {
			hsz = helyrajzi_szam;
		}

		return ingatlanIndex;
	}
}
