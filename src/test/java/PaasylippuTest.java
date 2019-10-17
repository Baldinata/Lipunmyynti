import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;

public class PaasylippuTest {
	Paasylippu paasylippu;
	private String lippuOstettupvm;
	private String lippuEraantyypvm;

	@Before
	public void setUp() throws Exception {
		paasylippu = new Paasylippu("Teatteri", 30);
		LocalDateTime pvmnow = LocalDateTime.now();
		lippuOstettupvm = pvmnow.format(DateTimeFormatter.ofPattern("dd-MM-yyyy 'Kello: ' HH:mm:ss"));
		LocalDateTime pvmEnd = pvmnow.plusDays(1);
		lippuEraantyypvm = pvmEnd.format(DateTimeFormatter.ofPattern("dd-MM-yyyy 'Kello: ' HH:mm:ss"));
	}

	@Test
	public void lippuOstettupvmTest() {
		paasylippu.getLippuOstettupvm();
		assertEquals(lippuOstettupvm, paasylippu.getLippuOstettupvm());

	}

	@Test
	public void lippuEraantyyTest() {
		paasylippu.getLippuEraantyypvm();
		assertEquals(lippuEraantyypvm, paasylippu.getLippuEraantyypvm());
	}

	@Test
	public void getNimiTest() {
		paasylippu.getNimi();
		assertEquals("Teatteri", paasylippu.getNimi());
	}

	@Test
	public void getHintaTest() {
		paasylippu.getHinta();
		assertEquals(30.0, paasylippu.getHinta(), 0.0001);
	}

}
