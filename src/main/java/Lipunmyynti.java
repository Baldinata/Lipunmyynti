import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Lipunmyynti {
	private Map<Profiili, Paasylippu> myydytLiput;
	private double myyneetYhteensa;
	private int indeksi = 1;
	private double EiAlennettuHintaYhteensa;

	public Lipunmyynti() {
		this.myydytLiput = new HashMap<>();
	}

	public void lisaaMappiin(Profiili profiili, Paasylippu paasyLippu) {
		myydytLiput.put(profiili, paasyLippu);
	}

	public int myytyjaLippuja() {
		return myydytLiput.size();
	}

	public double alkuperainenHintaYhteensa(Paasylippu paasylippu) {
		double hinta = paasylippu.getHinta();
		return hinta;
	}

	public double laskeHinta(Profiili profiili, Paasylippu paasylippu) {
		double alennus = 1.0 * profiili.getAlennusProsentti() / 100 * 1.0;
		double hinta = paasylippu.getHinta();
		double laskettuHinta = hinta - (hinta * alennus);
		double pyoritettyHinta = (double) Math.round(laskettuHinta * 100) / 100;
		return pyoritettyHinta;
	}

	public String laskeHintaPyoristetty(Profiili profiili, Paasylippu paasylippu) {
		double pyoritettyHinta = laskeHinta(profiili, paasylippu);
		if (BigDecimal.valueOf(profiili.getAlennusProsentti()).compareTo(BigDecimal.ZERO) == 0) {
			return " koko summa, ei alennuksia" + " = " + pyoritettyHinta + " " + UnicodeMerkit.EURO_MERKKI;
		}
		return UnicodeMerkit.PYORISTYS_MERKKI + " " + pyoritettyHinta + " " + UnicodeMerkit.EURO_MERKKI;

	}

	private void myydytLiput() {
		System.out.println("\tLista myydyista lipuista \n");

		myydytLiput.entrySet().forEach(x -> {
			System.out.println("\t" + this.indeksi++ + ". Lippu " + UnicodeMerkit.TAHTI_MERKKI + "\n"
					+ (x.getKey() + " " + x.getValue()));
			System.out.println("\tMaksettava " + laskeHintaPyoristetty(x.getKey(), x.getValue()));
			double maksettavaMaara = laskeHinta(x.getKey(), x.getValue());
			this.myyneetYhteensa += maksettavaMaara;
			System.out.println();
			double alkuperainenHinta = (alkuperainenHintaYhteensa(x.getValue()));
			this.EiAlennettuHintaYhteensa += alkuperainenHinta;
		});
		System.out.println(
				"\t" + UnicodeMerkit.TAHDET_MERKKI + " " + "Yhteen veto myynnista" + " " + UnicodeMerkit.TAHDET_MERKKI);
		System.out.print("\n\t" + UnicodeMerkit.SORMI_MERKKI + " " + "Todellinen arvo yhteensa" + " "
				+ UnicodeMerkit.PYORISTYS_MERKKI + " " + (this.EiAlennettuHintaYhteensa));
		System.out.print("\n\t" + UnicodeMerkit.SORMI_MERKKI + " " + "Alennuksien arvo yhteensa "
				+ UnicodeMerkit.PYORISTYS_MERKKI + " " + (this.myyneetYhteensa - this.EiAlennettuHintaYhteensa));
		System.out.print("\n\t" + UnicodeMerkit.SORMI_MERKKI + " " + "Alennuksen jalkeen lippujen arvo "
				+ UnicodeMerkit.PYORISTYS_MERKKI + " " + this.myyneetYhteensa);
		System.out.print(
				"\n\t" + UnicodeMerkit.SORMI_MERKKI + " " + "Myytyjen lippujen maara = " + myydytLiput.size() + " kpl");

	}

	@Override
	public String toString() {
		myydytLiput();
		return "";
	}
}
