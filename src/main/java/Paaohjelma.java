
public class Paaohjelma {

	public static void main(String[] args) {
		Lipunmyynti lippu = new Lipunmyynti();

		Paasylippu elokuvat = new Paasylippu("Elokuva", 18);
		Paasylippu naytelma = new Paasylippu("Naytelma", 55);

		Profiili mikko = new Profiili("Opiskelija", 22);
		Profiili elisa = new Profiili("Opiskelija", 25);
		Profiili juha = new Profiili("Henkilo", 50);
		Profiili timo = new Profiili("Elakelainen", 60);
		Profiili eero = new Profiili("Tyoton", 35);
		Profiili heikki = new Profiili("Henkilo ", 59);
		Profiili matti = new Profiili("Henkilo ", 62);
		Profiili samu = new Profiili("Henkilo ", 43);
		Profiili kirsi = new Profiili("Henkilo ", 36);
		Profiili ruusu = new Profiili("Opiskelija", 34);
		Profiili joel = new Profiili("Työtön", 34);
		Profiili samuel = new Profiili("Henkilo ", 57);
		Profiili heidi = new Profiili("Henkilo ", 28);
		Profiili katri = new Profiili("Opiskelija", 24);
		Profiili marika = new Profiili("Tyoton", 34);

		lippu.lisaaMappiin(mikko, elokuvat);
		lippu.lisaaMappiin(elisa, elokuvat);
		lippu.lisaaMappiin(juha, naytelma);
		lippu.lisaaMappiin(timo, elokuvat);
		lippu.lisaaMappiin(eero, elokuvat);
		lippu.lisaaMappiin(heikki, elokuvat);
		lippu.lisaaMappiin(matti, naytelma);
		lippu.lisaaMappiin(samu, elokuvat);
		lippu.lisaaMappiin(ruusu, elokuvat);
		lippu.lisaaMappiin(kirsi, elokuvat);
		lippu.lisaaMappiin(joel, elokuvat);
		lippu.lisaaMappiin(samuel, naytelma);
		lippu.lisaaMappiin(heidi, naytelma);
		lippu.lisaaMappiin(katri, naytelma);
		lippu.lisaaMappiin(marika, naytelma);
		
		lippu.tulostaaKaikkiMyydytLiputJaTiedot();
	}
}
