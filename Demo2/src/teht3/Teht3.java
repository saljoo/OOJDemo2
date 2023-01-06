package teht3;
import java.util.ArrayList;

class Henkilo{
	protected String etunimi;
	protected String sukunimi;
	protected String sahkoposti;
	
	public Henkilo(String etunimi, String sukunimi, String sahkoposti) {
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.sahkoposti = sahkoposti;
	}
	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}
	public String getEtunimi() {
		return etunimi;
	}
	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}
	public String getSukunimi() {
		return sukunimi;
	}
	public void setSahkoposti(String sahkoposti) {
		this.sahkoposti = sahkoposti;
	}
	public String getSahkoposti() {
		return sahkoposti;
	}
}

class Asiakas extends Henkilo{
	private String toimitusOsoite;
	
	public Asiakas(String etunimi, String sukunimi, String sahkoposti, String toimitusOsoite) {
		super(etunimi, sukunimi, sahkoposti);
		this.toimitusOsoite = toimitusOsoite;
	}
	public void setOsoite(String osoite) {
		this.toimitusOsoite = osoite;
	}
	public String getOsoite() {
		return toimitusOsoite;
	}
	public String toString() {
		return "Nimi: " + etunimi + " " + sukunimi + ", s‰hkˆposti: " + sahkoposti + ", osoite: " + toimitusOsoite;
	}
}

class Tyontekija extends Henkilo{
	private String osoite;
	private int tyontekijanumero;
	
	public Tyontekija(String etunimi, String sukunimi, String sahkoposti, String osoite, int tyontekijanumero) {
		super(etunimi, sukunimi, sahkoposti);
		this.osoite = osoite;
		this.tyontekijanumero = tyontekijanumero;
	}
	public void setOsoite(String osoite) {
		this.osoite = osoite;
	}
	public String getOsoite() {
		return osoite;
	}
	public void setTyontekijanumero(int tyontekijanumero) {
		this.tyontekijanumero = tyontekijanumero;
	}
	public int getTyontekijanumero() {
		return tyontekijanumero;
	}
}

class Tuoteryhma{
	protected String ryhma;
	protected ArrayList<Tuote> tuoteRyhma;
	
	public Tuoteryhma(String ryhma) {
		this.ryhma = ryhma;
		tuoteRyhma = new ArrayList<>();
	}
	public void setRyhma(String ryhma) {
		this.ryhma = ryhma;
	}
	public String getRyhma() {
		return ryhma;
	}
	public void lisaaTuoteryhmaan(Tuote tuote) {
		if(this.ryhma.equals(tuote.getRyhma())) {
			tuoteRyhma.add(tuote);
		}else {
			System.out.println("Tuote ei kuulu kyseiseen tuoteryhm‰‰n.");
		}
	}
	public String toString() {
		return "" + tuoteRyhma;
	}
}

class Tuote extends Tuoteryhma{
	private String tuotenimi;
	private String vari;
	private String koko;
	private double hinta;
	
	public Tuote(String ryhma, String tuotenimi, String vari, String koko, double hinta) {
		super(ryhma);
		this.tuotenimi = tuotenimi;
		this.vari = vari;
		this.koko = koko;
		this.hinta = hinta;
	}
	public void setTuotenimi(String tuotenimi) {
		this.tuotenimi = tuotenimi;
	}
	public String getTuotenimi() {
		return tuotenimi;
	}
	public void setVari(String vari) {
		this.vari = vari;
	}
	public String getVari() {
		return vari;
	}
	public void setKoko(String koko) {
		this.koko = koko;
	}
	public String getKoko() {
		return koko;
	}
	public void setHinta(double hinta) {
		this.hinta = hinta;
	}
	public double getHinta() {
		return hinta;
	}
	public String toString() {
		return "Ryhm‰: " + ryhma + ", tuotenimi: " + tuotenimi + ", v‰ri: " + vari + ", koko: " + "hinta: " + hinta + "Ä";
	}
}

class Ostotapahtuma{
	private String maksutapa;
	private ArrayList<Tuote> tuotteet = new ArrayList<>();
	private Asiakas ostajanTiedot;
	
	public Ostotapahtuma(String maksutapa, ArrayList<Tuote> tuotteet, Asiakas ostajanTiedot) {
		this.maksutapa = maksutapa;
		this.tuotteet = tuotteet;
		this.ostajanTiedot = ostajanTiedot;
	}
	public void setMaksutapa(String maksutapa) {
		this.maksutapa = maksutapa;
	}
	public String getMaksutapa() {
		return maksutapa;
	}
	public void setTuotteet(ArrayList<Tuote> tuotteet) {
		this.tuotteet = tuotteet;
	}
	public ArrayList<Tuote> getTuotteet(){
		return tuotteet;
	}
	public void setOstajanTiedot(Asiakas ostajanTiedot) {
		this.ostajanTiedot = ostajanTiedot;
	}
	public Asiakas getOstajanTiedot() {
		return ostajanTiedot;
	}
}

public class Teht3 {

	public static void main(String[] args) {
		//Luodaan profiili asiakkaalle
		Asiakas asiakas1 = new Asiakas("Anssi", "Asiakas", "anssi.asiakas@gmail.com", "Asiakkuuskatu 7");
		System.out.println(asiakas1.toString());
		//Luodaan tuoteryhm‰ paidoille
		Tuoteryhma paidat = new Tuoteryhma("Paita");
		//Luodaan tuotteita ja lis‰t‰‰n ne niit‰ vastaavaan tuoteryhm‰‰n
		Tuote tuote1 = new Tuote("Paita", "Miesten t-paita", "musta", "M", 14.95);
		Tuote tuote2 = new Tuote("Paita", "Naisten t-paita", "valkoinen", "S", 12.99);
		paidat.lisaaTuoteryhmaan(tuote1);
		paidat.lisaaTuoteryhmaan(tuote2);
		System.out.println(paidat.toString());
	}
}
