package feladat1;

import java.util.random.RandomGenerator;

public class Versenyzo implements IModulzaroInterface {
	private String nev;
	private String rajtazonosito;
	private int rekord;
	private RandomGenerator rg = RandomGenerator.getDefault();
	private int arrayIndex = 0;
	private int[] lovesek = new int[5];


	public Versenyzo(String nev, String rajtazonosito, int rekord) {
		this.nev = nev;
		this.rajtazonosito = rajtazonosito;
		this.rekord = rekord;
	}

	public int getRekord() {
		return rekord;
	}

	public void setRekord(int rekord) {
		this.rekord = rekord;
	}

	public String getNev() {
		return nev;
	}

	public String getRajtazonosito() {
		return rajtazonosito;
	}

	//from interface
	@Override
	public int loves() {
		int loves = rg.nextInt(80, 101);
		lovesek[arrayIndex++] = loves;
		return loves;
	}
	
	//from interface
	@Override
	public String rekordEllenorzes(int hanyadikKor) {
		int eddigiPont = countAllPoints();
		int maxEnnyitErhetEl = countAllPoints()+((4-hanyadikKor)*100);
		String maxpont = "";
		
		switch(hanyadikKor) {
		case 0:
		case 1:
		case 2:
		case 3:
			maxpont=((maxEnnyitErhetEl<=rekord) ? " már maxponttal sem dönthet rekordot" : " még dönthet rekordot");
			break;
		case 4:
			maxpont = (eddigiPont>rekord)?"Új egyéni rekord! ("+eddigiPont+")":"Nem döntött egyéni rekordot ("+rekord+")";
		}
		return nev + " " + lovesek[hanyadikKor]+" összesen:"+eddigiPont+" | "+ maxpont;
	}
	  // count elem all points
	public int countAllPoints() {
		int eddigiPont = 0;
		for (int loves : lovesek) {
			eddigiPont += loves;
		}
		return eddigiPont;
		
	}

}
