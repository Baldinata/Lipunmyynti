import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class lipunMyyntiMockitoTest {
	Lipunmyynti lipunmyynti;

	@Mock
	Paasylippu elokuvatMok;
	@Mock
	Profiili mikkoHenkilo;
	@Mock
	Paasylippu elokuvatMok2;
	@Mock
	Profiili mikkoHenkilo2;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test() {
		lipunmyynti = new Lipunmyynti();

		doNothing().when(elokuvatMok).setHinta(20.0);
		lipunmyynti.lisaaMappiin(mikkoHenkilo, elokuvatMok);
		lipunmyynti.lisaaMappiin(mikkoHenkilo2, elokuvatMok2);
		assertEquals(2, lipunmyynti.myytyjaLippuja());
		assertEquals(0.0, lipunmyynti.laskeHinta(mikkoHenkilo, elokuvatMok), 0.000001);

	}

}
