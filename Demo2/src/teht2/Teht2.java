package teht2;
import java.util.ArrayList;

class Jalkapallopelaaja{
	private String nimi;
	private int numero;
	private String pelipaikka;
	
	public Jalkapallopelaaja(String nimi, int numero, String pelipaikka) {
		this.nimi = nimi;
		this.numero = numero;
		this.pelipaikka = pelipaikka;
	}
	public Jalkapallopelaaja() {
		this.nimi = "";
		this.numero = 0;
		this.pelipaikka = "vaihtopenkki";
	}
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getPelipaikka() {
		return pelipaikka;
	}
	public void setPelipaikka(String pelipaikka) {
		this.pelipaikka = pelipaikka;
	}
	@Override
	public String toString() {
		return "Nimi: " + this.nimi + ", numero: " + this.numero + ", pelipaikka: " + this.pelipaikka;
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(obj.getClass() != Jalkapallopelaaja.class) {
			return false;
		}
		
		Jalkapallopelaaja toinen = (Jalkapallopelaaja) obj;
		
		return(nimi.equals(toinen.getNimi()) && numero == toinen.getNumero() && pelipaikka.equals(toinen.getPelipaikka()));
	}
}

class Jalkapallojoukkue{
	ArrayList<Jalkapallopelaaja> joukkue;
	private String nimi;
	private String kotistadion;
	
	public Jalkapallojoukkue(String nimi, String kotistadion) {
		this.nimi = nimi;
		this.kotistadion = kotistadion;
		joukkue = new ArrayList<>();
	}
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	public String getKotistadion() {
		return kotistadion;
	}
	public void setKotistadion(String kotistadion) {
		this.kotistadion = kotistadion;
	}
	public void lisaaPelaaja(Jalkapallopelaaja pelaaja) {
		int m = 0;
		if(joukkue.size() < 22 && joukkue.size() > 0) {
			if(pelaaja.getPelipaikka().equals("maalivahti")) {
				for(Jalkapallopelaaja peluri : joukkue) {
					if(peluri.getPelipaikka().equals("maalivahti")) {
						m++;
					}
				}
				if(m < 2) {
					joukkue.add(pelaaja);
				}
			}else {
				joukkue.add(pelaaja);
			}
		}else {
			joukkue.add(pelaaja);
		}
	}
	@Override
	public String toString() {
		return "Nimi: " + nimi + " kotistadion: " + kotistadion + " pelaajat: " + joukkue;
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(obj.getClass() != Jalkapallojoukkue.class) {
			return false;
		}
		Jalkapallojoukkue toinen = (Jalkapallojoukkue) obj;
		
		return (this.nimi.equals(toinen.getNimi()));
	}
}

public class Teht2 {

	public static void main(String[] args) {
		Jalkapallopelaaja pelaaja1 = new Jalkapallopelaaja("Ronaldo", 7, "hyökkääjä");
		Jalkapallopelaaja pelaaja2 = new Jalkapallopelaaja("Messi", 30, "hyökkääjä");
		Jalkapallopelaaja pelaaja3 = new Jalkapallopelaaja("Casillas", 1, "maalivahti");
		Jalkapallopelaaja pelaaja4 = new Jalkapallopelaaja("Ramos", 4, "puolustaja");
		Jalkapallopelaaja pelaaja5 = new Jalkapallopelaaja("Kroos", 8, "keskikenttä");
		System.out.println(pelaaja1.toString());
		Jalkapallojoukkue joukkue1 = new Jalkapallojoukkue("Mestarit", "Camp Nou");
		joukkue1.lisaaPelaaja(pelaaja1);
		joukkue1.lisaaPelaaja(pelaaja2);
		joukkue1.lisaaPelaaja(pelaaja3);
		System.out.println(joukkue1.toString());

	}

}
