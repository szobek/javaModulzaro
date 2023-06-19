package feladat2;

public class Ingatlan {
	private String tulajdonos;
	private String helyrajziSzam;
	private int alapTerulet;
	private int becsultErtek;

	public Ingatlan(String tulajdonos, String helyrajziSzam, int alapTerulet, int becsultErtek) {
		this.tulajdonos = tulajdonos;
		this.helyrajziSzam = helyrajziSzam;
		this.alapTerulet = alapTerulet;
		this.becsultErtek = becsultErtek;
	}

	public String getTulajdonos() {
		return tulajdonos;
	}

	public String getHelyrajziSzam() {
		return helyrajziSzam;
	}

	public int getAlapTerulet() {
		return alapTerulet;
	}

	public int getBecsultErtek() {
		return becsultErtek;
	}
	

	public void setBecsultErtek(int becsultErtek) {
		this.becsultErtek = becsultErtek;
	}

	@Override
	public String toString() {
		return "Ingatlan [tulajdonos=" + tulajdonos + ", helyrajziSzam=" + helyrajziSzam + ", alapTerulet="
				+ alapTerulet + ", becsultErtek=" + becsultErtek + "]";
	}
	
	
	
	
}
