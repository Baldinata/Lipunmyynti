import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LipunmyyntiTest {
	Lipunmyynti lipunmyynti;
	Paasylippu elokuvat;
	Profiili mikko;
	Profiili inka;

	@Before
	public void setUp() throws Exception {
		elokuvat = new Paasylippu("Elokuva", 18);
		mikko = new Profiili("Opiskelija", 22);
		inka = new Profiili("Nainen", 24);
		lipunmyynti = new Lipunmyynti();

	}

	@Test
	public void laskeHintaTest() {
		lipunmyynti.laskeHinta(mikko, elokuvat);
		assertEquals(13.5, lipunmyynti.laskeHinta(mikko, elokuvat), 0.00001);

	}

	@Test
	public void laskeHintaPyoristettyTest() {
		lipunmyynti.laskeHintaPyoristetty(mikko, elokuvat);
		double hinta1 = lipunmyynti.laskeHinta(mikko, elokuvat);
		double hinta2 = lipunmyynti.laskeHinta(inka, elokuvat);
		assertEquals("pyoristyy: ", UnicodeMerkit.PYORISTYS_MERKKI + " " + hinta1 + " " + UnicodeMerkit.EURO_MERKKI,
				lipunmyynti.laskeHintaPyoristetty(mikko, elokuvat));
		assertEquals("ei pyoristyy: ", " koko summa, ei alennuksia" + " = " + hinta2 + " " + UnicodeMerkit.EURO_MERKKI,
				lipunmyynti.laskeHintaPyoristetty(inka, elokuvat));

	}

	@Test
	public void alkuperaineHintaTest() {
		lipunmyynti.alkuperainenHintaYhteensa(elokuvat);
		assertEquals(18.0, lipunmyynti.alkuperainenHintaYhteensa(elokuvat), 0.0001);
	}

}
