import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LipunmyyntiTest {
	Lipunmyynti lipunmyynti;
	Paasylippu elokuvat;
	Profiili mikko;

	@Before
	public void setUp() throws Exception {
		elokuvat = new Paasylippu("Elokuva", 18);
		mikko = new Profiili("Opiskelija", 22);
		lipunmyynti = new Lipunmyynti();

	}

	@Test
	public void laskeHintaTest() {
		lipunmyynti.laskeHinta(mikko, elokuvat);
		assertEquals(13.5, lipunmyynti.laskeHinta(mikko, elokuvat), 0.00001);

	}

	@Test
	public void alkuperaineHintaTest() {
		lipunmyynti.alkuperainenHintaYhteensa(elokuvat);
		assertEquals(18.0, lipunmyynti.alkuperainenHintaYhteensa(elokuvat), 0.0001);
	}

}
