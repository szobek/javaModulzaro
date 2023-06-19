package feladat1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.random.RandomGenerator;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		RandomGenerator rg = RandomGenerator.getDefault();
		Versenyzo[] versenyzok = new Versenyzo[5];
		String[] versenyzokNevei = { "Franciska", "Tibor", "Zsolt", "Erika", "Lajos" };
		int[] pontok = { 467, 486, 478, 481, 472 };
		for (int i = 0; i < versenyzokNevei.length; i++) {
			versenyzok[i] = new Versenyzo(versenyzokNevei[i], "v000" + (i + 1), pontok[i]);
		}
		
		for (int i = 0 ;i<5;i++) { //körök
			System.out.println((i+1)+". kör: ");
			for (int j = 0 ;j<versenyzok.length;j++) { //versenyzõ
				versenyzok[j].loves();
				System.out.println(versenyzok[j].rekordEllenorzes(i));
				if (i==4  && (versenyzok[j].getRekord()<versenyzok[j].countAllPoints())) {
					versenyzok[j].setRekord(versenyzok[j].countAllPoints());
				}
					
			}	
		}
	
		getWinner(versenyzok);
	}
	/**
	 * find the winner by the max point
	 * @param versenyzok
	 */
	private static void getWinner(Versenyzo[] versenyzok) {
		int winnerIndex = 0;
		for(int i=1;i<versenyzok.length;i++) {
			if(versenyzok[winnerIndex].countAllPoints()<versenyzok[i].countAllPoints()) {
				winnerIndex=i;
			}
		}
		System.out.println("\nA gyõztes: " + versenyzok[winnerIndex].getNev() +" "+versenyzok[winnerIndex].countAllPoints() +" ponttal");
		writeFile(versenyzok);
	}
	/**
	 * write a file with list elements, the delimiter is ";", and the filename is ""versenyzo.csv"
	 * @param versenyzok
	 */
	private static void writeFile(Versenyzo[] versenyzok)	 {
		try(OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("versenyzo.csv"), "UTF-8")){
			char delimiter=';';
			

			for(int i=0;i<versenyzok.length;i++) {
				writer.write(versenyzok[i].getNev()+delimiter+versenyzok[i].getRajtazonosito()+delimiter+versenyzok[i].getRekord()+"\n");
			}
			
			JOptionPane.showMessageDialog(null, "Fájlírás kész van","Fájlírás",JOptionPane.INFORMATION_MESSAGE);
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"I/O hiba", JOptionPane.WARNING_MESSAGE);}
		
	}
}
